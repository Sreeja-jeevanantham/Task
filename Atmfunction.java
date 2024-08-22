import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
}
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }
    private void deposit(double amount) {
        account.deposit(amount);
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
    }
}
public class Atmfunction {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); 
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
