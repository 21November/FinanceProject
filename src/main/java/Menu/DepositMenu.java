package Menu;

import deposit.aplication.DepositHandler;
import users.domain.User;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class DepositMenu {
    private DepositHandler depositHandler;

    public DepositMenu() {
        try {
            this.depositHandler = new DepositHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //TODO: lets rename all methods for run user menu on 'render' name
    public void run() {

        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(in);
            out.println(
                    "Please enter one of the next options:\n" +
                            "1 Create deposit\n" +
                            "2 Replenish deposit\n" +
                            "3 Withdrawal from deposit\n" +
                            "4 Exit\n" +
                            "Chosen option: "
            );

            int option = scanner.nextInt();


            try {
                switch (option) {
                    case 1:
                        this.depositHandler.createDeposit();
                        break;
                    case 2:
                        this.depositHandler.replenishDeposit();
                        break;
                    case 3:
                        this.depositHandler.withdrawalFromDeposit();
                        break;
                    case 4:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }
    }
}
//TODO: remove all Russian comments from project. Remove all russian outputs from project.
//        1. Создание депозита депозит должен изначально иметь нулевой баланс
//        2. Пополнение депозита пока без создания транзакций только проставить даты создания и обновления и обновить баланс
//        3. Вычет из депозита денег пока что без создания транзакции