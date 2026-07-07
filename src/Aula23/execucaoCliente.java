package Aula23;

import java.util.Scanner;

public class execucaoCliente {
    public static void main(String[] args) {
        Objetos2 cliente = new Objetos2();
        Scanner input = new Scanner(System.in);
        System.out.println("Qual seu nome?");
        cliente.nome = input.nextLine();
        System.out.println("Qual sua idade");
        cliente.idade = input.nextInt();
        System.out.println("Você possui dividas?");
        System.out.println(" SIM = true não = false");
        cliente.possuiDivida = input.nextBoolean();
        System.out.println("Qual seu salario");
        cliente.Salario = input.nextDouble();

        System.out.println("O que voce deseja fazer");
        System.out.println(" [1] para comprar\n [2] para vender");
        input.nextLine();
        int resposta = input.nextInt();
        do{
            if(resposta == 1) {
                cliente.comprar();
                break;
            } else if (resposta == 2) {
                cliente.vender();
                break;


            }else {
                System.out.println("Digite um valor valido");
        }
        }while (resposta != 1 || resposta != 2);
    }

}
