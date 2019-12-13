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


    public void createDeposit(User user) throws Exception {
        System.out.println("Deposit Handler 1");
        Map<String, Object> map = InputProcessor.createDeposit();

        map.put("userId", user.id.toString());
        System.out.println("Deposit Handler 2");
        this.depositService.addDeposit(map);
        System.out.println("Deposit create");
    }

    public void getDeposits() {
        List<Deposit> deposits = this.depositService.getUsers();
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
}
