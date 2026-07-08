package Aula20;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeEstoque {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner inputNumero = new Scanner(System.in);

        ArrayList<String> nome = new ArrayList<>(); // Nome do produto
        ArrayList<Double> preco = new ArrayList<>(); // Preço do produto
        ArrayList<Integer> quantidade = new ArrayList<>(); // Quantidade do produto

        int resposta;
        int id = 0; // ID inicia em 0

        System.out.println("bem vindo ao sistema");

        do {

            System.out.println("[1] adicionar produto");
            System.out.println("[2] repor produto");
            System.out.println("[3] vender produto");
            System.out.println("[4] consultar estoque");
            System.out.println("[5] remover todos produtos");
            System.out.println("[0] sair");

            resposta = inputNumero.nextInt();

            switch (resposta) {

                case 1:

                    System.out.println("id do produto");
                    System.out.println(id); // Printa o ID atual do produto, iniciando em 0

                    System.out.println("digite o nome do produto");
                    nome.add(input.nextLine());

                    System.out.println("digite o preço");
                    preco.add(inputNumero.nextDouble());

                    System.out.println("digite a quantidade");
                    quantidade.add(inputNumero.nextInt());

                    /*
                     Adiciona os valores digitados pelo usuário às listas correspondentes.

                     Exemplo:

                     id = 0
                     nome[0] = "mouse"
                     preco[0] = 50.0
                     quantidade[0] = 3

                     Cada índice representa um produto.
                    */

                    System.out.println("produto cadastrado");

                    id++; // Adiciona 1 ID a cada produto cadastrado
                    // Exemplo: 5 produtos cadastrados = IDs 0, 1, 2, 3 e 4

                    break;

                case 2:
                    // Se a quantidade de id cadastrados for igual a 0, vai printar que não tem nenhum produto cadastrado
                    if (nome.size() == 0) {

                        System.out.println("nenhum produto cadastrado");
                        break;
                    }

                    System.out.println("qual o id do produto que deseja repor?");
                    int idRepor = inputNumero.nextInt();
                    //Aqui ele checa se o ID do produto é valido, se o idrepor for maior ou igual a zero e se idrepor for menor ao tanto de id's cadastrados não válida
                    if (idRepor >= 0 && idRepor < nome.size()) {
                        //Aqui ele pergunta a quantidade do item que o usuario vai querer repor, verificando o valor do input digitado pelo usuario
                        System.out.println("quantidade pra adicionar");
                        int repor = inputNumero.nextInt();
                        //aqui ele pega a lista "quantidade" e usa o metodo ".get(idrepor)" para verificar a quantidade de unidades ja tem daquele produto
                        int quantidadeAtual = quantidade.get(idRepor);
                        //Aqui soma a quantidade que ja tem de unidades e soma com a quantidade que o usuario quer adicionar
                        quantidade.set(idRepor, quantidadeAtual + repor);

                        System.out.println("produto reposto");

                    } else {

                        System.out.println("id invalido");
                    }

                    break;


                case 3:

                    // Se não tem nenhum produto cadastrado o código para,
                    // pois não existe produto para vender
                    if (nome.size() == 0) {

                        System.out.println("nenhum produto cadastrado");
                        break;
                    }

                    System.out.println("qual o id do produto?");
                    int idVenda = inputNumero.nextInt();

                    // Verifica se o ID informado existe
                    if (idVenda >= 0 && idVenda < nome.size()) {

                        System.out.println("quantidade vendida?");
                        int venda = inputNumero.nextInt();

                        // Obtém a quantidade atual do produto em estoque
                        int quantidadeAtual = quantidade.get(idVenda);

                        // Se a quantidade vendida for menor ou igual ao estoque disponível,
                        // a venda pode ser realizada
                        if (venda <= quantidadeAtual) {

                            // Atualiza a quantidade após a venda
                            quantidade.set(idVenda, quantidadeAtual - venda);

                            System.out.println("venda realizada");

                            // Se o estoque chegar a zero, remove o produto da lista
                            if (quantidade.get(idVenda) == 0) {

                                nome.remove(idVenda);
                                preco.remove(idVenda);
                                quantidade.remove(idVenda);

                                System.out.println("produto removido por falta de estoque");
                            }

                        } else {

                            // Tentativa de vender mais unidades do que existem em estoque
                            System.out.println("sem estoque");
                            break;
                        }

                    } else {

                        // Caso o ID informado não exista
                        System.out.println("id invalido");
                        break;
                    }

                    break;

                case 4:
                    //se o tanto de items for 0 vai printar que o estoque esta vazio
                    if (nome.size() == 0) {

                        System.out.println("estoque vazio");
                        break;
                    }

                    //Aqui ele consulta a quantidade de unidades
                    double valorTotal = 0;

                    for (int i = 0; i < nome.size(); i++) {

                        System.out.println("id: " + i);
                        System.out.println("nome: " + nome.get(i));
                        System.out.println("preço: " + preco.get(i));
                        System.out.println("quantidade: " + quantidade.get(i));

                        // aviso caso o estoque esteja baixo
                        if (quantidade.get(i) <= 5) {

                            System.out.println("AVISO: estoque baixo (" + quantidade.get(i) + " unidades restantes)");
                        }

                        //Aqui ele calcula o valor total do estoque
                        double totalProduto = preco.get(i) * quantidade.get(i);

                        valorTotal = valorTotal + totalProduto;

                        System.out.println("----------------");
                    }

                    System.out.println("valor total do estoque");
                    System.out.println(valorTotal);

                    break;


                case 5:
                    //Aqui ele vai confirmar se deseja remover tudo
                    System.out.println("deseja remover tudo?");
                    System.out.println("[1] sim");
                    System.out.println("[2] nao");

                    int remover = inputNumero.nextInt();

                    switch (remover) {

                        case 1: // Caso resposta 1, remove tudo e reinicia os IDs

                            nome.clear();
                            preco.clear();
                            quantidade.clear();

                            id = 0;

                            System.out.println("estoque apagado");

                            break;

                        case 2: // Não remove os produtos

                            System.out.println("cancelado");
                            break;

                        default: // Opção inválida

                            System.out.println("opção invalida");
                            break;
                    }

                    break;

                case 0: // Encerra o programa

                    System.out.println("programa encerrado");
                    break;

                default: // Opção inexistente no menu

                    System.out.println("opção invalida");
                    break;
            }

        } while (resposta != 0);

    }
}