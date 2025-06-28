package entities;

public class BankAccount {
    private double number;
    private double balance;
    private Client client;

    public BankAccount(int number, Client client) {
        this.number = number;
        this.balance = 0;
        this.client = client;
    }
}
