package br.com.fiap.futebol.beans;

public class Jogador {

    private String nome;
    private int camisa;
    private double altura;

    public Jogador(String nome, int camisa, double altura){
        this.nome = nome;
        this.camisa = camisa;
        this.altura = altura;
    }

    public String agir(){
        return "Jogador " +getNome()+" está jogando!";
    }

    public String getNome() {
        return nome;
    }
}
