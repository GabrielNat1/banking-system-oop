package com.bankapp.service;

import com.bankapp.entities.BankAccount;
import com.bankapp.entities.Transaction;

public class Bank {
    private BankAccount[] accounts = new BankAccount[100];
    private int count = 0;

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        }
    }

    public BankAccount findAccount(int number) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getNumber() == number) {
                return accounts[i];
            }
        }
        return null;
    }

    public boolean deposit(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
            account.addTransaction(new Transaction("DEPOSITO", amount, "Depósito realizado"));
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, double amount){
        BankAccount account = findAccount(accountNumber);
        if (account != null && amount > 0 && account.getBalance() >= amount){
            account.withdraw(amount);
            account.addTransaction(new Transaction("SAQUE", amount, "Saque realizado"));
            return true;
        }
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, double amount) {
        BankAccount source = findAccount(fromAccount);
        BankAccount target = findAccount(toAccount);

        if (source != null && target != null && amount > 0 && source.getBalance() >= amount) {
            source.withdraw(amount);
            target.deposit(amount);
            source.addTransaction(new Transaction("TRANSFERENCIA", amount, "Transferência enviada para conta " + toAccount));
            target.addTransaction(new Transaction("TRANSFERENCIA", amount, "Transferência recebida da conta " + fromAccount));
            return true;
        }
        return false;
    }

    public void listAccounts() {
        for (int i = 0; i < count; i++) {
            BankAccount acc = accounts[i];
            System.out.println("Count: " + acc.getNumber() + " - Cliente: " + acc.getClient().getName() + " - Saldo: " + acc.getBalance());
        }
    }
}
