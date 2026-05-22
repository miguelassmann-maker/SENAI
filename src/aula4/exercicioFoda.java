package aula4;

public class exercicioFoda {

    public static void main(String[] args) {

        int idadeMaria = 18;
        int idadeTadeu = 16;
        double precoCarro = 90000.00;

        System.out.println("=== VERIFICAÇÕES DO SISTEMA ===\n");

        verificarMaria(idadeMaria);
        verificarTadeu(idadeTadeu);
        verificarCarro(precoCarro);
    }

    public static void verificarMaria(int idade) {
        System.out.println(">>> Analisando Maria...");

        if (idade >= 18) {
            System.out.println("✔ Maria pode entrar na festa 🎉");
        } else {
            System.out.println("✖ Maria não pode entrar na festa 🚫");
        }

        System.out.println();
    }

    public static void verificarTadeu(int idade) {
        System.out.println(">>> Analisando Tadeu...");

        if (idade >= 16) {
            System.out.println("✖ Tadeu NÃO pode ser menor aprendiz ❌");
        } else if (idade >= 14) {
            System.out.println("✔ Tadeu pode ser menor aprendiz 💼");
        } else {
            System.out.println("⚠ Tadeu é muito novo para trabalhar");
        }

        System.out.println();
    }

    public static void verificarCarro(double preco) {
        System.out.println(">>> Analisando compra do carro...");

        if (preco > 100000) {
            System.out.println("💸 Carro caro demais! Marcos não pode comprar.");
        } else {
            System.out.println("🚗 Preço ok! Marcos pode comprar o carro.");
        }

        System.out.println("\n=== FIM DAS VERIFICAÇÕES ===");
    }
}