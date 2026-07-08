package AVA;

import java.util.Scanner;
public class atividadeCliente {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Voce é um cliente premium? \n [1] Sim \n [2] Não");
        int cliente = entrada.nextInt();

        System.out.println("Qual o Valor da compra?");
        double compra = entrada.nextDouble();

        if (cliente == 1 && compra > 300)
        {
            System.out.println("Voce recebeu 20% de desconto");
        }
        else if (cliente == 2 && compra > 300)
        {
            System.out.println("voce recebeu 10% de desconto");
        }
        else{
            System.out.println("Voce não recebeu desconto");
        }



    }
}
