package main.java.com.bankapp.entities;

import java.time.LocalDateTime;

public class Transaction {
    private String type; // "DEPOSITO", "SAQUE", "TRANSFERENCIA"
    private double amount;
    private LocalDateTime dateTime;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }
}

