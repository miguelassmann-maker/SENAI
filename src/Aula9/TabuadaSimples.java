package Aula9;

import java.util.Scanner;

public class TabuadaSimples {
    public static void main(String[] args) {
        int resposta;
        int multiplicador = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Favor informar qual o número" + "para gerarmos a tabuada");
        resposta = entrada.nextInt();
        while (multiplicador <= 20){
            int resultado = resposta * multiplicador;
            System.out.printf("%d x %d = %d\n",resposta,multiplicador,resultado);
            multiplicador ++;
        }
    }
}
