package Aula23;

public class Objetos2 {
    String nome;
    Integer idade;
    Double Salario;
    Boolean possuiDivida;

    void comprar(){
        if(possuiDivida = true){
            System.out.printf("%s não poderá comprar, pois possui divida\n",this.nome);
        }else{
            System.out.printf("%s poderá realizar a compra, pois não possui dividas\n");
        }
    }
    void vender(){
        System.out.printf("Você está aprovado para realizar a vendas");

    }
}
