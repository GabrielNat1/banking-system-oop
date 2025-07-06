package com.bankapp.entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public enum AccountType { CORRENTE, POUPANCA }

    private double number;
    private double balance;
    private Client client;
    private List<Transaction> transactions = new ArrayList<>();
    private AccountType type;

    public BankAccount(int number, Client client) {
        this(number, client, AccountType.CORRENTE);
    }

    public BankAccount(int number, Client client, AccountType type) {
        this.number = number;
        this.balance = 0.0;
        this.client = client;
        this.type = type;
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

    public AccountType getType() {
        return type;
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
