package com.example.model;

public class Carta {

    private int numero;
    private Naipe naipe;
    private String figura;

    public Carta(int numero,Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public String imagePath(){
        var nomeCarta = String.valueOf(numero);

        if(figura!= null){
            nomeCarta = figura;
        }

       return "classic-cards/"+ nomeCarta + naipe +".png" ;
    }

    public int getNumero() {
        return numero;
    }

    public Naipe getNaipe() {
        return naipe;
    }
    
    public void setFigura(String figura){
        this.figura = figura;
    }
        
}
