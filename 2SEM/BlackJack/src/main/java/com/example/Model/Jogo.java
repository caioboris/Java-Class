package com.example.model;

public class Jogo {
    
    static int id;
    private Monte monte = new Monte();
    private Jogador jogador = new Jogador();
    private Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
        id++;
    }

    public Carta distribuiCartaParaJogador(Jogador jogador){
        
        if(jogador.parou()) return null;
        
        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou(){
        if((jogador.parou() && computador.parou()) || (jogador.getPontos() > 21 || computador.getPontos() > 21) ) return true;

        return false;
    }

    public String resultado(){
        
        var texto = "Empate";
    
        if(acabou()){

            if(jogador.getPontos() > 21){
                texto = "Você perdeu";
            }
    
            if(computador.getPontos() > 21){
                texto = "Você ganhou";
            }
        }

        return texto;
    }

    public Computador getComputador(){
        return computador;
    }

    public Jogador getJogador(){
        return jogador;
    }

    public int getId(){
        return id;
    }


}
