package main;

public class BankAccount {

    public double bankBalance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative!");
        }
        this.bankBalance = initialBalance;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative!");
        }
        bankBalance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        if (amount > bankBalance) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal!");
        }
        bankBalance -= amount;
    }
}
