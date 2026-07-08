package Aula7;

import java.util.Scanner;

public class SwitchCase2 {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String tipoUsuario;
        System.out.println("Escreva seu tipo de usuário");
        System.out.println("gerente\nsupervisor\nvendedor");
        tipoUsuario = entrada.nextLine();
        switch (tipoUsuario){
            case  "gerente":
                System.out.println("Tem acesso total aos módulos");
                break;
            case  "Supervisor":
                System.out.println("tem acesso aos módulos de Dashboard" + "e vendas");
                break;
            case  "vendedor":
                System.out.println("Tem acesso apenas aos módulos de vendas");
        }

    }
}
