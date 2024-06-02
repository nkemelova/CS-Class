package BNF;

import java.util.Scanner;

//Add 34 3
//Sub 31 2
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String raw_expr = scanner.nextLine();
        String[] expr = raw_expr.split(" ");
        if (expr.length != 3) {
            throw new IllegalArgumentException("Input doesn't satisfy language rules: " + raw_expr);
        }

        try {
            String operator = expr[0];
            Double operand1 = Double.parseDouble(expr[1]);
            Double operand2 = Double.parseDouble(expr[2]);

            double result = evaluate(operator, operand1, operand2);
            System.out.println(result);
        } catch (Exception e) {
            throw new IllegalArgumentException("We couldn't parse your input ", e);
        }


        scanner.close();
    }

    public static double evaluate (String operator, Double operand1, Double operand2){
        switch (operator.toUpperCase()) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            case "DIV":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by 0 is not allowed ");
                }
                return operand1 / operand2;
            case "MOD":
                return operand1 % operand2;
            case "POW":
                return Math.pow(operand1, operand2);
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operator);
        }

    }
}
