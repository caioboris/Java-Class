package br.com.fiap.banco;

import br.com.fiap.banco.Exceptions.DepositoNegativoException;
import br.com.fiap.banco.Exceptions.SaqueMaiorQueSaldoException;
import br.com.fiap.banco.Exceptions.TransferenciaInvalidaException;

public class Conta {
    
    private String numero;
    private double saldo;
    private double taxa;

    public Conta(String numero) {
        this.numero = numero;
    }
    
    
    public void depositar(double valor) throws DepositoNegativoException{
        if(valor < 0)
            throw new DepositoNegativoException("Não é possível depositar valores negativos "); 
        saldo += valor;
    }
    
    public void sacar (double valor) throws SaqueMaiorQueSaldoException{
        if(valor > saldo)
            throw new SaqueMaiorQueSaldoException("Não é possível realizar o saque de: "+valor+ " pois o valor é maior que o saldo disponível: "+ saldo);
        saldo -= valor;
    }

    public void transferencia(Conta conta, double valor) throws TransferenciaInvalidaException{
        if(conta.getNumero() == numero)
            throw new TransferenciaInvalidaException("Não é possivel realizar uma transferência para sua própria conta.");
        if(valor < 0)
            throw new TransferenciaInvalidaException("Não é possível realizar uma transferência de valor negativo.");
        if(valor > saldo)
            throw new TransferenciaInvalidaException("Não é possivel realizar essa transferência pois o valor "+ valor+" é maior que o saldo disponível: "+saldo);

        conta.setSaldo(conta.getSaldo() + valor);        
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getTaxa() {
        return taxa;
    }
}
