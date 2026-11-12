package Chalenges.src;

import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();

        if (!Double.isFinite(limiteDiario) || limiteDiario < 0) {
            System.out.println("Limite diario invalido.");
            scanner.close();
            return;
        }

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble();

            // Verifica se o valor do saque é zero, encerrando as transações
            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break;
            }

            // Valores negativos nunca devem aumentar o limite restante.
            if (!Double.isFinite(valorSaque) || valorSaque < 0) {
                System.out.println("Valor invalido.");
                continue;
            }

            // Verifica se o valor do saque ultrapassa o limite diário
            if (valorSaque > limiteDiario) {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break;
            }

            // Subtrai o valor do saque do limite diário
            limiteDiario -= valorSaque;
            System.out.println("Saque realizado. Limite restante: " + limiteDiario);
        }

        // Fechamos o Scanner para evitar vazamento de recursos
        scanner.close();
    }
}
