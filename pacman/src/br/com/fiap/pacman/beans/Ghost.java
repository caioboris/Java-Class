package br.com.fiap.pacman.beans;
public class Ghost extends GameObject{

    private int direcao;

    public Ghost(){
        super();
    }

    public Ghost(int posicaoX, int posicaoY, int direcao){
        super(posicaoX, posicaoY);
        this.direcao = direcao;
    }

    public void mover(){
        int aux = (int)(Math.random()*4);

        switch (aux){
            case 0:
                setPosicaoY(getPosicaoY() - 10);
                break;
            case 1:
                setPosicaoX(getPosicaoX() + 10);
                break;
            case 2:
                setPosicaoY(getPosicaoY() + 10);
                break;
            case 3:
                setPosicaoX(getPosicaoX() - 10);
                break;
        }
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        if(direcao == 0 || direcao == 90 || direcao == 180 || direcao == 270)
            this.direcao = direcao;
    }
}
