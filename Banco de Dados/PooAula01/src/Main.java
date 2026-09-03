import java.util.Scanner;

public class Main {
    static void main() {
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Kauan Mello Cancelier";
        cliente1.cpf = "123.456.789.10";
        Scanner scanner = new Scanner(System.in);

        Conta conta1 = new Conta();
        conta1.saldo= 0.0;

        cliente1.conta = conta1;

        conta1.depositar(100.0);a
        conta1.sacar(100.00);
        System.out.println(cliente1);
    }
}