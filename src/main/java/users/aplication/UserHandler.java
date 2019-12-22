package users.aplication;

import Menu.UserMenu;
import users.InputProcessor;
import users.aplication.services.UserService;

import users.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserHandler {

    private final UserService userService;

    public UserHandler() throws SQLException {
        this.userService = new UserService();
    }

    public void signUp() throws Exception {
        Map<String, Object> json = InputProcessor.signUp();

        this.userService.addUser(json);
        System.out.println("User was registered");
    }

    public void getUsers() {
        List<User> users = this.userService.getUsers();
        for (int i = 0; i < users.size(); i++){
            System.out.println("User{" +
                    "id=" + users.get(i).id +
                    ", firstName='" + users.get(i).firstName + '\'' +
                    ", lastName='" + users.get(i).lastName + '\'' +
                    ", email='" + users.get(i).email + '\'' +
                    ", password='" + users.get(i).password + '\'' +
                    '}'
            );
        }

    }

    public void signIn() throws Exception {

        Map<String, String> data = InputProcessor.signIn();
        User user = this.userService.getUserByEmail(data.get("email"));
        if (user == null){
            throw new UserNotExistsException();
        }

        this.userService.ensureUserDataCorrect(
                user, (String) data.get("password")
        );

        UserMenu userMenu = new UserMenu();
        //TODO: confusing using of method. You are saying userMenu please run and receive myself. please remove user from input params
        userMenu.run(user);

    }

}
