package br.com.fiap.futebol.beans;

public class Goleiro extends Jogador{
    
    private int defesasRealizadas;

    public Goleiro(String nome, int camisa, double altura, int defesasRealizadas) {
        super(nome, camisa, altura);
        this.defesasRealizadas = defesasRealizadas;
    }

    @Override
    public String agir() {
        return "Goleiro "+ getNome()+" está defendendo";
    }
}
