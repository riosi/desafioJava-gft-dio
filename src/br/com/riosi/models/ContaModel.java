package br.com.riosi.models;

public abstract class ContaModel {

    protected double saldo;
    private int agencia;
    private int numeroConta;
    private Cliente titular;

    public ContaModel(int agencia, int numeroConta) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    public abstract void deposita(double valor);

    public void saca(double valor) throws SaldoInsuficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo disponível: " + this.saldo + ", Valor inserido: " + valor);
        }
        this.saldo -= valor;
    }

    public void transfere(double valor, ContaModel destino) throws SaldoInsuficienteException {
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        if (numeroConta <= 0) {
            System.out.println("Não pode ser um valor menor ou igual a 0.");
            return;
        }

        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            System.out.println("Não pode ser um valor menor ou igual a 0.");
            return;
        }

        this.agencia = agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    @Override
    public boolean equals(Object ref) {
        ContaModel outra = (ContaModel) ref;
        if (this.agencia != outra.agencia) {
            return false;
        }

        if (this.numeroConta != outra.numeroConta) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {

        return "Agência: " + this.agencia + " Conta: " + this.numeroConta;
    }

}
