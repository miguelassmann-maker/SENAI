package AVA;
import java.util.Scanner;

public class atividadeEstacionamento {
    static void main() {


Scanner scanner = new Scanner(System.in);
        System.out.println("Voce possui um ticket valido? [1] Sim [2] Não");
        int ticket = scanner.nextInt();
        if (ticket == 1){
            System.out.println("Cancela Abre");
        }

        else if (ticket == 2) {
            System.out.println("Fica ai seu merda");


        }
        else {
            System.out.println("Voce não digitou certo");
        }

    }
}
