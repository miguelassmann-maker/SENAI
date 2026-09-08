import java.util.ArrayList;
import java.util.Scanner;

class Prova {
    String nome;
    double nota;

    public Prova(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }
}

class Aluno {
    String nome;
    int matricula;
    ArrayList<Prova> provas = new ArrayList<>();

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    void adicionarProva(Prova prova) {
        provas.add(prova);
        System.out.println("Prova cadastrada com sucesso");
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
        exibirInformacoes();

        if (provas.size() == 0) {
            System.out.println("Nenhuma prova cadastrada");
        } else {
            System.out.println("Provas:");

            for (int i = 0; i < provas.size(); i++) {
                Prova prova = provas.get(i);
                System.out.printf("- %s: %.2f%n", prova.nome, prova.nota);
            }
        }
    }
}

class Escola {
    String nome;
    ArrayList<Aluno> alunos = new ArrayList<>();

    public Escola(String nome) {
        this.nome = nome;
    }

    void cadastrarAluno(Aluno aluno) {
        Aluno alunoEncontrado = buscarAluno(aluno.matricula);

        if (alunoEncontrado == null) {
            alunos.add(aluno);
            System.out.println("Aluno cadastrado com sucesso");
        } else {
            System.out.println("Essa matricula ja existe");
        }
    }

    void listarAlunos() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado");
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println("----------------");
                alunos.get(i).exibirInformacoes();
            }
        }
    }

    Aluno buscarAluno(int matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).matricula == matricula) {
                return alunos.get(i);
            }
        }

        return null;
    }

    int quantidadeAlunos() {
        return alunos.size();
    }

    int quantidadeAprovados() {
        int quantidade = 0;

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).verificarSituacao().equals("APROVADO")) {
                quantidade++;
            }
        }

        return quantidade;
    }

    int quantidadeRecuperacao() {
        int quantidade = 0;

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).verificarSituacao().equals("RECUPERACAO")) {
                quantidade++;
            }
        }

        return quantidade;
    }

    int quantidadeReprovados() {
        int quantidade = 0;

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).verificarSituacao().equals("REPROVADO")) {
                quantidade++;
            }
        }

        return quantidade;
    }

    double mediaGeral() {
        if (alunos.size() == 0) {
            return 0;
        }

        double soma = 0;

        for (int i = 0; i < alunos.size(); i++) {
            soma = soma + alunos.get(i).calcularMedia();
        }

        return soma / alunos.size();
    }

    void exibirEstatisticas() {
        System.out.println("Quantidade de alunos: " + quantidadeAlunos());
        System.out.println("Quantidade de aprovados: " + quantidadeAprovados());
        System.out.println("Quantidade em recuperacao: " + quantidadeRecuperacao());
        System.out.println("Quantidade de reprovados: " + quantidadeReprovados());
        System.out.printf("Media geral da escola: %.2f%n", mediaGeral());
    }
}

public class Main {
    static int lerInteiro(Scanner input) {
        while (!input.hasNextInt()) {
            if (!input.hasNextLine()) {
                return 0;
            }

            input.nextLine();
            System.out.println("Digite um numero valido");
        }

        int numero = input.nextInt();
        input.nextLine();
        return numero;
    }

    static double lerDouble(Scanner input) {
        while (!input.hasNextDouble()) {
            if (!input.hasNextLine()) {
                return 0;
            }

            input.nextLine();
            System.out.println("Digite uma nota valida");
        }

        double numero = input.nextDouble();
        input.nextLine();
        return numero;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Escola escola = new Escola("Escola Tecnica");
        int resposta;

        System.out.println("Bem vindo ao sistema de notas");

        do {
            System.out.println("\n[1] Cadastrar aluno");
            System.out.println("[2] Cadastrar prova");
            System.out.println("[3] Listar alunos");
            System.out.println("[4] Buscar aluno");
            System.out.println("[5] Exibir boletim");
            System.out.println("[6] Estatisticas da escola");
            System.out.println("[0] Sair");
            resposta = lerInteiro(input);

            switch (resposta) {
                case 1:
                    System.out.println("Digite o nome do aluno");
                    String nomeAluno = input.nextLine();

                    System.out.println("Digite a matricula do aluno");
                    int matricula = lerInteiro(input);

                    Aluno aluno = new Aluno(nomeAluno, matricula);
                    escola.cadastrarAluno(aluno);
                    break;

                case 2:
                    System.out.println("Digite a matricula do aluno");
                    int matriculaProva = lerInteiro(input);

                    Aluno alunoProva = escola.buscarAluno(matriculaProva);

                    if (alunoProva == null) {
                        System.out.println("Aluno nao encontrado");
                    } else {
                        System.out.println("Digite o nome da prova");
                        String nomeProva = input.nextLine();

                        System.out.println("Digite a nota");
                        double nota = lerDouble(input);

                        if (nota >= 0 && nota <= 10) {
                            alunoProva.adicionarProva(new Prova(nomeProva, nota));
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }
                    break;

                case 3:
                    escola.listarAlunos();
                    break;

                case 4:
                    System.out.println("Digite a matricula do aluno");
                    int matriculaBusca = lerInteiro(input);

                    Aluno alunoBusca = escola.buscarAluno(matriculaBusca);

                    if (alunoBusca == null) {
                        System.out.println("Aluno nao encontrado");
                    } else {
                        System.out.println("Aluno encontrado: " + alunoBusca.nome);
                    }
                    break;

                case 5:
                    System.out.println("Digite a matricula do aluno");
                    int matriculaBoletim = lerInteiro(input);

                    Aluno alunoBoletim = escola.buscarAluno(matriculaBoletim);

                    if (alunoBoletim == null) {
                        System.out.println("Aluno nao encontrado");
                    } else {
                        alunoBoletim.exibirBoletim();
                    }
                    break;

                case 6:
                    escola.exibirEstatisticas();
                    break;

                case 0:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } while (resposta != 0);

        input.close();
    }
}
