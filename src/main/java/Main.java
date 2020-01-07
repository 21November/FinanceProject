import Menu.MainMenu;
import halpers.TableCreate;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        TableCreate tableCreate = new TableCreate();

//        tableCreate.tableDelete();
//        tableCreate.createTableUsers();

        MainMenu menu = new MainMenu();
        menu.run();


    }
}
