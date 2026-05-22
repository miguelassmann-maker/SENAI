package Aula17;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExercicioReforco {

    public static void main (String[]args){
        /**RH - Cadastra de funcionarios
         * Voce precisa criar um sistema que seja possivel
         * cadastrar os funcionario e verificar as informações
         * para isso, voce definir as seguintes questoes
         * para cadastro do funcionario precisa de, nome
         * cpf idade, senha
         * para consulta do funcionario precisa está logado
         * e identificar qual o id do funcionário que precisa
         * para a consulta.
         * o usuario deve definir quantos funcionários serão cadastrados
         * **/



    // parte do scanner ( estou aprendendo ainda, pode estar incorreto )
        Scanner entradatexto = new Scanner(System.in);
        Scanner entradanumero = new Scanner(System.in);

        // parte do cadastro ( não é IA matheus [emoji de joinha muito foda e aurastico] )
        int QTDfuncionarios;

        System.out.println("quantos funcionarios voce quer cadastrar?");
        QTDfuncionarios = entradanumero.nextInt();
        //parte das variaveis com vetores ( tambem estou aprendendo, e tenho bastante dificuldade )
        String [] NomeFuncionario = new String[QTDfuncionarios];
        String [] CPFfuncionario = new String[QTDfuncionarios];
        int [] IdadeFuncionario = new int[QTDfuncionarios];

        for (int i = 0; i < QTDfuncionarios; i++){
        System.out.println("Qual seu nome");
        NomeFuncionario[i] = entradatexto.nextLine();
}
        for (int i = 0; i < QTDfuncionarios; i++){
            System.out.println("Qual seu CPF");
            CPFfuncionario[i] = entradatexto.nextLine();
        }
        for (int i = 0; i < QTDfuncionarios; i++){
            System.out.println("Qual sua idade");
            IdadeFuncionario[i] = entradatexto.nextInt();
        }
    }
}