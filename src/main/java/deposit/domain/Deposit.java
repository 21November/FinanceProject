package deposit.domain;


import halpers.domain.Domain;
import halpers.domain.FiatCurrency;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class Deposit extends Domain {
    public UUID id;
    public double balance;
    public FiatCurrency currency;
    public Timestamp createDate;
    public Timestamp editDate;
    public UUID userId;

    public Deposit() {
    }

    public Deposit(
            UUID id,
            double balance,
            FiatCurrency currency,
            Timestamp createDate,
            Timestamp editDate,
            UUID userId

    ) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.createDate = createDate;
        this.editDate = editDate;
        this.userId = userId;
    }

    public static Deposit fromJSON(Map map){
        System.out.println("Deposit 1");
        return new Deposit(
                UUID.randomUUID(),
                0,
                (FiatCurrency) map.get("currency"),
                Timestamp.valueOf(LocalDateTime.now()),
                null,
                UUID.fromString(map.get("userId").toString())

        );
    }

    public static Deposit fromRowTable(Map map) {
        Timestamp editDate;
        if (map.get("editDate") != null){
            editDate = Timestamp.valueOf(map.get("editDate").toString());
        } else {
            editDate = null;
        }

        return new Deposit(
                UUID.fromString(map.get("id").toString()),
                Double.valueOf(map.get("balance").toString()),
                FiatCurrency.valueOf(map.get("currency").toString()) ,
                Timestamp.valueOf(map.get("createDate").toString()),
                editDate,
                UUID.fromString(map.get("user_id").toString()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Double.compare(deposit.balance, balance) == 0 &&
                id.equals(deposit.id) &&
                currency == deposit.currency &&
                createDate.equals(deposit.createDate) &&
                editDate.equals(deposit.editDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, currency, createDate, editDate);
    }
}
