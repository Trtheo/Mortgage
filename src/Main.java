//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import  java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter loan amount: ");
                double loanAmount = scanner.nextDouble();
                if (loanAmount <= 0)
                    throw new IllegalArgumentException("Loan amount must be positive.");

                System.out.print("Enter annual interest rate (in percentage): ");
                double annualInterestRate = scanner.nextDouble();
                if (annualInterestRate <= 0)
                    throw new IllegalArgumentException("Annual interest rate must be positive.");

                System.out.print("Enter loan term (in years): ");
                int loanTerm = scanner.nextInt();
                if (loanTerm <= 0)
                    throw new IllegalArgumentException("Loan term must be positive.");

                // Consume the newline character left in the input buffer
                scanner.nextLine();

                double monthlyInterestRate = annualInterestRate / 12 / 100;
                int numberOfPayments = loanTerm * 12;

                double monthlyPayment = loanAmount * monthlyInterestRate /
                        (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

                System.out.println("Monthly Mortgage Payment: $" + monthlyPayment);

                // Prompt user to continue
                System.out.print("Do you want to calculate another mortgage payment? (yes/no): ");
                String input = scanner.next().toLowerCase();
                if (!input.equals("yes"))
                    break; // Exit the loop if user does not want to continue
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                // Consume the invalid input
                //scanner.nextLine();
            }
        }
        scanner.close();
        }
    }
