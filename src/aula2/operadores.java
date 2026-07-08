package aula2;

import java.sql.SQLOutput;

public class operadores {
    public static void main(String[] args){
        String nome = "tadeu";
        int idade = 17;
        int a,b,c,d,e;
        a = 10;
        b = 5;
        c = 3;
        d = 20;
        e = -1;
        System.out.println("A é maior que B?");
        System.out.println(a>b);
        System.out.println("C é menor ou igual a 0?");
        System.out.println(c<=d);
        System.out.println("E é número positivo?");
        System.out.println(e>0);

        System.out.println("Tadeu atingiu a maior idade?");
        String resultado = idade >= 18? "Sim": "Não";
        System.out.println(resultado);
    }
}
