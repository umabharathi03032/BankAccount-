import java.util.Scanner;

class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private double balance;
    BankAccount(String name, String accNo, double initialBalance) {
        accountHolderName = name;
        accountNumber = accNo;
        balance = initialBalance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
    void showAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        checkBalance();
    }
}

public class BankSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;
        do {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showAccountDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
