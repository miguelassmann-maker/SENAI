// tudo isso foi feito com IA, apenas queria ver como seria uma forma compacta para eu me inspirar ou seja não considere isto como um trabalho meu ou o que poderia interferir no meu progresso

package Aula20;

import java.util.*;

public class formaCompacta {
    // Classe interna compacta para representar o produto em um único objeto
    static class Produto {
        String nome; double preco; int qtd;
        Produto(String n, double p, int q) { nome = n; preco = p; qtd = q; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();
        String opt;

        System.out.println("bem vindo ao sistema");
        do {
            System.out.println("[1] adicionar produto\n[2] repor produto\n[3] vender produto\n[4] consultar estoque\n[5] remover todos produtos\n[0] sair");
            opt = sc.nextLine();

            switch (opt) {
                case "1" -> {
                    System.out.println("id do produto\n" + estoque.size() + "\ndigite o nome do produto");
                    String n = sc.nextLine();
                    System.out.println("digite o preço");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.println("digite a quantidade");
                    int q = Integer.parseInt(sc.nextLine());
                    estoque.add(new Produto(n, p, q));
                    System.out.println("produto cadastrado");
                }
                case "2", "3" -> {
                    if (estoque.isEmpty()) { System.out.println("nenhum produto cadastrado"); break; }
                    boolean isRepor = opt.equals("2");

                    System.out.println(isRepor ? "qual o id do produto que deseja repor?" : "qual o id do produto?");
                    int id = Integer.parseInt(sc.nextLine());

                    if (id >= 0 && id < estoque.size()) {
                        System.out.println(isRepor ? "quantidade pra adicionar" : "quantidade vendida?");
                        int qtd = Integer.parseInt(sc.nextLine());
                        Produto prod = estoque.get(id);

                        if (isRepor) {
                            prod.qtd += qtd;
                            System.out.println("produto reposto");
                        } else {
                            if (qtd <= prod.qtd) {
                                prod.qtd -= qtd;
                                System.out.println("venda realizada");
                                if (prod.qtd == 0) {
                                    estoque.remove(id);
                                    System.out.println("produto removido por falta de estoque");
                                }
                            } else System.out.println("sem estoque");
                        }
                    } else System.out.println("id invalido");
                }
                case "4" -> {
                    if (estoque.isEmpty()) { System.out.println("estoque vazio"); break; }
                    double valorTotal = 0;
                    for (int i = 0; i < estoque.size(); i++) {
                        Produto p = estoque.get(i);
                        System.out.println("id: " + i + "\nnome: " + p.nome + "\npreço: " + p.preco + "\nquantidade: " + p.qtd);
                        if (p.qtd <= 5) System.out.println("AVISO: estoque baixo (" + p.qtd + " unidades restantes)");
                        valorTotal += p.preco * p.qtd;
                        System.out.println("----------------");
                    }
                    System.out.println("valor total do estoque\n" + valorTotal);
                }
                case "5" -> {
                    System.out.println("deseja remover tudo?\n[1] sim\n[2] nao");
                    String rem = sc.nextLine();
                    if (rem.equals("1")) {
                        estoque.clear();
                        System.out.println("estoque apagado");
                    } else if (rem.equals("2")) System.out.println("cancelado");
                    else System.out.println("opção invalida");
                }
                case "0" -> System.out.println("programa encerrado");
                default -> System.out.println("opção invalida");
            }
        } while (!opt.equals("0"));
    }
}