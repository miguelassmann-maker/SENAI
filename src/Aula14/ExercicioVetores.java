package Aula14;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExercicioVetores {
   public static void main(String[] args) {
       Scanner entradaTexto = new Scanner(System.in);
       Scanner entradaNumero = new Scanner(System.in);
       int qtAlunos, qtNotas;
       System.out.println("Quantos alunos você quer registrar\n");
       qtAlunos = entradaNumero.nextInt();
       System.out.println("Quantas notas você quer registrar");
       qtNotas = entradaNumero.nextInt();
       String [] alunos = new String[qtAlunos];
        int [] notas = new int[qtNotas];
        for (int i = 0; i < qtAlunos; i++){
            System.out.println("Digite o nome do aluno: \n");
            alunos[i] = entradaTexto.nextLine();
            for (int n = 0; n < qtNotas ; n++){
                System.out.println("Digite as notas do aluno:\n");
                notas[n] = entradaNumero.nextInt();

            }
        }
    }
}



