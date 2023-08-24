package br.com.fiap.futebol.beans;

public class Atacante extends Jogador {
    
    private int golsMarcados;

    public Atacante(String nome, int camisa, double altura, int golsMarcados) {
        super(nome, camisa, altura);
        this.golsMarcados = golsMarcados;
    }

    @Override
    public String agir() {
        return "Atacante " + getNome() + " está chutando!";
    }
}
