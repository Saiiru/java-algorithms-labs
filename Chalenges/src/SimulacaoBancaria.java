package Chalenges.src;

import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;

        while (scanner.hasNextInt()) {
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Depositar
                    double valorDeposito = scanner.nextDouble();
                    if (!Double.isFinite(valorDeposito) || valorDeposito <= 0) {
                        System.out.println("Valor invalido.");
                        break;
                    }
                    saldo += valorDeposito;
                    // Display the updated balance after deposit
                    System.out.println("Saldo atual: " + saldo);
                    scanner.nextLine(); // Limpa o buffer do teclado
                    break;
                case 2: // Sacar
                    double valorSaque = scanner.nextDouble();
                    if (!Double.isFinite(valorSaque) || valorSaque <= 0) {
                        System.out.println("Valor invalido.");
                    } else if (valorSaque <= saldo) {
                        saldo -= valorSaque;
                        // Display the updated balance after withdrawal only if the transaction is
                        // successful
                        System.out.println("Saldo atual: " + saldo);
                    } else {
                        // Only display "Saldo insuficiente." without showing "Saldo atual:" again
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3: // Consultar Saldo
                    System.out.println("Saldo atual: " + saldo);
                    break;
                case 0: // Encerrar
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return;
                default: // Opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
