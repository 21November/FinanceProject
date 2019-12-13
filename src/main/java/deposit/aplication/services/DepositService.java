package deposit.aplication.services;

import deposit.domain.Deposit;
import deposit.infrastructure.DepositRepository;
import halpers.domain.FiatCurrency;

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
        System.out.println("Deposit Service1");
        Deposit deposit = Deposit.fromJSON(map);
        System.out.println("Deposit Service2");

        depositRepository.insert(deposit);
        System.out.println("Deposit Service3");
    }

    public List<Deposit> getUsers() {
        return this.depositRepository.getAll();
    }
}
