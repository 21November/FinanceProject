package users;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class InputProcessor {

    public static Map<String, Object> signUp(){
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> map = new HashMap<>();

        System.out.println("Input first name: ");
        map.put("firstName", scanner.nextLine());

        System.out.println("Input last name: ");
        map.put("lastName", scanner.nextLine());

        System.out.println("Input email: ");
        map.put("email", scanner.nextLine());

        System.out.println("Input password: ");
        map.put("password", scanner.nextLine());

        System.out.println("Input confirm password: ");
        map.put("confirmPassword", scanner.nextLine());

        return map;
    }

    public static Map<String, String> signIn() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        System.out.println("Input login: ");
        map.put("email", scanner.nextLine());

        System.out.println("Input password: ");
        map.put("password", scanner.nextLine());

        return map;
    }
}
