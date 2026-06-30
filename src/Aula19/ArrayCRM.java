package Aula19;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCRM {

    public static void main(String[] args) {
        int id = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> cpf = new ArrayList<>();
        ArrayList<Integer> idade = new ArrayList<>();
        ArrayList<Double> salario = new ArrayList<Double>();
        int resposta;

        System.out.println("Bem vindo ao sistema");
        do {
            System.out.println("\n[1] para cadastrar um novo cliente");
            System.out.println("[2] para consultar um cliente");
            System.out.println("[3] para solicitar emprestimo");
            System.out.println("[4] para limpar os dados");
            System.out.println("[5] para alterar dados");
            System.out.println("[9] Para verificar a versão do sistema");
            System.out.println("[0] Para sair");
            resposta = input.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("O Id do cadastro deste cliente é");
                    System.out.println(id);
                    input.nextLine();

                    System.out.println("Digite o nome do cliente");
                    nomes.add(input.nextLine());
                    System.out.println("Digite o CPF do cliente");
                    cpf.add(input.nextLine());
                    System.out.println("Digite a idade do cliente");
                    idade.add(input.nextInt());
                    System.out.println("Digite o salário do cliente");
                    salario.add(input.nextDouble());
                    id++;
                    break;

                case 2:
                    System.out.println("Para consultar digite o id do cadastro desejado");
                    int consulta = input.nextInt();

                    if (consulta >= 0 && consulta < nomes.size()) {
                        System.out.printf("Nome do cliente: %s%n", nomes.get(consulta));
                        System.out.printf("Cpf do cliente: %s%n", cpf.get(consulta));
                        System.out.printf("Idade do cliente: %d%n", idade.get(consulta));
                        System.out.printf("Salario do cliente: %.2f%n", salario.get(consulta));
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("digite o ID do cliente");
                    int ID = input.nextInt();


                    if (ID >= 0 && ID < salario.size()) {
                        double salarioCliente = salario.get(ID);

                        System.out.println("Cliente selecionado: " + nomes.get(ID));
                        System.out.println("Digite o Valor do empréstimo");
                        double capitalInicial = input.nextDouble();

                        System.out.println("quantas vezes quer parcelar? (24, 36 ou 48)");
                        int tempo = input.nextInt();


                        double juros = 0.018;

                        if (tempo == 24 || tempo == 36 || tempo == 48) {

                            double montantetotal = capitalInicial * Math.pow((1 + juros), tempo);
                            double valorParcela = montantetotal / tempo;
                            double limiteMaximo = salarioCliente * 0.10;

                            System.out.println("Teu resultado seu porra seca, vai me pedir pra criar codigo pra ti fazer juros seu merda");
                            System.out.printf("Valor total com juros: R$ %.2f%n", montantetotal);
                            System.out.printf("Valor da parcela: R$ %.2f%n", valorParcela);
                            System.out.printf("Maximo permitido: R$ %.2f%n", limiteMaximo);

                            if (valorParcela <= limiteMaximo) {
                                System.out.println("emprestimo aprovado");
                            } else {
                                System.out.println("Emprestimo negado ( Fudido kkkkkk)");
                            }
                        } else {
                            System.out.println("Escolhe certo caralho, só tem 24,36 ou 48");
                        }
                    } else {
                        System.out.println("ID invalido");
                    }
                    break;

                case 4:

                    System.out.println("Dados limpos");

                    nomes.clear();
                    idade.clear();
                    cpf.clear();
                    salario.clear();

                case 5:

                    System.out.println("Qual ID você quer alterar os dados?");
                    int idAlterar = input.nextInt();

                    if (idAlterar >= 0 && idAlterar < nomes.size()) {


                    System.out.printf("Selecione oque quer mudar:\n");
                    System.out.println("[1] Nome");
                    System.out.println("[2] Idade");
                    System.out.println("[3] CPF");
                    System.out.println("[4] Salario");
                    int opçãoAlterar = input.nextInt();

                    input.nextLine();

                    switch (opçãoAlterar) {


                        case 1:
                            System.out.println("Qual o novo nome");
                            String novoNome = input.nextLine();
                            nomes.set(idAlterar, novoNome);
                            break;

                        case 2:
                            System.out.println("Qual a nova idade");
                            int novaIdade = input.nextInt();
                            idade.set(idAlterar, novaIdade);
                            break;

                        case 3:
                            System.out.println("Qual a novo CPF");
                            String novoCPF = input.nextLine();
                            cpf.set(idAlterar, novoCPF);
                            break;

                        case 4:
                            System.out.println("Qual o novo salario");
                            Double novoSalario = input.nextDouble();
                            salario.set(idAlterar, novoSalario);
                            break;

                        default:
                            System.out.println("opção alterada Invalida");
                            break;
                    }
                        System.out.println("Dado alterado com sucesso");
                    }else {
                        System.out.println("ID invalido");
                    }
                    break;
                case 9:
                    System.out.println("Versão do sistema: 1.0");
                    break;

                case 0:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("essa opção n existe, faz dnv");
                    break;
            }

        } while (resposta != 0);

        input.close();
    }
}