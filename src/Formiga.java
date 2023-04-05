public class Formiga {

    public int velocidade;
    public Coordenada posicao;
    public boolean carregaAlimento;
    public int estoqueFeromonios;
    public Coordenada casa;


    public Formiga(Coordenada posicao){
        this.posicao = posicao;
    }

    public void andar(){

    }
    public void buscarComida(){

    }

    public void encontrouComida(){

    }

    public void pegarComida(){
        this.carregaAlimento = true;
    }

    public void largarComida(){
        this.carregaAlimento = false;
    }


    public void agir(){

        if(this.carregaAlimento){
            this.posicao = this.casa;
        }
        else{
            this.buscarComida();
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
