package deposit;

import halpers.domain.FiatCurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputProcessor {

    public static Map<String, Object> createDeposit() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> map = new HashMap<>();

        System.out.println("please input email: ");
        map.put("email", scanner.nextLine());

        System.out.println(
                "Choose one of the currencies offered for your deposit: \n" +
                "USD,\n" +
                "UAH,\n" +
                "EUR");
        String currency = scanner.nextLine();
        switch (currency){
            case "EUR":
                map.put("currency", FiatCurrency.EUR);
                return map;
                //return Map.of("currency", FiatCurrency.EUR);
            case "USD":
                map.put("currency", FiatCurrency.USD);
                return map;
            case "UAH":
                map.put("currency", FiatCurrency.UAH);
                return map;
            default:
                throw new Exception ("Invalid currency was entered");
        }
    }


    public static double replenishDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Indicate the amount of replenishment of the deposit: ");

        double sum = Double.parseDouble(scanner.nextLine());
        return sum;
    }

    public static double withdrawalFromDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Indicate the amount of withdrawal from the deposit: ");

        double sum = Double.parseDouble(scanner.nextLine());
        return sum;
    }
}
