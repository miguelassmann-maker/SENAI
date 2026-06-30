package Aula20;

import java.util.ArrayList;
import java.util.Scanner;

public class OExercicio {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> codigoCliente = new ArrayList<>();
        ArrayList<String> nomeCliente = new ArrayList<>();

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

        int resposta;
        int idCliente = 0;

        System.out.println("bem vindo ao sistema");

        do {

            System.out.println("[1] cadastrar cliente");
            System.out.println("[2] registrar vendas");
            System.out.println("[3] consultar cliente");
            System.out.println("[4] relatorio geral");
            System.out.println("[5] sair");

            resposta = input.nextInt();
            input.nextLine();

            switch (resposta) {

                case 1:

                    System.out.println("id do cliente");
                    System.out.println(idCliente);

                    System.out.println("digite o codigo do cliente");
                    codigoCliente.add(input.nextInt());
                    input.nextLine();

                    System.out.println("digite o nome do cliente");
                    nomeCliente.add(input.nextLine());

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

                    idCliente++;

                    break;

                case 2:

                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    System.out.println("qual o id do cliente que deseja registrar a venda?");
                    int idVenda = input.nextInt();
                    input.nextLine();

                    if (idVenda >= 0 && idVenda < nomeCliente.size()) {

                        System.out.println("digite o numero do mes (1 a 12)");
                        int mes = input.nextInt();
                        input.nextLine();

                        System.out.println("digite o nome do produto");
                        String produto = input.nextLine();

                        System.out.println("digite o valor por produto");
                        double valorProduto = input.nextDouble();
                        input.nextLine();

                        System.out.println("digite a quantidade de produtos");
                        int quantidade = input.nextInt();
                        input.nextLine();

                        double totalVenda = valorProduto * quantidade;

                        ArrayList<Double>[] meses = new ArrayList[]{
                                vendasJaneiro, vendasFevereiro, vendasMarco, vendasAbril,
                                vendasMaio, vendasJunho, vendasJulho, vendasAgosto,
                                vendasSetembro, vendasOutubro, vendasNovembro, vendasDezembro
                        };

                        if (mes >= 1 && mes <= 12) {
                            meses[mes - 1].set(idVenda, totalVenda);
                            System.out.println("venda registrada");
                        } else {
                            System.out.println("mes invalido");
                        }

                    } else {
                        System.out.println("id invalido");
                    }

                    break;

                case 3:

                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    System.out.println("qual o id do cliente para consultar?");
                    int idConsulta = input.nextInt();
                    input.nextLine();

                    if (idConsulta >= 0 && idConsulta < nomeCliente.size()) {

                        System.out.println("nome do cliente: " + nomeCliente.get(idConsulta));
                        System.out.println("codigo do cliente: " + codigoCliente.get(idConsulta));

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

                        double totalCliente = mes1 + mes2 + mes3 + mes4 + mes5 + mes6 + mes7 + mes8 + mes9 + mes10
                                + mes11 + mes12;
                        double mediaCliente = totalCliente / 12.0;

                        System.out.println("total vendido no ano");
                        System.out.println(totalCliente);
                        System.out.println("media mensal");
                        System.out.println(mediaCliente);

                        double[] valoresMeses = {mes1, mes2, mes3, mes4, mes5, mes6, mes7, mes8, mes9, mes10, mes11,
                                mes12};
                        String[] nomesMeses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

                        double maiorVenda = mes1;
                        String mesMaior = "Janeiro";

                        for (int m = 0; m < 12; m++) {
                            if (valoresMeses[m] > maiorVenda) {
                                maiorVenda = valoresMeses[m];
                                mesMaior = nomesMeses[m];
                            }
                        }

                        double menorVenda = mes1;
                        String mesMenor = "Janeiro";

                        for (int m = 0; m < 12; m++) {
                            if (valoresMeses[m] < menorVenda) {
                                menorVenda = valoresMeses[m];
                                mesMenor = nomesMeses[m];
                            }
                        }

                        System.out.println("mes de maior venda: " + mesMaior + " (" + maiorVenda + ")");
                        System.out.println("mes de menor venda: " + mesMenor + " (" + menorVenda + ")");

                    } else {
                        System.out.println("id invalido");
                    }

                    break;

                case 4:

                    if (nomeCliente.size() == 0) {
                        System.out.println("nenhum cliente cadastrado");
                        break;
                    }

                    double totalGeralAno = 0;
                    double maiorVendaGeral = -1.0;
                    double menorVendaGeral = 99999999.0;
                    String clienteMaior = "Nenhum";
                    String clienteMenor = "Nenhum";

                    for (int i = 0; i < nomeCliente.size(); i++) {

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

                        double totalDoCliente = mes1 + mes2 + mes3 + mes4 + mes5 + mes6 + mes7 + mes8 + mes9 + mes10 +
                                mes11 + mes12;
                        totalGeralAno = totalGeralAno + totalDoCliente;

                        if (totalDoCliente > maiorVendaGeral) {
                            maiorVendaGeral = totalDoCliente;
                            clienteMaior = nomeCliente.get(i);
                        }

                        if (totalDoCliente < menorVendaGeral) {
                            menorVendaGeral = totalDoCliente;
                            clienteMenor = nomeCliente.get(i);
                        }
                    }

                    double mediaMensalGeral = totalGeralAno / 12.0;

                    System.out.println("total vendido no ano");
                    System.out.println(totalGeralAno);
                    System.out.println("media mensal de vendas");
                    System.out.println(mediaMensalGeral);
                    System.out.println("maior venda registrada: " + maiorVendaGeral + " (cliente: " +
                            clienteMaior + ")");
                    System.out.println("menor venda registrada: " + menorVendaGeral + " (cliente: " +
                            clienteMenor + ")");

                    break;

                case 5:
                    System.out.println("programa encerrado");
                    break;

                default:
                    System.out.println("opção invalida");
                    break;
            }

        } while (resposta != 5);

    }
}