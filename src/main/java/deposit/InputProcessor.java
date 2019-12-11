package deposit;

import halpers.domain.FiatCurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputProcessor {

    public static Map<String, Object> createDeposit() throws Exception {

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> map = new HashMap<>();

        System.out.println(
                "Choose one of the currencies offered for your deposit: " +
                "USD,\n" +
                "UAN,\n" +
                "EUR");
        String currency = scanner.nextLine();
        switch (currency){
            case "EUR":
                return Map.of("currency", FiatCurrency.EUR);
            case "USD":
                return Map.of("currency", FiatCurrency.USD);
            case "UAN":
                return Map.of("currency", FiatCurrency.UAH);
            default:
                throw new Exception ("Invalid currency was entered");
        }

    }
}
