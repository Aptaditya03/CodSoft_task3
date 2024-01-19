import java.util.Scanner;

class BankAccount {
    private double accountBalance;

    public BankAccount(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds
        }
    }
}

public class AnotherATM {
    private BankAccount userBankAccount;

    public AnotherATM(BankAccount bankAccount) {
        this.userBankAccount = bankAccount;
    }

    public void showOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeTransaction(int selectedOption, Scanner scanner) {
        switch (selectedOption) {
            case 1:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                if (userBankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userBankAccount.getAccountBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;
            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                userBankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + userBankAccount.getAccountBalance());
                break;
            case 3:
                System.out.println("Current Balance: $" + userBankAccount.getAccountBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial account balance: $");
        double initialAccountBalance = scanner.nextDouble();

        BankAccount userBankAccount = new BankAccount(initialAccountBalance);
        AnotherATM anotherATM = new AnotherATM(userBankAccount);

        while (true) {
            anotherATM.showOptions();
            System.out.print("Choose an option (1-4): ");
            int userOption = scanner.nextInt();

            anotherATM.executeTransaction(userOption, scanner);
        }
    }
}
