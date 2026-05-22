package Aula18;

public class Matriz {
    public static void main(String[] args) {
        int [] [] matriz = new int [3][3];
        matriz [0] [0] = 1;
        matriz [1] [2] = 5;

        System.out.println(matriz[0][0]);

        int [][] secondMatriz ={
                {1,2,3},
                {4,5,6},
                {8,9,10}
        };
        System.out.println(secondMatriz[1][1]);
    }
}
