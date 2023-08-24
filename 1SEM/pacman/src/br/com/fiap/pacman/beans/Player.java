package br.com.fiap.pacman.beans;

import br.com.fiap.pacman.Game;

public class Player extends GameObject {

    private int direcao;
    private int life;
    private boolean invencivel;

    public Player(){
        super();
    }

    public Player(int posicaoY, int posicaoX, int direcao){
        super(posicaoY, posicaoX);
        this.direcao = direcao;
        this.life = 3;
        this.invencivel = false;
    }

    public void mover(){

        if(direcao == 0 && (getScreenSize() < getPosicaoY() - 10))
            setPosicaoY(getPosicaoY()-10);
        else if(direcao == 90 && (getScreenSize() < getPosicaoX() + 10))
            setPosicaoX(getPosicaoX()+10);
        else if(direcao == 180 && (getScreenSize() < getPosicaoY() + 10))
            setPosicaoY(getPosicaoY()+10);
        else if(direcao == 270 && (getScreenSize() < getPosicaoX() - 10))
            setPosicaoY(getPosicaoX()-10);

    }


    public boolean colide(GameObject object){
        return getPosicaoX() == object.getPosicaoX() && getPosicaoY() == object.getPosicaoY();
    }

    public void perdeVida(){
        if(!isInvencivel()) 
            setLife(getLife() - 1);
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        if(direcao == 0 || direcao == 90 || direcao == 180 || direcao == 270)
            this.direcao = direcao;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int qtdVidas) {
        this.life = qtdVidas;
    }

    public boolean isInvencivel() {
        return invencivel;
    }

    public void setInvencivel(boolean invencivel) {
        this.invencivel = invencivel;
    }
}
