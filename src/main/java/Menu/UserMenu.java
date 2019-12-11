package Menu;

import deposit.aplication.DepositHandler;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class UserMenu {
    private DepositHandler depositHandler;

    public UserMenu() {
        try {
            this.depositHandler = new DepositHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void run(){

        boolean flag = true;
        while (flag){
            Scanner scanner = new Scanner(in);
            out.println(
                    "Please enter one of the next options:\n" +
                            "1 Create deposit\n" +
                            "2 Exit\n" +
                            "Chosen option: "
            );

            int option = scanner.nextInt();


            try {
                switch (option){
                    case 1:
                        this.depositHandler.createDeposit();
                        break;
                    case 2:
                        flag = false;
                        break;
                }
            }catch (Exception e){
                out.println(e.getMessage());
            }
        }




    }
}
