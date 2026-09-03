import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.util.Scanner;

public class Conta {
    Double saldo;


    public void depositar(Double valor) {
        saldo += valor;
    }

    public void sacar(Double valorSaque) {
        if( valorSaque > saldo) {
            System.out.println("Saldo insuficiente");
        }
        else if (valorSaque == 0) {
            System.out.println("Valor invalido");
        }
        else{
            System.out.println("Saque efetuado");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
