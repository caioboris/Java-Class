package com.example.model;

public class Computador extends Jogador {

    @Override
    public boolean parou() {
       
        var pontos = getPontos();
        if(pontos > 16)
            return true;

        return false;
    }    
   
}
