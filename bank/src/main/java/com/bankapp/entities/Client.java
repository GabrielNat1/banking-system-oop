package com.bankapp.entities;

public class Client {
    private String name;
    private String cpf; // identification uniq

    public Client(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean setCpf(String cpf) {
        if (isValidCpf(cpf)) {
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public boolean setCpfValidated(String cpf) {
        if (isValidCpf(cpf)) {
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public static boolean isValidCpf(String cpf) {
        // A valid CPF must be 11 digits long
        if (cpf == null) return false;
        return cpf.matches("\\d{11}");
    }

}
