import exceptions.InvalidOperationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(sc);
        init(calculator, sc);

    }

    private static void init(Calculator calculator, Scanner sc){
        System.out.println("::: Calculator :::");

        while (true) {
            try {
                calculator.readFirstNumber();
                calculator.readOperation();
                calculator.readSecondNumber();
                calculator.calculate();
            } catch (NumberFormatException | InvalidOperationException e) {
                System.out.println("Invalid operation!");
                calculator.reset();
                System.out.println("Reset calculator...");
            }

            System.out.println("History: " + calculator.getHistory());
            System.out.println("Exit? (y / Enter key)");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("y")){
                break;
            }
        }
    }
}