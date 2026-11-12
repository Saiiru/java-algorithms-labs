package Chalenges.src;

import java.util.Scanner;

public class VerificadorNumeroConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da conta bancária:");
        String numeroConta = scanner.nextLine();

        try {
            verificarNumeroConta(numeroConta);
            System.out.println("Número de conta válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void verificarNumeroConta(String numeroConta) throws IllegalArgumentException {
        if (!numeroConta.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("Número de conta inválido. Digite exatamente 8 dígitos numéricos.");
        }
    }
}
