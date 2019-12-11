package deposit.domain;


import halpers.domain.Domain;
import halpers.domain.FiatCurrency;


import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Deposit extends Domain {
    public UUID id;
    public double balance;
    public FiatCurrency currency;
    public Timestamp createDate;
    public Timestamp editDate;

    public Deposit() {
    }

    public Deposit(
            UUID id,
            double balance,
            FiatCurrency currency,
            Timestamp createDate
    ) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.createDate = createDate;
    }

    public static Deposit fromJSON(Map map){
        return new Deposit(
                UUID.randomUUID(),
                0,
                (FiatCurrency) map.get("currency"),
                new Timestamp(1)
        );

    }

    public static Deposit fromMap(){
        //в репозироии делаем запрос к базе данных
        //курсор - превращается в мап
        //после создаем обьект депозита
        return null;
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
