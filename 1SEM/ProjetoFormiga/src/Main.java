import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Formiga mariazinha = new Formiga(100, 100);

        int rNumber = new Random().nextInt(100);

       mariazinha.agir(rNumber);

        System.out.println(mariazinha.posicao.getX());



    }


}
