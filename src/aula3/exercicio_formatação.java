package aula3;

public class exercicio_formatação {
    static void main(String[] args) {
    String nome = "Camaro";
    String marca = "Chevrolet";
    String placa = "QJI8B15";
    int ano = 2010;
    double valor = 532.840;

        System.out.printf("Vendo um %s por %.3f",nome,valor);
        System.out.printf("\nRegistro \n Placa: %s \n Marca: Chevrolet",placa,marca);

    }
}
