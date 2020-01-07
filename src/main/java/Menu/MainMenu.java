package Menu;


import users.aplication.UserHandler;
import users.aplication.services.UserService;
import users.infrastructure.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.in;

public class MainMenu {
    private UserHandler userHandler;

    public MainMenu() {
        try {
            this.userHandler = new UserHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception{

        boolean flag = true;
        while (flag){
            Scanner scanner = new Scanner(in);
            out.println(
                    "Please enter one of the next options:\n" +
                            "1 Sign up\n" +
                            "2 Sign in\n" +
                            "3 Get all users\n" +
                            "4 Exit\n" +
                            "Chosen option: "
            );

            int option = scanner.nextInt();


//            try {

                switch (option){
                    case 1:
                        this.userHandler.signUp();
                        break;
                    case 2:
                        this.userHandler.signIn();
                        break;
                    case 3:
                        this.userHandler.getUsers();
                        break;
                    case 4:
                        flag = false;
                        break;
                }
//            }catch (Exception e){
//                out.println("Error message: " + e.getMessage());
//            }
        }




    }
}
