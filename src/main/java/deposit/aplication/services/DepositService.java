package deposit.aplication.services;

import deposit.domain.Deposit;
import deposit.infrastructure.DepositRepository;
import halpers.domain.FiatCurrency;

import java.sql.SQLException;
import java.util.Map;

public class DepositService {
    private DepositRepository depositRepository;

    public DepositService()
            throws SQLException {
        this.depositRepository = new DepositRepository();
    }

    public void addDeposit(Map<String, Object> map) {
        Deposit deposit = Deposit.fromJSON(map);

        depositRepository.insert(deposit);
    }
}
