package br.com.fiap.banco.Exceptions;

public class DepositoNegativoException extends RuntimeException{
    
    public DepositoNegativoException(String message) {
        super(message);
    }
}
