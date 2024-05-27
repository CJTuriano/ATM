
import java.util.Scanner;

public class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Your balance is: $" + account.getBalance());
                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        account.deposit(scanner.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ");
                        account.withdraw(scanner.nextDouble());
                    }
                    case 4 -> System.out.println("Thank you for using the ATM!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            } while (choice != 4);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        new ATM(account).showMenu();
    }
}