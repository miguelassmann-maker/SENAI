package Aula7;

import java.util.Scanner;

public class LacoWhile {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nome;
        int idade;
        System.out.println("para cadastrar no exercito" + "informe seu nome e sua idade");
        System.out.println("informe seu nome");
        nome = entrada.nextLine();
        System.out.println("informe sua idade");
        idade = entrada.nextInt();
        while (idade <= 18) {
            System.out.println("voce deseja servir?");
            System.out.println("[1] para sim\n[2]para não");
            int resposta;
            resposta = entrada.nextInt();
            if (resposta == 1) {
                System.out.println("Bem vindo ao exercito");
                break;
            } else if (resposta == 2) {

                    System.out.println("Digite 19 para Sair");
                    idade = entrada.nextInt();
                }else {
                    System.err.println("Digite um número entre 1 e 2");
                }
            }
        }
    }
