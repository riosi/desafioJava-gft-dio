package br.com.riosi.models;

public class ContaCorrente extends ContaModel {

    public ContaCorrente(int agencia, int numeroConta) {
        super(agencia, numeroConta);
    }

    @Override
    public void saca(double valor) throws SaldoInsuficienteException {
        double valorASacar = valor + 0.2;
        super.saca(valorASacar);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public String toString() {
        return "Conta Corrente: " + super.toString();
    }

}
