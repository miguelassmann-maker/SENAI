package Aula18;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        ArrayList<String> cidades = new ArrayList<String>();
        cidades.add("Sorocaba");
        cidades.add("pernambuco");
        cidades.add("Tubarão");
        cidades.add(0,"São paulo");
        System.out.println(cidades);
    }
}
