package com.example;

import java.sql.SQLException;

import com.example.data.VinteUmDAO;
import com.example.model.Carta;
import com.example.model.Jogo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML
    private HBox mesaDoJogador;
    @FXML
    private HBox mesaDoComputador;
    @FXML
    private ImageView monte;

    @FXML
    private Label pontosMesa;
    @FXML
    private Label pontosJogador;
    @FXML
    private Label resultado;

    private Jogo jogo;

    VinteUmDAO dao = new VinteUmDAO();

    public void turno() {
        
        if (jogo == null)
            novoJogo();
        
        if (jogo.acabou()){          
            salvar(jogo);
            ranking();
        }

        if (!jogo.getJogador().parou())
            jogo.distribuiCartaParaJogador(jogo.getJogador());
        if (!jogo.getComputador().parou())
            jogo.distribuiCartaParaJogador(jogo.getComputador());

        atualizar();
    }

    private void salvar(Jogo jogo) {
        try {
            dao.salvarJogada(jogo);
        } catch (SQLException e) {
            Alert erro = new Alert(AlertType.ERROR);
            erro.setContentText(e.getMessage());
            erro.show();
        }
    }

    private void ranking() {
        try {
            dao.ranking();
        } catch (SQLException e) {
            Alert erro = new Alert(AlertType.ERROR);
            erro.setContentText(e.getMessage());
            erro.show();
        }
    }

    public void atualizar() {
        pontosJogador.setText("Jogador: " + jogo.getJogador().getPontos());
        pontosMesa.setText("Mesa: " + jogo.getComputador().getPontos());

        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();

        jogo.getJogador().getCartas().forEach((carta) -> mesaDoJogador.getChildren().add(imagemCarta(carta)));
        jogo.getComputador().getCartas().forEach((carta) -> mesaDoComputador.getChildren().add(imagemCarta(carta)));
    }

    public void novoJogo() {
        jogo = new Jogo();
        mesaDoJogador.getChildren().clear();
        mesaDoComputador.getChildren().clear();
        pontosJogador.setText("Jogador: 0");
        pontosMesa.setText("Mesa: 0");
        resultado.setText("");
    }

    public void pedirCarta() {
        turno();
    }

    public void parar() {
        jogo.getJogador().parar();
        turno();
    }

    private ImageView imagemCarta(Carta carta) {
        return new ImageView(App.class.getResource(carta.imagePath()).toString());
    }

}
