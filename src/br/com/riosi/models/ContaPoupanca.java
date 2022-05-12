package br.com.riosi.models;

public class ContaPoupanca extends ContaModel {
    public ContaPoupanca(int agencia, int numeroConta) {
        super(agencia, numeroConta);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }

    @Override
    public String toString() {
        return "Conta Poupança: " + super.toString();
    }

}
