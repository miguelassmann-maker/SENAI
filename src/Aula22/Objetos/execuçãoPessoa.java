package Aula22.Objetos;

public class execuçãoPessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Maria";
        p1.CPF = "100.300.500-23";
        p1.idade = 18;
        p1.sexo = 'M';
        p1.peso = 58.0;
        p1.altura = 1.60;
        p1.nacionalidade = "Picanosregus";
        p1.estadoCivil = "Casado";
        p1.informacoes();
    }


}
