package aula3;
import java.util.Scanner;
public class carro {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nome, marca, placa;
        int ano;
        double valor;
        System.out.println("por favor insira os dados do carro que voce deseja vender.");
        System.out.println("Nome do carro por favor");
        nome = entrada.nextLine();
        System.out.println("Marca do carro por favor");
        marca = entrada.nextLine();
        System.out.println("Placa do carro por favor");
        placa = entrada.nextLine();
        System.out.println("Ano do Carro por favor");
        ano = entrada.nextInt();
        System.out.println("Valor do carro por favor");
        valor = entrada.nextDouble();
        System.out.println("Segue abaixo os dados do seu carro: ");
        System.out.printf("Nome do carro: %s\n", nome);
        System.out.printf("Marca do carro: %s\n", marca);
        System.out.printf("Placa do carro: %s\n", placa);
        System.out.printf("Ano do carro: %d\n", ano);
        System.out.printf("Valor do carro: %.2f\n", valor);

    }
}
