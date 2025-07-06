package com.bankapp.entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double number;
    private double balance;
    private Client client;
    private List<Transaction> transactions = new ArrayList<>();

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
