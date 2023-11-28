//BankAccount class represents the user's bankaccount 

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
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". Remaining balance: $ "  + balance);
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Remaining balance: $ " + balance);
        }else if(amount > balance) {
            System.out.println("Insufficient funds.");
        }else{
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
  //ATM class represents the ATM machine
   class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Quit");
    }

    public void processOption(int option) {
        Scanner sc = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.println("Enter the deposit amount: $");
                double depositAmount = sc.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Enter the withdrawal amount: $");
                double withdrawAmount = sc.nextDouble();

                bankAccount.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting the ATM. Thankyou!");
                System.exit(0);
                break;  
            default:
                System.out.println("Invalid choice please enter a number between 1 and 4.");
        }
    }
}
  //Main class to run the ATM program
  public class Main {
    public static void main(String[] args) {
        //Create a bank account with an initial balance $ 1000
        BankAccount userAccount = new BankAccount(1000);
        
        //Create an ATM connected to the user's bank account
        ATM atm = new ATM(userAccount);
        
        while (true) {
            atm.displayMenu();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice (1-4):");
            int choice = sc.nextInt();

            atm.processOption(choice);
        }
    }
  }
