
import br.com.riosi.models.ContaCorrente;
import br.com.riosi.models.ContaModel;
import br.com.riosi.models.ContaPoupanca;
import br.com.riosi.models.SaldoInsuficienteException;

public class App {
    public static void main(String[] args) {

        ContaModel contaCorrente = new ContaCorrente(111, 233);
        ContaModel contaPoupanca = new ContaPoupanca(111, 2331);

        contaCorrente.deposita(300.0);

        try {
            contaCorrente.saca(310);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Ex: " + ex.getMessage());
        }

        System.out.println("Saldo após depósito: " + contaCorrente.getSaldo());

        contaCorrente.deposita(250.0);
        System.out.println("Saldo após depósito: " + contaCorrente.getSaldo());

        try {
            contaCorrente.saca(100.0);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Ex: " + ex.getMessage());
        }

        System.out.println("Saldo atual: " + contaCorrente.getSaldo());

        try {
            contaCorrente.transfere(100.0, contaPoupanca);
        } catch (SaldoInsuficienteException ex) {
            System.out.println("Ex: " + ex.getMessage());
        }

        System.out.println("Saldo Conta Poupança após transferência: " + contaPoupanca.getSaldo());
        System.out.println("Saldo Conta Corrente após transferência: " + contaCorrente.getSaldo());
    }
}
