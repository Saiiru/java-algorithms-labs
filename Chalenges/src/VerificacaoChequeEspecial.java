import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        double saque = scanner.nextDouble();
        double limiteChequeEspecial = 500;

        if (!Double.isFinite(saldo) || !Double.isFinite(saque) || saldo < 0 || saque <= 0) {
            System.out.println("Valor invalido.");
        // Verifica se o saque não ultrapassa o saldo disponível na conta:
        } else if (saque <= saldo) {
            System.out.println("Transacao realizada com sucesso.");
        } else {
            // Verifica se o saque ultrapassa o limite do cheque especial, mas não o saldo total disponível:
            if (saque <= saldo + limiteChequeEspecial) {
                System.out.println("Transacao realizada com sucesso utilizando o cheque especial.");
            } else {
                // Se o saque ultrapassar tanto o saldo disponível quanto o limite do cheque especial
                System.out.println("Transacao nao realizada. Limite do cheque especial excedido.");
            }
        }

        // Fechamos o objeto Scanner para liberar os recursos:
        scanner.close();
    }
}
