package de.dhbw.lecture04;

public class BankAccount {
    private double balance;
    private final double overdraftLimit;

    public BankAccount(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Einzahlungsbetrag muss größer als 0 sein.");
        }

        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Abhebungsbetrag muss größer als 0 sein.");
        }

        // Überziehungslimit berücksichtigen
        if (balance - amount < -overdraftLimit) {
            throw new InsufficientFundsException(
                    "Nicht genügend Guthaben. Überziehungslimit überschritten.");
        }

        balance -= amount;
    }

}
