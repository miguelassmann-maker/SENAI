    package aula4;

    public class Exercicio {
        /* * Crie 3 condições, onde elas irão fazer as seguintes validações:
         * 1' Maria tem mais de 18 anos, se for igual sim,
         * então Maria poderá entrar na festa.
         * 2' Robson tem mais de 16 anos, se for igual sim,
         * então Robson não poderá trabalhar como menor aprendiz.
         * 3' Se o carro custar mais de 100mil reais,
         * então Marcos não poderá comprar o carro no momento.
         */

            public static void main(String[] args) {

                int idadeMaria = 18;
                int idadeRobson = 24;
                double precoCarro = 180000.00;

                if (idadeMaria > 18) {
                    System.out.println("Maria poderá entrar na festa.");
                } else if (idadeMaria == 18) {
                    System.out.println("Maria tem 18 anos e precisa de autorização.");
                } else {

                    System.out.println("Maria é menor de idade e não pode entrar.");
                }

                if (idadeRobson > 16) {
                    System.out.println("Robson não poderá trabalhar como menor aprendiz.");
                } else if (idadeRobson >= 14 && idadeRobson <= 16) {
                    System.out.println("Robson está na faixa de idade para ser menor aprendiz.");
                } else {
                    System.out.println("Robson é muito jovem para trabalhar.");

                }

                if (precoCarro > 100000.00) {
                    System.out.println("Marcos não poderá comprar o carro no momento.");
                } else if (precoCarro == 100000.00) {
                    System.out.println("O carro custa literalmente 100mil.");
                } else {
                    System.out.println("O carro custa menos de 100mil. Marcos pode comprar!");

                }
            }
        }

