package aula5;

import java.util.Scanner;

public class OperadorCredito {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*
         * Crie uma regra condicional, onde ela valide os seguintes
         * pontos.
         * Se a pessoa não tiver divida, for maior ou igual a 18
         * anos, pode aprovar o emprestimos direto.
         * Se a pessoa tiver divida e o salário for maior que 5000
         * o emprestimo deverá cair em análise.
         * Se a pessoa tiver divida e o salário fr menor que 5000
         * o sistema deverá negar o emprestimo automaticamente.
         */
        String nome, cpf;
        int idade, divida;
        double salario;
        System.out.println("Para solicitar um emprestimo, digite" + "os seus dados");
        System.out.println("Digite seu nome por favor");
        nome = entrada.nextLine();
        System.out.println("Digite seu CPF");
        cpf = entrada.nextLine();
        System.out.println("Digite sua idade por favor");
        idade = entrada.nextInt();
        System.out.println("Você possui dividas\n[1] para sim\n" +
                "[2] para não");
        divida = entrada.nextInt();
        System.out.println("Digite seu salário por favor");
        salario = entrada.nextDouble();

// Divida e idade
        if (divida == 2 && idade >= 18) {
            System.out.println("Emprestimo aprovado");
        }





        /*
        if (salario > 5000) {
        } else
            System.out.println("seu emprestimo foi negado");
        if (divida == 2 && idade >= 18) {
            System.out.println("emprestimo foi aprovado");


            if (salario > 5000 && divida == 1)
                System.out.println("seu emprestimo entrou em analise");
        }
        if (salario < 5000 && divida == 1) {
            System.out.println("seu emprestimo foi negado");
        }*/
    }
}