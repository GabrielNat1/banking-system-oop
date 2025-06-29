package main.java.com.bankapp.application;

import main.java.com.bankapp.entities.BankAccount;
import main.java.com.bankapp.entities.Client;
import main.java.com.bankapp.service.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        int option;

        do {
            System.out.println("\n=== Banco Console ===");
            System.out.println("\n1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Nome do cliente: ");
                    String name = scanner.nextLine();

                    System.out.println("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Número da conta: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();

                    Client client = new Client(name, cpf);
                    BankAccount account = new BankAccount(number, client);
                    bank.addAccount(account);
                    break;

                case 2:
                    System.out.println("numero da conta para deposito: ");
                    int accNumDeposit = scanner.nextInt();

                    System.out.println("valor a depositar: ");
                    double depositValue = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.deposit(accNumDeposit, depositValue)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Falha no depósito. Verifique os dados.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para saque: ");
                    int accNumWithdraw = scanner.nextInt();

                    System.out.print("Valor a sacar: ");
                    double withdrawValue = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.withdraw(accNumWithdraw, withdrawValue)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Falha no saque. Verifique os dados e saldo.");
                    }
                    break;

                case 4:
                    System.out.print("Conta origem: ");
                    int fromAcc = scanner.nextInt();

                    System.out.print("Conta destino: ");
                    int toAcc = scanner.nextInt();

                    System.out.print("Valor a transferir: ");
                    double transferValue = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.transfer(fromAcc, toAcc, transferValue)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Falha na transferência. Verifique os dados e saldo.");
                    }
                    break;

                case 5:
                    bank.listAccounts();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}