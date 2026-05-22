package Aula15;

public class ExercicioVetores {

    public static void main(String[] args) {
        /*
         * Você é um gerente de hotel e quer entender o fluxo de pessoas
         * por semana, durante 2 semanas
         * para poder fazer uma janta e com isso não faltar comida e evitar desperdício
         * Desta forma você precisa obter as seguintes informações:
         * Obs: (Lembrando que neste hotel o restaurante funciona os 7 dias da semana)
         *
         * Você pode fazer com os dados fixos, ou com os dados dinâmicos
         * através da inserção do usuário.
         * Número total de pessoas
         * Número total de pessoas na primeira Semana
         * Número total de pessoas na segunda Semana
         * Tirar uma média de pessoas por dia [cortado]
         */
        int [] asdasd = new int[2];
        int[] semana1 = {1,4,5,9,12,16,44};
        int [] semana2 = {5,77,2,44,55,32,56};
        int [] Media = {semana1[0] + semana1[1] + semana1[2] + semana1[3] + semana1[4] + semana1[5] + semana1[6] + semana2[0] + semana2[1] + semana2[2] + semana2[3] + semana2[4] + semana2[5] + semana2 [6]};
        System.out.println("Total Semana 1");
        int totalsemana1 = semana1[0] + semana1[1] + semana1[2] + semana1[3] + semana1[4] + semana1[5] + semana1[6];
        System.out.println(totalsemana1);
        System.out.println("Total Semana 2");
        int totalsemana2 = semana2[0] + semana2[1] + semana2[2] + semana2[3] + semana2[4] + semana2[5] + semana2 [6];
        System.out.println(totalsemana2);
        System.out.println("Total das 2 semanas");
        int totalsemanas = totalsemana1 + totalsemana2;
        System.out.println(totalsemanas);
        System.out.println("Média de pessoas por dia");
        int mediadiaria = totalsemanas/14;
        System.out.println(mediadiaria);

    }
}