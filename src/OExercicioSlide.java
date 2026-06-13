package Aula20;

import java.util.ArrayList;
import java.util.Scanner;

public class OExercicio {

    public static void main(String[] args) {

        // Scanner: permite ler dados digitados pelo usuário no console
        Scanner input = new Scanner(System.in);

        // ===== ESTRUTURAS DE DADOS =====
        // Cada cliente cadastrado terá um "índice" (posição) que é o mesmo
        // em todas as listas abaixo. Ou seja, a posição 0 de "nomeCliente"
        // corresponde à posição 0 de "codigoCliente", "vendasJaneiro", etc.

        ArrayList<Integer> codigoCliente = new ArrayList<>(); // código informado pelo usuário
        ArrayList<String> nomeCliente = new ArrayList<>();    // nome do cliente

        // Uma lista de vendas para cada mês do ano (12 listas paralelas)
        ArrayList<Double> vendasJaneiro = new ArrayList<>();
        ArrayList<Double> vendasFevereiro = new ArrayList<>();
        ArrayList<Double> vendasMarco = new ArrayList<>();
        ArrayList<Double> vendasAbril = new ArrayList<>();
        ArrayList<Double> vendasMaio = new ArrayList<>();
        ArrayList<Double> vendasJunho = new ArrayList<>();
        ArrayList<Double> vendasJulho = new ArrayList<>();
        ArrayList<Double> vendasAgosto = new ArrayList<>();
        ArrayList<Double> vendasSetembro = new ArrayList<>();
        ArrayList<Double> vendasOutubro = new ArrayList<>();
        ArrayList<Double> vendasNovembro = new ArrayList<>();
        ArrayList<Double> vendasDezembro = new ArrayList<>();

        int resposta;       // guarda a opção escolhida no menu
        int idCliente = 0;  // contador que serve como "id" sequencial do próximo cliente

        System.out.println("bem vindo ao sistema");

        // ===== LOOP PRINCIPAL DO PROGRAMA =====
        // O programa fica repetindo o menu até o usuário escolher a opção 5 (sair)
        do {

            // Exibe o menu de opções para o usuário
            System.out.println("[1] cadastrar cliente");
            System.out.println("[2] registrar vendas");
            System.out.println("[3] consultar cliente");
            System.out.println("[4] relatorio geral");
            System.out.println("[5] sair");

            resposta = input.nextInt();
            input.nextLine(); // limpa o "\n" deixado pelo nextInt()

            // O switch direciona o fluxo para o bloco correspondente à opção escolhida
            switch (resposta) {

                // ===== OPÇÃO 1: CADASTRAR CLIENTE =====
                case 1:

                    // Mostra qual será o id (posição na lista) do novo cliente
                    System.out.println("id do cliente");
                    System.out.println(idCliente);

                    // Lê o código do cliente (número digitado pelo usuário) e adiciona na lista
                    System.out.println("digite o codigo do cliente");
                    codigoCliente.add(input.nextInt());
                    input.nextLine();

                    // Lê o nome do cliente e adiciona na lista
                    System.out.println("digite o nome do cliente");
                    nomeCliente.add(input.nextLine());

                    // Para cada novo cliente, inicia as vendas de todos os 12 meses com 0.0
                    // Isso garante que todas as listas de meses tenham o mesmo tamanho
                    // que a lista de nomes (mantendo o "índice" alinhado)
                    vendasJaneiro.add(0.0);
                    vendasFevereiro.add(0.0);
                    vendasMarco.add(0.0);
                    vendasAbril.add(0.0);
                    vendasMaio.add(0.0);
                    vendasJunho.add(0.0);
                    vendasJulho.add(0.0);
                    vendasAgosto.add(0.0);
                    vendasSetembro.add(0.0);
                    vendasOutubro.add(0.0);
                    vendasNovembro.add(0.0);
                    vendasDezembro.add(0.0);

                    System.out.println("cliente cadastrado");

                    // Incrementa o contador para o próximo cliente ter o id seguinte
                    idCliente++;

                    break;

                // ===== OPÇÃO 2: REGISTRAR VENDAS =====
                case 2:

                    // Não permite registrar venda se não existir nenhum cliente
                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    // Pergunta de qual cliente (pelo id/posição na lista) será a venda
                    System.out.println("qual o id do cliente que deseja registrar a venda?");
                    int idVenda = input.nextInt();
                    input.nextLine();

                    // Verifica se o id informado é válido (existe na lista)
                    if (idVenda >= 0 && idVenda < nomeCliente.size()) {

                        // Pergunta o mês da venda (1 = Janeiro ... 12 = Dezembro)
                        System.out.println("digite o numero do mes (1 a 12)");
                        int mes = input.nextInt();
                        input.nextLine();

                        // Dados do produto vendido (usados apenas para o cálculo do total)
                        System.out.println("digite o nome do produto");
                        String produto = input.nextLine();

                        System.out.println("digite o valor por produto");
                        double valorProduto = input.nextDouble();
                        input.nextLine();

                        System.out.println("digite a quantidade de produtos");
                        int quantidade = input.nextInt();
                        input.nextLine();

                        // Calcula o valor total da venda (preço x quantidade)
                        double totalVenda = valorProduto * quantidade;

                        // Vetor que reúne as 12 listas de vendas, na ordem dos meses.
                        // Assim "meses[0]" = vendasJaneiro, "meses[1]" = vendasFevereiro, etc.
                        // Isso evita escrever 12 "if" para descobrir qual lista usar.
                        ArrayList<Double>[] meses = new ArrayList[]{
                                vendasJaneiro, vendasFevereiro, vendasMarco, vendasAbril,
                                vendasMaio, vendasJunho, vendasJulho, vendasAgosto,
                                vendasSetembro, vendasOutubro, vendasNovembro, vendasDezembro
                        };

                        // Valida se o mês existe (1 a 12)
                        if (mes >= 1 && mes <= 12) {
                            // Substitui o valor de vendas daquele mês para o cliente escolhido
                            // (mes - 1 porque o vetor "meses" começa em 0, mas o usuário digita 1 a 12)
                            meses[mes - 1].set(idVenda, totalVenda);
                            System.out.println("venda registrada");
                        } else {
                            System.out.println("mes invalido");
                        }

                    } else {
                        System.out.println("id invalido");
                    }

                    break;

                // ===== OPÇÃO 3: CONSULTAR CLIENTE (RELATÓRIO INDIVIDUAL) =====
                case 3:

                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    // Pergunta o id do cliente que será consultado
                    System.out.println("qual o id do cliente para consultar?");
                    int idConsulta = input.nextInt();
                    input.nextLine();

                    if (idConsulta >= 0 && idConsulta < nomeCliente.size()) {

                        // Mostra os dados básicos do cliente
                        System.out.println("nome do cliente: " + nomeCliente.get(idConsulta));
                        System.out.println("codigo do cliente: " + codigoCliente.get(idConsulta));

                        // Pega o valor de venda do cliente em cada um dos 12 meses
                        double mes1 = vendasJaneiro.get(idConsulta);
                        double mes2 = vendasFevereiro.get(idConsulta);
                        double mes3 = vendasMarco.get(idConsulta);
                        double mes4 = vendasAbril.get(idConsulta);
                        double mes5 = vendasMaio.get(idConsulta);
                        double mes6 = vendasJunho.get(idConsulta);
                        double mes7 = vendasJulho.get(idConsulta);
                        double mes8 = vendasAgosto.get(idConsulta);
                        double mes9 = vendasSetembro.get(idConsulta);
                        double mes10 = vendasOutubro.get(idConsulta);
                        double mes11 = vendasNovembro.get(idConsulta);
                        double mes12 = vendasDezembro.get(idConsulta);

                        // Exibe a venda de cada mês individualmente
                        System.out.println("vendas dos 12 meses:");
                        System.out.println("mes 1: " + mes1);
                        System.out.println("mes 2: " + mes2);
                        System.out.println("mes 3: " + mes3);
                        System.out.println("mes 4: " + mes4);
                        System.out.println("mes 5: " + mes5);
                        System.out.println("mes 6: " + mes6);
                        System.out.println("mes 7: " + mes7);
                        System.out.println("mes 8: " + mes8);
                        System.out.println("mes 9: " + mes9);
                        System.out.println("mes 10: " + mes10);
                        System.out.println("mes 11: " + mes11);
                        System.out.println("mes 12: " + mes12);

                        // Soma o total vendido no ano e calcula a média mensal
                        double totalCliente = mes1 + mes2 + mes3 + mes4 + mes5 + mes6 + mes7 + mes8 + mes9 + mes10
                                + mes11 + mes12;
                        double mediaCliente = totalCliente / 12.0;

                        System.out.println("total vendido no ano");
                        System.out.println(totalCliente);
                        System.out.println("media mensal");
                        System.out.println(mediaCliente);

                        // Monta dois vetores auxiliares: um com os valores das vendas
                        // e outro com os nomes dos meses, na mesma ordem
                        double[] valoresMeses = {mes1, mes2, mes3, mes4, mes5, mes6, mes7, mes8, mes9, mes10, mes11,
                                mes12};
                        String[] nomesMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

                        // Percorre os 12 meses procurando o de MAIOR venda
                        double maiorVenda = mes1;
                        String mesMaior = "Janeiro";

                        for (int m = 0; m < 12; m++) {
                            if (valoresMeses[m] > maiorVenda) {
                                maiorVenda = valoresMeses[m];
                                mesMaior = nomesMeses[m];
                            }
                        }

                        // Percorre os 12 meses procurando o de MENOR venda
                        double menorVenda = mes1;
                        String mesMenor = "Janeiro";

                        for (int m = 0; m < 12; m++) {
                            if (valoresMeses[m] < menorVenda) {
                                menorVenda = valoresMeses[m];
                                mesMenor = nomesMeses[m];
                            }
                        }

                        // Exibe qual mês teve a maior e o menor valor de venda
                        System.out.println("mes de maior venda: " + mesMaior + " (" + maiorVenda + ")");
                        System.out.println("mes de menor venda: " + mesMenor + " (" + menorVenda + ")");

                    } else {
                        System.out.println("id invalido");
                    }

                    break;

                // ===== OPÇÃO 4: RELATÓRIO GERAL (TODOS OS CLIENTES) =====
                case 4:

                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    // Variáveis que vão acumular os resultados de TODOS os clientes
                    double totalGeralAno = 0;          // soma de todas as vendas de todos os clientes
                    double maiorVendaGeral = -1.0;     // maior total anual entre os clientes
                    double menorVendaGeral = 99999999.0; // menor total anual entre os clientes
                    String clienteMaior = "Nenhum";    // nome do cliente com maior venda
                    String clienteMenor = "Nenhum";    // nome do cliente com menor venda

                    // Percorre TODOS os clientes cadastrados (do índice 0 até o último)
                    for (int i = 0; i < nomeCliente.size(); i++) {

                        // Pega as vendas dos 12 meses do cliente atual (índice i)
                        double mes1 = vendasJaneiro.get(i);
                        double mes2 = vendasFevereiro.get(i);
                        double mes3 = vendasMarco.get(i);
                        double mes4 = vendasAbril.get(i);
                        double mes5 = vendasMaio.get(i);
                        double mes6 = vendasJunho.get(i);
                        double mes7 = vendasJulho.get(i);
                        double mes8 = vendasAgosto.get(i);
                        double mes9 = vendasSetembro.get(i);
                        double mes10 = vendasOutubro.get(i);
                        double mes11 = vendasNovembro.get(i);
                        double mes12 = vendasDezembro.get(i);

                        // Soma o total anual deste cliente
                        double totalDoCliente = mes1 + mes2 + mes3 + mes4 + mes5 + mes6 + mes7 + mes8 + mes9 + mes10 +
                                mes11 + mes12;

                        // Acumula no total geral (soma de todos os clientes)
                        totalGeralAno = totalGeralAno + totalDoCliente;

                        // Verifica se este cliente é o que mais vendeu até agora
                        if (totalDoCliente > maiorVendaGeral) {
                            maiorVendaGeral = totalDoCliente;
                            clienteMaior = nomeCliente.get(i);
                        }

                        // Verifica se este cliente é o que menos vendeu até agora
                        if (totalDoCliente < menorVendaGeral) {
                            menorVendaGeral = totalDoCliente;
                            clienteMenor = nomeCliente.get(i);
                        }
                    }

                    // Calcula a média mensal considerando o total de TODOS os clientes
                    double mediaMensalGeral = totalGeralAno / 12.0;

                    // Exibe o relatório final consolidado
                    System.out.println("total vendido no ano");
                    System.out.println(totalGeralAno);
                    System.out.println("media mensal de vendas");
                    System.out.println(mediaMensalGeral);
                    System.out.println("maior venda registrada: " + maiorVendaGeral + " (cliente: " +
                            clienteMaior + ")");
                    System.out.println("menor venda registrada: " + menorVendaGeral + " (cliente: " +
                            clienteMenor + ")");

                    break;

                // ===== OPÇÃO 5: SAIR =====
                case 5:
                    System.out.println("programa encerrado");
                    break;

                // ===== QUALQUER OUTRA OPÇÃO =====
                default:
                    System.out.println("opção invalida");
                    break;
            }

        } while (resposta != 5); // repete o menu até a opção escolhida ser 5

    }
}