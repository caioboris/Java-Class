package com.example;

import com.example.Model.Carta;
import com.example.Model.Jogo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML private HBox mesaDoJogador;
    @FXML private HBox mesaDoComputador;
    @FXML private ImageView monte;

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;

    private Jogo jogo;

    public void turno(){
        
        if(!jogo.acabou()){
            if(!jogo.getJogador().parou()){
                jogo.distribuiCartaParaJogador(jogo.getJogador());
            }
            if(!jogo.getComputador().parou()){
                jogo.distribuiCartaParaJogador(jogo.getComputador());
            }
        }
    }

    public void atualizar(){
        pontosJogador.setText("Jogador: " + jogo.getJogador().getPontos());
        pontosMesa.setText("Mesa: " + jogo.getComputador().getPontos());
        
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.getJogador().getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.getComputador().getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    public void novoJogo(){
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta(){
       turno();
    }

    public void parar(){
        jogo.getJogador().parar();
        turno();
    }
    

    private ImageView imagemCarta(Carta carta) {
       return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }

}
