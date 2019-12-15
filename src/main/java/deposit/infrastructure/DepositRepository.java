package deposit.infrastructure;

import deposit.domain.Deposit;
import halpers.IRepository;
import users.domain.User;

import java.sql.*;
import java.time.LocalDateTime;
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
            String query = String.format(
                "INSERT INTO deposits" +
                "(id, balance, currency, createDate, editDate, user_id)" +
                "VALUES('%s', %s, '%s', '%s', '%s', '%s')",
                deposit.id.toString(),
                Double.toString(deposit.balance),
                deposit.currency.name(),
                deposit.createDate,
                deposit.editDate,
                deposit.userId
            );
            System.out.println(query);
            statement.executeUpdate(
                    query
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Deposit deposit) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Deposit> getAll() {
        List<Deposit> deposits = new ArrayList<Deposit>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet cursor = statement.executeQuery(
                    "SELECT * FROM deposits"
            );

            ResultSetMetaData md = cursor.getMetaData();
            int columns = md.getColumnCount();

            while (cursor.next()){
                Map<String, Object> row = new HashMap<String, Object>(columns);
                for(int i = 1; i <= columns; ++i){
                    row.put(md.getColumnName(i), cursor.getObject(i));
                }

                deposits.add(Deposit.fromRowTable(row));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deposits;
    }

    @Override
    public Optional<Deposit> getById(long id) {
        return Optional.empty();
    }

    public void updateDepositReplenishment(User user, double sum) {
        System.out.println(sum);
        try {
            Statement statement = this.connection.createStatement();
            String query = String.format(
                    "UPDATE deposits " +
                    "SET balance = balance + " + sum +
                    ", editDate = '" + Timestamp.valueOf(LocalDateTime.now()) +
                    "' WHERE user_id = '" + user.id + "'"

            );
            System.out.println(query);
            statement.executeUpdate(
                    query
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepositReduction(User user, double sum) {
        System.out.println(sum);
        try {
            Statement statement = this.connection.createStatement();
            String query = String.format(
                    "UPDATE deposits " +
                    "SET balance = balance - " + sum +
                    ", editDate = '" + Timestamp.valueOf(LocalDateTime.now()) +
                    "' WHERE user_id = '" + user.id + "'"

            );
            System.out.println(query);
            statement.executeUpdate(
                    query
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //методы для работы с таблицей Депозиты
}
