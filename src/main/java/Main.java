import Menu.MainMenu;
import halpers.TableCreate;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//
//        menu.addEntry(new MenuEntry("Вывести все значения из таблици users") {
//            @Override
//            public void run() {
//                UserRepository repository = new UserRepository(connection);
//                List<User> list = new ArrayList<User>();
//                list = (List<User>) repository.getAll();
//                //repository.getAll();
//
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i));
//                }
//
//                System.out.println("Таблица users выведена в консоль");
//            }
//        });
//        menu.addEntry(new MenuEntry("Удалить user из таблици users") {
//            @Override
//            public void run() {
//
//                Scanner in = new Scanner(System.in);
//
//                System.out.println("Input last name user: ");
//                String lastName = in.nextLine();
//
//                UserRepository repository = new UserRepository(connection);
//
//                repository.delete(lastName);
//
//                System.out.println("user удален");
//            }
//        });
//        menu.run();

//        TableCreate tableCreate = new TableCreate();
//        tableCreate.createTableUsers();

            MainMenu menu = new MainMenu();
            menu.run();


    }
}
