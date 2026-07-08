package Aula21;

import java.util.ArrayList;

public class revisao {
    public static void main(String[] args) {
        ArrayList<Integer> numero = new ArrayList<Integer>();
        numero.add(100);numero.add(200);numero.add(300);
        System.out.println(numero.size());
        for(Integer numeros : numero){
            System.out.println(numeros);
        }
    }
}
