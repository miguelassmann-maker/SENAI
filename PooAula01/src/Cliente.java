public class Cliente {
    String nome;
    String cpf;
    Conta conta;

    public Cliente(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
