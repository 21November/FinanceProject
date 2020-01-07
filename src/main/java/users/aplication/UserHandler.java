package users.aplication;

import Menu.DepositMenu;
import users.InputProcessor;
import users.aplication.services.AuthService;
import users.aplication.services.UserService;

import users.domain.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHandler {

    private final UserService userService;
    private final AuthService authService;

    public UserHandler() throws SQLException {
        this.userService = new UserService();
        this.authService = new AuthService();
    }

    public void signUp() throws Exception {

        Map<String, Object> data = InputProcessor.signUp();

//        Map<String, Object> data = Map.of(
//                "firstName", "Bob",
//                "lastName", "Smit",
//                "email", "Smit@gmail.com",
//                "password", "0000",
//                "confirmPassword", "0000"
//        );
        System.out.println(data);

        this.authService.singUp(data);
        System.out.println("User was registered");
    }

    public void getUsers() {
        List<User> users = this.userService.getUsers();
        for (int i = 0; i < users.size(); i++){
            System.out.println("User{" +
                    "id=" + users.get(i).id.getUuid() +
                    ", email='" + users.get(i).email + '\'' +
                    '}'
            );
        }

    }

    public void signIn() throws Exception {

        Map<String, String> data = InputProcessor.signIn();

        this.authService.signIn(data);
        DepositMenu userMenu = new DepositMenu();
        //TODO: confusing using of method.
        // You are saying userMenu please run and receive myself.
        // please remove user from input params
        userMenu.run();

    }

}
