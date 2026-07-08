package Aula8;

import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args) {
        String nome, cpf;
        double salario;
        int idade, id = 0;
        Scanner entradaTexto = new Scanner(System.in);
        Scanner entradaNumeros = new Scanner(System.in);

        System.out.println("Vamos iniciar o seu cadastro");
        System.out.println("Para fazermos o seu cadastro" + "vamos solicitar algumas informações");
        nome = entradaTexto.nextLine();
        System.out.println("Qual a sua idade");
        idade = entradaNumeros.nextInt();
        System.out.println("Qual seu CPF");
        cpf = entradaTexto.nextLine();
        System.out.println("Qual seu salario atual");
        salario = entradaNumeros.nextDouble();
        id = id + 1;
        int resposta = 9;
        do {
            System.out.println("Agora que cadastramos, qual função" + "você deseja realizar");
            System.out.println("Consultar cadastro digite [1]");
            System.out.println("Consultar versão do sistema digite [2]");
            System.out.println("Alterar cadastro digite [3]");
            System.out.println("Sair do sistema digite [0]");
            resposta = entradaNumeros.nextInt();
            switch (resposta) {
                case 1:
                    System.out.printf("Seu id é: %d\n", id);
                    System.out.printf("Seu nome é: %s\n", nome);
                    System.out.printf("Sua idade é: %d\n", idade);
                    System.out.printf("Seu cpf é: %s\n", cpf);
                    System.out.printf("Seu salário é: %.2f", salario);
                    break;
                case 2:
                    System.out.println("O sistema está na versão 2.0");
                    System.out.println("O Sistema utiliza W11");
                    System.out.println("Ultima atualização 28/04/2026" + "as 20:00");
                    break;
                case 3:
                    System.out.println("Digite o novo nome?");
                    nome = entradaTexto.nextLine();
                    System.out.println("Digite a nova idade");
                    idade = entradaNumeros.nextInt();
                    System.out.println("Digite o novo CPF");
                    cpf = entradaTexto.nextLine();
                    System.out.println("Digite o novo salario atual");
                    salario = entradaNumeros.nextDouble();
                    break;
                default:
            }
        } while (resposta != 0);


    }
}
