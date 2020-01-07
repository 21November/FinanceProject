package deposit.aplication;

import deposit.InputProcessor;
import deposit.aplication.services.DepositService;
import deposit.domain.Deposit;
import halpers.domain.FiatCurrency;
import users.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DepositHandler {
    private final DepositService depositService;

    public DepositHandler() throws SQLException {
        this.depositService = new DepositService();
    }


    public void createDeposit() throws Exception {
        Map<String, Object> map = InputProcessor.createDeposit();

        //map.put("userId", user.id.toString());
        this.depositService.addDeposit(map);
        System.out.println("Deposit create");
    }

    public void getDeposits() {
        List<Deposit> deposits = this.depositService.getDeposits();
        for (int i = 0; i < deposits.size(); i++){
            System.out.println("Deposit{" +
                    "id=" + deposits.get(i).id +
                    ", balance='" + deposits.get(i).balance + '\'' +
                    ", currency='" + deposits.get(i).currency + '\'' +
                    ", createDate='" + deposits.get(i).createDate + '\'' +
                    ", editDate='" + deposits.get(i).editDate + '\'' +
                    '}'
            );
        }
    }

    //TODO: handlers are not receive any input arguments in CLI. since they are only endpoints for start
    public void replenishDeposit() {
        //TODO: confusing name of variable. What exectly heare you are trying to summarize?
        double sum = InputProcessor.replenishDeposit();
        //TODO: will be nice print Deposit before operations since it is a CLI
        //TODO: you should make some search and print deposit and only then make some actions
        //this.depositService.editDepositReplenishment(user, sum);
        System.out.println("Balance increased");
        //TODO: it will be nice print updated deposit after replenishment
    }

    //TODO: confusing name try to rename it to withdrawDeposit
    public void withdrawalFromDeposit() {
        //TODO: confusing name of variable. What exectly heare you are trying to summarize?
        double sum = InputProcessor.withdrawalFromDeposit();
        //TODO: will be nice print Deposit before operations since it is a CLI
        //this.depositService.editDepositReduction(user, sum);
        System.out.println("Balance reduced");
    }
}
