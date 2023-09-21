package com.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monte {
    
    private List<Carta> cartas= new ArrayList<>();

    public Monte() {    

        for(int i = 1; i <= 13; i++){
            
            for(int j = 0; j <= 3; j++){
                
               var naipe = Naipe.Clubs;
               var numero = i;

                switch(j){
                    case 0: 
                        naipe = Naipe.Diamonds;
                        break;
                    case 1: 
                        naipe = Naipe.Clubs;
                        break;
                    case 2: 
                        naipe = Naipe.Hearts;
                        break;
                    case 3: 
                        naipe = Naipe.Spades;
                }
                
                if(numero == 11){
                    var carta = new Carta(10,naipe);
                    carta.setFigura("Jack");
                    cartas.add(carta);
                }
                else if(numero == 12){
                    var carta = new Carta(10,naipe);
                    carta.setFigura("Queen");
                    cartas.add(carta);
                }
                else if(numero == 13){
                    var carta = new Carta(10,naipe);
                    carta.setFigura("King");
                    cartas.add(carta);
                }
                else if(numero == 1){
                    var carta = new Carta(1,naipe);
                    carta.setFigura("Ace");
                    cartas.add(carta);
                }else{

                    cartas.add(new Carta(numero, naipe));
                }

            }            
        }

    }

    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    public Carta virar(){
        return cartas.remove(0);
    }




}
