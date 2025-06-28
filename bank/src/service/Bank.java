package service;

import entities.BankAccount;

public class Bank {
    private BankAccount[] accounts = new BankAccount[100];
    private int count = 0;

    public void AddAccount(BankAccount account){
        if (count < accounts.length){
            accounts[count++] = account;
        }
    }

    public BankAccount findAccount(int number) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getNumber() == number) {
                return accounts[i];
            }
        }
    }
    }
