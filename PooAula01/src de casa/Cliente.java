import java.util.ArrayList;

class Aluno {
    String nome;
    int matricula;
    ArrayList<Prova> provas = new ArrayList<>();

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    void adicionarProva(Prova prova) {
        if (prova.nota >= 0 && prova.nota <= 10) {
            provas.add(prova);
            System.out.println("Prova cadastrada com sucesso");
        } else {
            System.out.println("Nota invalida");
        }
    }

    double calcularMedia() {
        if (provas.size() == 0) {
            return 0;
        }

        double soma = 0;

        for (int i = 0; i < provas.size(); i++) {
            soma = soma + provas.get(i).nota;
        }

        return soma / provas.size();
    }

    String verificarSituacao() {
        double media = calcularMedia();

        if (media >= 7) {
            return "APROVADO";
        } else if (media >= 5) {
            return "RECUPERACAO";
        } else {
            return "REPROVADO";
        }
    }

    void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.printf("Media: %.2f%n", calcularMedia());
        System.out.println("Situacao: " + verificarSituacao());
    }

    void exibirBoletim() {
        System.out.println("========================");
        System.out.println("BOLETIM");
        System.out.println("========================");
        System.out.println("Aluno: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Provas:");

        if (provas.size() == 0) {
            System.out.println("Nenhuma prova cadastrada");
        } else {
            for (int i = 0; i < provas.size(); i++) {
                System.out.printf("%s %.2f%n", provas.get(i).nome, provas.get(i).nota);
            }
        }

        System.out.printf("Media: %.2f%n", calcularMedia());
        System.out.println("Situacao: " + verificarSituacao());
        System.out.println("========================");
    }
}
