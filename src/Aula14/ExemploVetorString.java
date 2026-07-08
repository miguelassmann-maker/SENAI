package Aula14;

public class ExemploVetorString {
    static void main(String []args){
        String [] nomes = {"Matheus","Nemo","Noah"};
        int i, n = nomes.length;
        for (i = 0; i < n; i++){
        System.out.printf("%d nome = %s\n", (i + 1), nomes[i]);

    }
}
}