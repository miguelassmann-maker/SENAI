package Aula19;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCRM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> idade = new ArrayList<Integer>();
        ArrayList<Double> salario = new ArrayList<Double>();
int resposta;
        System.out.println("Bem vindo ao sistema");
        do{
            System.out.println("[1] para cadastrar um novo cliente");
            System.out.println("[2] para consultar um cliente");
            System.out.println("[9] Para verificar a versão do sistema");
            resposta = input.nextInt();

        }while (resposta !=0);
    }
}
