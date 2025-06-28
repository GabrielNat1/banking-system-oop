package application;

import service.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        int option;

        do {
            System.out.println("\n1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();

        } while (option != 0);

        scanner.close();
    }
}