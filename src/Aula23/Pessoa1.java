package Aula23;

public class Pessoa1 {
    String nome;
    String CPF;
    Integer idade;
    char sexo;
    Double peso;
    Double altura;
    String nacionalidade;
    String estadoCivil;

    void andar() {
        System.out.printf("O %s está andando", this.nome);
    }
    void correr() {
        System.out.printf("O %s está correndo\n", this.nome);
    }
    void informacoes(){
        System.out.printf("O nome dessa pessoa é %s\n",this.nome);
        System.out.printf("O CPF dessa pessoa é%s\n",this.CPF);
        System.out.printf("A idade dessa pessoa é %s\n",this.idade);
        System.out.printf("O sexo dessa pessoa é %s\n",this.sexo);
        System.out.printf("O peso dessa pessoa é %.2f\n",this.peso);
        System.out.printf("A altura dessa pessoa é %.2f\n",this.altura);
        System.out.printf("A nacionalidade dessa pessoa é %s\n",this.nacionalidade);
        System.out.printf("O estado civil dessa pessoa é %s\n",this.estadoCivil);
        








}

}
