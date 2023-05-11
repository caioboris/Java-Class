package br.com.fiap.beans;

import br.com.fiap.Interfaces.IElementoVisual;

public abstract class Elemento implements IElementoVisual{
    
    private int x;
    private int y;

    public void mover(int x, int y) {
        var atualX = getX();
        var atualY = getY();

        this.setX(atualX += x);
        this.setY(atualY += y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
