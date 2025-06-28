package entities;

public class BankAccount {
    private double number;
    private double balance;
    private Client client;

    public BankAccount(int number, Client client) {
        this.number = number;
        this.balance = 0.0;
        this.client = client;
    }

    public double getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
