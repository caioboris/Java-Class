package br.com.fiap.futebol.beans;

import java.util.ArrayList;
import java.util.List;

public class Time {
    
    private String nome;
    private List<Jogador> jogadores = new ArrayList<>();

    public Time(String nome) {
        this.nome = nome;
    }

    public void jogar(){
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.agir()); 
        }
    }

public void contratar(Jogador jogador){
    jogadores.add(jogador);
}
}
