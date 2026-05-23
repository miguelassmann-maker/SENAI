package Aula19;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCRM {
    public static void main(String[] args) {
        int id =0;
        Scanner input = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> cpf = new ArrayList<>();
        ArrayList<Integer> idade = new ArrayList<>();
        ArrayList<Double> salario = new ArrayList<Double>();
int resposta;
        System.out.println("Bem vindo ao sistema");
        do{
            System.out.println("[1] para cadastrar um novo cliente");
            System.out.println("[2] para consultar um cliente");
            System.out.println("[9] Para verificar a versão do sistema");
            resposta = input.nextInt();
switch (resposta){
    case 1:
        System.out.println("O Id do cadastro deste cliente é");
        System.out.println(id);
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
        System.out.println("Para consultar digite o id do " + "cadastro desejado");
        int consulta = input.nextInt();
        System.out.printf("Nome do cliente: %s",nomes.get(consulta));
        System.out.printf("Cpf do cliente: %s",cpf.get(consulta));
        System.out.printf("Idade do cliente: %d",idade.get(consulta));
        System.out.printf("Salario do cliente: %.2f",salario.get(consulta));

case 3:
    /**Crie uma função de solicitação de emprestimo a do emprestimo não
     * pode passar a 10% do salario do cliente pode optar por parcelar em 24x, 36x, 48x
     * obs: o juros por mes deve ser de 1.8 por parcela.
     * **/
        break;
    case 9:
        break;
    default:
        break;
}
        }while (resposta !=0);
    }
}
