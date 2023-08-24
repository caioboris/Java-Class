package br.com.fiap.futebol;

import br.com.fiap.futebol.beans.Goleiro;
import br.com.fiap.futebol.beans.Time;

public class App {
    public static void main(String[] args) throws Exception {
        
        Time brasil = new Time("Brasil");
        Goleiro tafarel = new Goleiro("Tafarel", 1, 1.90, 100);
        
        brasil.contratar(tafarel);

        brasil.jogar();
    }
}
