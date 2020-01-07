package deposit.domain;


import halpers.domain.Domain;
import halpers.domain.FiatCurrency;
import users.domain.UserId;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class Deposit extends Domain {
    public DepositId id;
    public double balance;
    public FiatCurrency currency;
    public Timestamp createDate;
    //TODO: edit date will be usefull after implementing transactions so please remove it now and add another field with name dateClosed.
    public Timestamp editDate;
    public UserId userId;

    public Deposit() {
    }

    public Deposit(
            DepositId id,
            double balance,
            FiatCurrency currency,
            Timestamp createDate,
            Timestamp editDate,
            UserId userId

    ) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.createDate = createDate;
        this.editDate = editDate;
        this.userId = userId;
    }

    public static Deposit fromJSON(Map map){
        //TODO: no prints should be in methods. Remove please this horrible
        //  shit. This message is hardcoded so remove it.
        System.out.println("Deposit 1");
        return new Deposit(
                new DepositId(),
                0,
                (FiatCurrency) map.get("currency"),
                Timestamp.valueOf(LocalDateTime.now()),
                null,
                new UserId(map.get("userId").toString())

        );
    }

    public static Deposit fromRowTable(Map map) {
        //TODO: no prints should be in methods. Remove please this horrible shit
        System.out.println("method fromROwTable 1");
        Timestamp editDate = Timestamp.valueOf(LocalDateTime.now());
        //TODO: Is this commented code still needed? Seems like some logic for
        // edit date were described. For now after commenting each time edit
        // date will be set even after deposit creation and it is not correct
        // according to product specification. Please uncomment this.
//        if (map.get("editDate") != null){
//            editDate = Timestamp.valueOf(map.get("editDate").toString());
//        } else {
//            editDate = null;
//        }
        //TODO: no prints should be in methods. Remove please this horrible shit
        System.out.println("method fromROwTable 2");
        return new Deposit(
                new DepositId(map.get("id").toString()),
                Double.valueOf(map.get("balance").toString()),
                FiatCurrency.valueOf(map.get("currency").toString()) ,
                Timestamp.valueOf(map.get("createDate").toString()),
                editDate,
                new UserId(map.get("user_id").toString())
                );
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
