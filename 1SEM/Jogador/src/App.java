import br.com.fiap.beans.BolaDeFogo;
import br.com.fiap.beans.Dragao;
import br.com.fiap.beans.Fase;
import br.com.fiap.beans.Guerreiro;
import br.com.fiap.beans.Jogador;
import br.com.fiap.beans.Mago;

public class App {
    public static void main(String[] args) throws Exception {

        Fase fase1 = new Fase();
        Jogador player1 = new Mago("Caio", 10);
        Jogador player2 = new Guerreiro("Boris");
        BolaDeFogo bolaDeFogo = new BolaDeFogo();
        Dragao dg = new Dragao();

        fase1.carregar(player1);
        fase1.carregar(player2);
        fase1.carregar(bolaDeFogo);
        fase1.carregar(dg);

        player1.mover(0, 3);
        player2.mover(1, 0);
        bolaDeFogo.mover(1, 2);
        dg.mover(5, 0);
        
        


        // player1.ganharExperiencia(5);
        // player2.ganharExperiencia(5);

        // player1.receberCura(10);
        // player2.receberCura(10);

        // player1.receberAntídoto();

        // player2.atacar(player1);



        
    }
}
