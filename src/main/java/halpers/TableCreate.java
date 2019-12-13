package halpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
    private Connection connection;

    public TableCreate() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite" +
                ":sample.db");
        this.connection = connection;
    }

    public void createTableUsers (){
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "id VARCHAR(36) PRIMARY KEY , " +
                            "firstName VARCHAR(100), " +
                            "lastName VARCHAR(100), " +
                            "email VARCHAR(100), " +
                            "password VARCHAR(100) " +
                            ")"
            );
            System.out.println("Создать новую таблицу users");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement statement = this.connection.createStatement()) {
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS deposits (" +
                            "id VARCHAR (36) PRIMARY KEY, " +
                            "balance DECIMAL, " +
                            "currency ENUM NOT NULL, " +
                            "createDate TIMESTAMP NOT NULL, " +
                            "editDate TIMESTAMP, " +
                            "user_id VARCHAR (36), " +
                            "FOREIGN KEY (user_id) REFERENCES users(id)" +
                            ")"
            );
            System.out.println("Создать новую таблицу deposits");

            //"user_id VARCHAR (36), " +
            //                            "loan_id VARCHAR (36), " +
            //                            "FOREIGN KEY (user_id) REFERENCES users(id)" +
            //                            "FOREIGN KEY (loan_id) REFERENCES loans(id)" +
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
//        try (Statement statement = this.connection.createStatement()) {
//
//            statement.executeUpdate(
//                    "CREATE TABLE IF NOT EXISTS loans (" +
//                            "id INTEGER PRIMARY KEY, " +
//                            "balance INTEGER , " +
//                            "currency VARCHAR(3), " +
//                            "user_id INTEGER, " +
//                            "FOREIGN KEY (credit_id) REFERENCES credits(id)" +
//                            ")"
//            );
//            System.out.println("Создать новую таблицу loans");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }

    public void tableDelete(){
        try (Statement statement = this.connection.createStatement()) {

            statement.executeUpdate("DROP TABLE users");
            System.out.println("удаляем таблицу users");

            statement.executeUpdate("DROP TABLE deposits");
            System.out.println("удаляем таблицу deposits");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
