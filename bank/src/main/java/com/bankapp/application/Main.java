package com.bankapp.application;

import com.bankapp.entities.BankAccount;
import com.bankapp.entities.Client;
import com.bankapp.service.Bank;

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
            System.out.println("6. Ver histórico de transações");
            System.out.println("7. Remover conta");
            System.out.println("8. Atualizar nome do cliente");
            System.out.println("9. Atualizar CPF do cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Nome do cliente: ");
                    String name = scanner.nextLine();

                    String cpf;
                    while (true) {
                        System.out.println("CPF do cliente (ou digite 'exit' para cancelar): ");
                        cpf = scanner.nextLine();
                        if (cpf.equalsIgnoreCase("exit")) {
                            System.out.println("Criação de conta cancelada.");
                            break;
                        }
                        if (Client.isValidCpf(cpf)) {
                            break;
                        } else {
                            System.out.println("CPF inválido! Tente novamente.");
                        }
                    }
                    if (cpf.equalsIgnoreCase("exit")) {
                        break;
                    }

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

                case 6:
                    System.out.print("Número da conta para ver histórico: ");
                    int accNumHist = scanner.nextInt();
                    scanner.nextLine();
                    BankAccount accHist = bank.findAccount(accNumHist);
                    if (accHist != null) {
                        System.out.println("Histórico de transações da conta " + accNumHist + ":");
                        if (accHist.getTransactions().isEmpty()) {
                            System.out.println("Nenhuma transação encontrada.");
                        } else {
                            accHist.getTransactions().forEach(tx -> {
                                System.out.println(
                                    tx.getDateTime() + " - " +
                                    tx.getType() + " - " +
                                    tx.getAmount() + " - " +
                                    tx.getDescription()
                                );
                            });
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.print("Número da conta para remover: ");
                    int accNumRemove = scanner.nextInt();
                    scanner.nextLine();
                    if (bank.removeAccount(accNumRemove)) {
                        System.out.println("Conta removida com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada ou erro na remoção.");
                    }
                    break;

                case 8:
                    System.out.print("Número da conta para atualizar nome: ");
                    int accNumUpdate = scanner.nextInt();
                    scanner.nextLine();
                    BankAccount accUpdate = bank.findAccount(accNumUpdate);
                    if (accUpdate != null) {
                        System.out.print("Novo nome do cliente: ");
                        String newName = scanner.nextLine();
                        accUpdate.getClient().setName(newName);
                        System.out.println("Nome atualizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 9:
                    System.out.print("Número da conta para atualizar CPF: ");
                    int accNumCpf = scanner.nextInt();
                    scanner.nextLine();
                    BankAccount accCpf = bank.findAccount(accNumCpf);
                    if (accCpf != null) {
                        String newCpf;
                        while (true) {
                            System.out.print("Novo CPF do cliente (ou digite 'exit' para cancelar): ");
                            newCpf = scanner.nextLine();
                            if (newCpf.equalsIgnoreCase("exit")) {
                                System.out.println("Atualização de CPF cancelada.");
                                break;
                            }
                            if (Client.isValidCpf(newCpf)) {
                                accCpf.getClient().setCpf(newCpf);
                                System.out.println("CPF atualizado com sucesso!");
                                break;
                            } else {
                                System.out.println("CPF inválido! Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
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