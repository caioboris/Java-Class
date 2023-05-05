package br.com.fiap.pacman.beans;

public class Bomb extends Item{

    private boolean explodiu;

    public Bomb(){
        super();
    }

    public Bomb(int posicaoX, int posicaoY){
        super(posicaoX, posicaoY, true);
        this.explodiu = false;
    }

    public boolean isExplodiu() {
        return explodiu;
    }

    public void setExplodiu(boolean explodiu) {
        this.explodiu = explodiu;
    }
}
