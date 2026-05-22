package aula2;

public class ExercicioOperadores {
    static void main(String[] args) {
        /* Crie as variaveis nome, cor, raça, de um cachorro
        depois crie uma condição verificando se o cachorro tem mais de anos para poder tomar vacina, se tiver, pode tomar a vacina.
        se não, não pode
         */
        String nome = "Pica";
        String cor = "Roxo";
        String raca = "budercoole";
        int idade = 5;

        System.out.println("Pode Tomar vacina?");
        String resultado = idade >= 5? "Sim": "Não";
        System.out.println(resultado);
    }
    }

