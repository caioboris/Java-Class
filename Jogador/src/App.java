import br.com.fiap.Jogador;

public class App {
    public static void main(String[] args) throws Exception {
        
        Jogador player1 = new Jogador("Caio");
        Jogador player2 = new Jogador("Boris");

        player1.ganharExperiencia(5);
        player2.ganharExperiencia(5);

        player1.receberCura(10);
        player2.receberCura(10);

        player1.receberAntídoto();

        player2.atacar(player1);

        
    }
}
