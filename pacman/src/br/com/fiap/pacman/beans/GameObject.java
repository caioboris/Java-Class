package br.com.fiap.pacman.beans;

public class GameObject {

    private int posicaoX;
    private int posicaoY;
    private int screenSize = 200;

    public GameObject(){}

    public GameObject(int posicaoX, int posicaoY){
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setPosicaoX(int posicaoX) {
        if(posicaoX < getScreenSize() && posicaoX > 0)
            this.posicaoX = posicaoX;
    }

    public void setScreenSize(int tamanhoTela) {
        this.screenSize = tamanhoTela;
    }

    public void setPosicaoY(int posicaoY) {
        if(posicaoX < getScreenSize() && posicaoX > 0)
            this.posicaoY = posicaoY;
    }
}
