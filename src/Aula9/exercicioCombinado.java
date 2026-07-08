package Aula9;

import java.util.Scanner;
public class exercicioCombinado {
    /** Voce foi contratado como desenvolvedor junior em uma empresa do setor industrial.
     * sua missão é desenvolver um prototipo de sistema para controle de produção diaria
     * de maquina automatizadas. cada maquina da linha de produção gera uma quantidade
     * de peças por turno, e o sistema deve monitorar a produção e alertar a supervisão
     *  em casos fora do padrão
     *  A fabrica possui 5 maquinas principais, e cada uma trabalha em 3 turnos( manhã, tarde, noite)
     *  O gerente de produção deseja saber;
     *  Qual a quantidade total de peças produzidas por maquina no dia.
     *  se algum turno teve produção abaixa de 100 peças, deve-se gerar um alerta de baixa produtividade
     *  calcular a média de produção diaria por maquina
     */

    public static void main(String[] args) {
        int maquina = 1;
        int turno = 1;
        double media;
        int resposta;
        int minimo = 100;
        while (maquina <= 5){
        Scanner entradaMaquina = new Scanner(System.in);

        System.out.println("Vamos ver a média");
        System.out.println("Primeiro Digite qual maquina voce quer saber a média");
        maquina = entradaMaquina.nextInt();
        if (minimo < 100);{
                System.out.println("Produção com baixa produtividade");
            }




      }
    }
}
