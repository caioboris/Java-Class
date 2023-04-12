import java.util.Random;

public class Coordenada {

    public int x;
    public int y;

    public boolean temComida;

    public Coordenada(int x, int y){
        this.x = x;
        this.y = y;
        this.temComida = new Random().nextBoolean();
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
