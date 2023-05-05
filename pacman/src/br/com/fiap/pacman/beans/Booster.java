package br.com.fiap.pacman.beans;

public class Booster extends Item{

    private int duracao;

    public Booster(){
        super();
    }

    public Booster(int posicaoX, int posicaoY, int duracao){
        super(posicaoX, posicaoY, false);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
