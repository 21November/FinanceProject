package deposit.infrastructure;

import deposit.domain.Deposit;
import halpers.IRepository;

import java.sql.*;
import java.util.*;

public class DepositRepository implements IRepository<Deposit> {

    private final Connection connection;

    public DepositRepository() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:sample.db");
        this.connection = connection;
    }

    @Override
    public void insert(Deposit deposit) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(
                    String.format
                            (
                                    "INSERT INTO deposits" +
                                            "(" +
                                            "id, " +
                                            "balance, " +
                                            "currency, " +
                                            "createDate, " +
                                            "editDate)" +
                                            "VALUES('%s', %f, '%s', '%s', " +
                                            "'%s')",
                                    deposit.id,
                                    deposit.balance,
                                    deposit.currency,
                                    deposit.createDate,
                                    deposit.createDate
                            )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //"user_id, " +
        //"loan_id, " +
    }

    @Override
    public void update(Deposit deposit) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Deposit> getAll() {
        return null;
    }

    @Override
    public Optional<Deposit> getById(long id) {
        return Optional.empty();
    }
    //методы для работы с таблицей Депозиты
}
