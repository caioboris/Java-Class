import java.util.Random;

public class Formiga {

    public int velocidade;
    public Coordenada posicao;
    public boolean carregaAlimento;
    public int estoqueFeromonios;
    public Coordenada casa;


    public Formiga(int posicaoY, int posicaoX){
        this.posicao = new Coordenada(posicaoY, posicaoX);
        this.casa = new Coordenada(100,100);
    }

    public void andar(int passos){
        if(passos % 2 == 0)
            this.posicao.setX(this.posicao.getX() + passos);
        else
            this.posicao.setY(this.posicao.getY() + passos);
    }

    public void buscarComida(int passos){
        if(passos % 2 == 0) {
            int x = this.posicao.getX() + passos;
            int y = this.posicao.getY();
            this.posicao = new Coordenada(x, y);
        }
        else{
            int x = this.posicao.getX();
            int y = this.posicao.getY() + passos;
            this.posicao = new Coordenada(x, y);
        }
        verificaComida(this.posicao);
    }

    public void verificaComida(Coordenada posicao){

        if(posicao.temComida){
            pegarComida();
            System.out.println("Achei comida!");
        }

    }

    public void pegarComida(){
        this.carregaAlimento = true;
        System.out.println("que comida pesada");
    }

    public void largarComida(){
        this.carregaAlimento = false;
        System.out.println("tchau comida");
    }

    public void estaEmCasa(){
        if(this.posicao.getX() == this.casa.getX() && this.posicao.getY() == this.casa.getY() ){
            largarComida();
            System.out.println("Hmm casinha linda");
        }
    }

    public void agir(int passos){
        if(this.carregaAlimento){
            this.posicao = this.casa;
            System.out.println("Indo pra casinha!");
        }
        else{
            this.buscarComida(passos);
            System.out.println("Bora procurar comida!");
        }
    }




    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public boolean isCarregaAlimento() {
        return carregaAlimento;
    }

    public void setCarregaAlimento(boolean carregaAlimento) {
        this.carregaAlimento = carregaAlimento;
    }

    public int getEstoqueFeromonios() {
        return estoqueFeromonios;
    }

    public void setEstoqueFeromonios(int estoqueFeromonios) {
        this.estoqueFeromonios = estoqueFeromonios;
    }


}
