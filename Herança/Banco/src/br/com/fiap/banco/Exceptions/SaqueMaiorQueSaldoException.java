package br.com.fiap.banco.Exceptions;

public class SaqueMaiorQueSaldoException extends RuntimeException{
    
    public SaqueMaiorQueSaldoException(String message) {
        super(message);
    }
}
