import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.util.Scanner;

public class Conta {
    Double saldo;


    public void depositar(Double saldo) {
        saldo += saldo;
    }

    public void sacar(Double valorSaque) {

        if (valorSaque > saldo || valorSaque <= 0) {
            System.out.println("Saldo insuficiente ou valor invalido para saque");
            return;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
