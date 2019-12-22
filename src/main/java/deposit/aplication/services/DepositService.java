package deposit.aplication.services;

import deposit.domain.Deposit;
import deposit.infrastructure.DepositRepository;
import halpers.domain.FiatCurrency;
import users.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DepositService {
    private DepositRepository depositRepository;

    public DepositService()
            throws SQLException {
        this.depositRepository = new DepositRepository();
    }

    public void addDeposit(Map<String, Object> map) {
        Deposit deposit = Deposit.fromJSON(map);

        this.depositRepository.insert(deposit);
    }

    public List<Deposit> getDeposits() {
        return this.depositRepository.getAll();
    }

    //TODO: Confusing method name. Try to rename it like rainforceDeposit
    public void editDepositReplenishment(User user, double sum) {
        this.depositRepository.updateDepositReplenishment(user, sum);
    }

    //TODO: Confusing method name. Try to rename it like withdrawDeposit
    public void editDepositReduction(User user, double sum) {
        this.depositRepository.updateDepositReduction(user, sum);
    }
}
