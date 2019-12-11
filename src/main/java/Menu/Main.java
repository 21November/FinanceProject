package Menu;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:sqlite" +
//                ":sample.db");
//
//        TableCreate create = new TableCreate(connection);
//        create.createTableUsers();
//        Menu menu = new Menu();
//        menu.addEntry(new MenuEntry("Добавить пользователя в базу данных") {
//            @Override
//            public void run() {
//                Scanner in = new Scanner(System.in);
//                UUID uuid = UUID.randomUUID();
//                System.out.println(uuid.toString());
//                System.out.println("Input first name: ");
//                String firstName = in.nextLine();
//                System.out.println("Input last name: ");
//                String lastName = in.nextLine();
//                System.out.println("Input email: ");
//                String email = in.nextLine();
//
//                Map<String, Object > map = new HashMap<>();
//                map.put("id", uuid);
//                map.put("firstName", firstName);
//                map.put("lastName", lastName);
//                map.put("email", email);
//
//                UserRepository repository = new UserRepository(connection);
//                repository.insert(User.fromJSON(map));
//
//
//                repository.getAll();
//
//
//                System.out.println("Новый пользователь добавлен");
//            }
//        });
//
//        menu.run();
    }


}
