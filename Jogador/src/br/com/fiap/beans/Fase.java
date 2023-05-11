package br.com.fiap.beans;

import br.com.fiap.Interfaces.IElementoVisual;

public class Fase {
    
    public void carregar(IElementoVisual elemento){
        System.out.println("Exibindo " + elemento.getClass().getSimpleName());
    }

}
