package br.com.fiap.futebol.beans;

public class Zagueiro extends Jogador{
    
    private int desarmesFeitos;

    public Zagueiro(String nome, int camisa, double altura, int desarmesFeitos) {
        super(nome, camisa, altura);
        this.desarmesFeitos = desarmesFeitos;
    }

    @Override
    public String agir() {
        return "Zagueiro "+ getNome() + " está marcando! ";
    }
}
