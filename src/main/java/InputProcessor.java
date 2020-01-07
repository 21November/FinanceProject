import halpers.domain.Domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputProcessor {

    public static Map<String, Object> profileFilling(){
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> map = new HashMap<>();

        System.out.println("Input jobTitle: ");
        map.put("jobTitle", scanner.nextLine());

        System.out.println("Input province: ");
        map.put("province", scanner.nextLine());

        System.out.println("Input postalCode: ");
        map.put("postalCode", scanner.nextLine());

        System.out.println("Input country: ");
        map.put("country", scanner.nextLine());

        System.out.println("Input city: ");
        map.put("city", scanner.nextLine());

        System.out.println("Input address: ");
        map.put("address", scanner.nextLine());

        return map;
    }




}
