import java.util.Scanner;

public class Main {
    static void main() {
        Cliente cliente1 = new Cliente("Miguel Cardoso Assmann", "124.824.979-81", null);
        cliente1.cpf = "123.456.789.10";
        Scanner scanner = new Scanner(System.in);

        Conta conta1 = new Conta();
        conta1.saldo= 0.0;
        Cliente cliente = new Cliente("Miguel Cardoso Assmann", "124.824.979-81", conta1);

        cliente1.conta = conta1;

        conta1.depositar(100.0);
        conta1.sacar(100.00);
        System.out.println(cliente1);
    }
}