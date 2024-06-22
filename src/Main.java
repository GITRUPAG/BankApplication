 // File: Main.java
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        GenerateId newid = new GenerateId();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter initial balance: ");
                        double initialBalance;
                        try {
                             initialBalance = scanner.nextDouble();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Invalid input "+e);
                            scanner.next();
                            continue;
                        }
                        String userid =  newid.generateUserId();
                        System.out.println("Your UserId : "+userid);
                        bankService.createAccount(name, initialBalance,userid);
                        break;
                    case 2:
                        System.out.print("Enter user ID: ");
                        String depositUserId;
                        try {
                            depositUserId = scanner.nextLine();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Invalid Input");
                            scanner.next();
                            continue;
                        }
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount;
                        try {
                             depositAmount = scanner.nextDouble();
                        }
                       catch (InputMismatchException e) {
                           System.out.println("Invalid input");
                           scanner.next();
                           continue;
                       }
                        bankService.deposit(depositUserId, depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter user ID: ");
                        String withdrawUserId;
                        try {
                             withdrawUserId = scanner.next();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Invalid Input ");
                            scanner.next();
                            continue;
                        }
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount;
                        try{
                             withdrawAmount = scanner.nextDouble();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Invalid input");
                            scanner.next();
                            continue;
                        }
                        bankService.withdraw(withdrawUserId, withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter user ID: ");
                        String balanceUserId;
                        try {
                             balanceUserId = scanner.next();
                        }
                        catch (InputMismatchException e){
                            System.out.println("Invalid Input");
                            scanner.next();
                            continue;
                        }
                        bankService.checkBalance(balanceUserId);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
