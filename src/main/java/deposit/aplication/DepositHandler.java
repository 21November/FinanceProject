package deposit.aplication;

import deposit.InputProcessor;
import deposit.aplication.services.DepositService;
import halpers.domain.FiatCurrency;

import java.sql.SQLException;
import java.util.Map;

public class DepositHandler {
    private final DepositService depositService;

    public DepositHandler() throws SQLException {
        this.depositService = new DepositService();
    }


    public void createDeposit() throws Exception {
        Map<String, Object> map = InputProcessor.createDeposit();

        this.depositService.addDeposit(map);
        System.out.println("Deposit create");
    }
}
