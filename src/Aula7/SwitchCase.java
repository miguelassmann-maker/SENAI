package Aula7;

import java.util.Scanner;

public class SwitchCase {
    static void main(String[] args) {
        String turno = "Manhã", turno2 = "Tarde", turno3 = "Noite";
        Scanner entrada = new Scanner(System.in);
        int numeroTurno;
        System.out.println("Informe o seu horario de entrada");
        System.out.println("Que eu informarei seu turno");
        numeroTurno = entrada.nextInt();
        switch (numeroTurno){
            case 1:
                System.out.printf("Seu horario de entrada é %s\n",turno);
                System.out.printf("das 8:00 as 12:00 e 13:00 as 17:00");
                break;
            case 2:
                System.out.printf("Seu horario de entrada é%s\n",turno2);
                System.out.printf("das 14:00 as 18:00 e 19:00 as 23:00");
                break;
            case 3:
                System.out.printf("Seu horario de entrada é%s\n",turno3);
                System.out.printf("das 22:00 as 02:00 e 03:00 as 07:00");
                break;
            default:
                System.err.printf("Informe um número entre 1 e 3");
        }

    }
}
