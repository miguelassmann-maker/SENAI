package ProjetoEmGrupo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemasdeCadastro {
    public static void main(String[] args) {
        ArrayList<String> Auditoria = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        ArrayList<String> Nome = new ArrayList<String>();
        ArrayList<String> Cpf = new ArrayList<>();
        ArrayList<String> Telefone = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<String>();
        ArrayList<String> Cidade = new ArrayList<String>();
        ArrayList<String> Estado = new ArrayList<String>();
        ArrayList<Date> Date = new ArrayList<Date>();
        ArrayList<String> Status = new ArrayList<String>();
        String entradatexto;
        Integer resposta = 0;
        System.out.println("Bem vindo ao CRM empresarial");
        do {
            System.out.println("[1] para cadastrar clientes");
            System.out.println("[2] para data de cadastro");
            System.out.println("[3] para alterar cliente");
            System.out.println("[4] para excluir cliente");
            System.out.println("[5] para relatorio");
            System.out.println("[6] para clientes por data ");
            System.out.println("[7] para auditoria");
            resposta = input.nextInt();
            input.nextLine();
            switch (resposta) {

                case 1:
                    System.out.println("Nome:");
                    Nome.add(input.next());

                    System.out.println("Cpf:");
                    Cpf.add(input.next());

                    System.out.println("telefone:");
                    Telefone.add(input.next());

                    System.out.println("Email:");
                    Email.add(input.next());

                    System.out.println("Cidade:");
                    Cidade.add(input.next());

                    System.out.println("Estado:");
                    Estado.add(input.next());

                    System.out.println("Staus (Ativo/Inativo:");
                    Status.add(input.next());

                    Date.add(new Date());
                    Auditoria.add(new Date() + "- Cliente cadastrado:");
                    System.out.println("Cliente cadastrado!");
                    break;

                case 2:
                    System.out.println("Digite o seu cpf:");
                    String buscarcpf = input.nextLine();
                    boolean achou = false;
                    for (int i = 0; i < Cpf.size(); i++) {
                        if (Cpf.get(i).equals(buscarcpf)) {
                            achou = true;
                            System.out.println("Nome:" + Nome.get(i));
                            System.out.println("Cpf:" + Cpf.get(i));
                            System.out.println("Telefone:" + Telefone.get(i));
                            System.out.println("Email:" + Email.get(i));
                            System.out.println("Cidade:" + Cidade.get(i));
                            System.out.println("Estado:" + Estado.get(i));
                            System.out.println("Status:" + Status.get(i));

                        }
                    }

                    if (!achou) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;


                case 3:
                    System.out.println("Qual o cpf do cliente");
                    String CpfDigitado = input.nextLine();
                    boolean encontrado = false;

                    for (int j = 0; j < Cpf.size(); j++) {
                        if (Cpf.get(j).equals(CpfDigitado)) {
                            encontrado = true;
                            System.out.println("Novo nome:");
                            Nome.set(j, input.next());
                            System.out.println("Novo telefone:");
                            Telefone.set(j, input.next());
                            System.out.println("Novo email:");
                            Email.set(j, input.next());
                            System.out.println("Nova cidade:");
                            Cidade.set(j, input.next());
                            System.out.println("Novo estado:");
                            Estado.set(j, input.next());

                            System.out.println("Novo status (Ativo/Inativo):");
                            Status.set(j, input.next());

                            System.out.println("Cliente alterado com sucesso!");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o CPF do cliente que deseja excluir:");
                    String cpfExcluir = input.nextLine();
                    int indexExcluir = -1;

                    for (int i = 0; i < Cpf.size(); i++) {
                        if (Cpf.get(i).equals(cpfExcluir)) {
                            indexExcluir = i;
                        }

                    }
                    if (indexExcluir == -1) {
                        System.out.println("Cliente não encontrado.");
                    } else {
                        System.out.println("Confirma exclusão de" + Nome.get(indexExcluir) + "?(S/N)");
                        String confirma = input.nextLine();

                        if (confirma.equalsIgnoreCase("S")) {
                            Auditoria.add(new Date() + "- Cliente excluido:" + Nome.get(indexExcluir) + "(CPF:" + Cpf.get(indexExcluir) + ")");
                            Nome.remove(indexExcluir);
                            Cpf.remove(indexExcluir);
                            Telefone.remove(indexExcluir);
                            Email.remove(indexExcluir);
                            Cidade.remove(indexExcluir);
                            Estado.remove(indexExcluir);
                            Status.remove(indexExcluir);
                            Date.remove(indexExcluir);
                            System.out.println("Cliente excluido com sucesso.");
                        } else {
                            System.out.println("Exclusão cancelada.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("[8] Relatório geral");
                    System.out.println("[9] somente ativos");
                    System.out.println("[10] somente inativos");
                    int opcaoRelatorio = input.nextInt();

                    System.out.println("Total de clientes:" + Nome.size());
                    for (int i = 0; i < Nome.size(); i++) {
                        if (opcaoRelatorio == 1 ||
                                (opcaoRelatorio == 2 && Status.get(i).equalsIgnoreCase("Ativo")) ||
                                (opcaoRelatorio == 3 && Status.get(i).equalsIgnoreCase("Inativo"))) {
                            System.out.println(Nome.get(i) + "-" + Cpf.get(i) + Status.get(i));

                        }
                        break;
                    }
                case 6:
                    ArrayList<String> datasUnicas = new ArrayList<>();
                    ArrayList<Integer> quantidades = new ArrayList<>();
                    for (int i = 0; i < Date.size(); i++) {
                        String dataAtual = Date.get(i).toString();
                        boolean jaExiste = false;

                        for (int j = 0; j < datasUnicas.size(); j++) {
                            if (datasUnicas.get(j).equals(dataAtual)) {
                                jaExiste = true;
                                quantidades.set(j, quantidades.get(j) + 1);
                            }
                        }
                        if (!jaExiste) {
                            datasUnicas.add(dataAtual);
                            quantidades.add(1);
                        }

                    }
                    for (int j = 0; j < datasUnicas.size(); j++) {
                        System.out.println(datasUnicas.get(j));
                        System.out.println(quantidades.get(j) + "clientes");
                    }
                    break;
                case 7:
                    if (Auditoria.isEmpty()) {
                        System.out.println("Nenhum registro de auditoria.");
                    } else{
                        for (String registro : Auditoria){
                            System.out.println(registro);
                        }
                    }
                    break;
            }
        }while (resposta != 0) ;


    }

}