package Aula18;

import java.util.Scanner;

public class Matriz2 {
    public static void main(String[] args){
        int [] [] matriz = new int[3][3];
        Scanner input = new Scanner(System.in);
        /*jogo de 3x3 independente da direção tem que fechar
        * onde os devem ser dinidos a quantidade de alunos
        * e a quantidade de notas*/
        System.out.println("Digite a quantidade de alunos");
        int qtAlunos = input.nextInt();
        System.out.println("Digite a quantidade de notas");
        int qtNotas = input.nextInt();

        for (int i = 0; i < qtAlunos; i++) {
            matriz [i][0] = i;
            for (int j = 0; j < 3; j++) {
                matriz [i][j] = input.nextInt();
            }

        }
        for (int i = 0; i <qtAlunos; i++){
            System.out.printf("Aluno id: %d ", i);
            for (int j = 0; j < qtNotas; j++){
                System.out.printf("Nota%d = %d ",j+1,matriz[i][j]);
        }
    }

    }
}
