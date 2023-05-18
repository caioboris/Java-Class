package br.com.fiap.banco;

import br.com.fiap.banco.Exceptions.ContaPoupancaException;


public class ContaPoupanca extends Conta {
    
    private double taxa;

    public ContaPoupanca(String numero) {
        super(numero);
    }

    @Override
    public void sacar(double valor) throws ContaPoupancaException {
        throw new ContaPoupancaException("Não é possível realizar saque em uma conta poupança."); 
    }

    public double getTaxa() {
        return taxa;
    }



}
