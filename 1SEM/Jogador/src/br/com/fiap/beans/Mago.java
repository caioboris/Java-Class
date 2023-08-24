package br.com.fiap.beans;

public class Mago extends Jogador {
    
    private int mp;

    public Mago(String nome, int mp){
        super(nome);
    }

    public int getMp() {
        return mp;
    }

    @Override
    public void mover(int x, int y) {
        var atualX = getX();
        var atualY = getY();

        this.setX(atualX += x + 2);
        this.setY(atualY += y + 2);
        //magos e move 2 unidade mais rapido que guerreiro
    }

}
