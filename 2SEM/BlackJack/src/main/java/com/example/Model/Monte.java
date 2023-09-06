package com.example.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Naipe;

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
                
                if(numero > 10) numero = 10;

                cartas.add(new Carta(numero, naipe));
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
