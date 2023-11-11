import exceptions.InvalidOperationException;
import intefaces.OperationInterface;
import operations.*;

import java.util.Scanner;

public class Calculator {

    private int n1;
    private OperationInterface operation;
    private int n2;
    private int result = 0;
    private Scanner sc;
    private StringBuilder history = new StringBuilder();

    public Calculator(Scanner scanner) {
        this.sc = scanner;
    }

    public void readFirstNumber() throws NumberFormatException {
        if (this.result == 0) {
            System.out.print("value: ");
            this.n1 = Integer.parseInt(sc.nextLine());
            this.addToHistory(String.valueOf(this.n1));
        } else {
            this.n1 = result;
        }
    }

    public void readSecondNumber() throws NumberFormatException {
        System.out.print("value: ");
        this.n2 = Integer.parseInt(sc.nextLine());
        this.addToHistory(String.valueOf(this.n2));
    }

    public void readOperation() throws InvalidOperationException {
        System.out.print("operation: ");
        String operation = sc.nextLine();
        this.addToHistory(operation);
        switch (operation) {
            case "+":
                this.operation = new Sum();
                break;
            case "-":
                this.operation = new Sub();
                break;
            case "*":
                this.operation = new Mul();
                break;
            case "/":
                this.operation = new Div();
                break;
            default:
                throw new InvalidOperationException("Invalid operation!");
        }
    }

    public void calculate() throws InvalidOperationException {
        if (this.operation == null) {
            throw new InvalidOperationException("Invalid operation!");
        }

        this.result = this.operation.performCalculation(this.n1, this.n2);
        this.addToHistory("=");
        this.addToHistory(String.valueOf(this.result));

        System.out.println("Result: " + this.result);
    }

    public void reset() {
        this.n1 = 0;
        this.n2 = 0;
        this.result = 0;
        this.operation = null;
    }

    public void addToHistory(String s){
        this.history.append(s).append(" ");
    }

    public StringBuilder getHistory(){
        return this.history;
    }
}
