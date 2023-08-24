package br.com.fiap.banco.Exceptions;

public class TransferenciaInvalidaException extends RuntimeException{
    
    public TransferenciaInvalidaException(String message) {
        super(message);
    }
}
