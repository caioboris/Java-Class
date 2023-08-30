package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasswordController {

    @FXML
    private TextField txtSenha;
    
    @FXML
    private TextField txtConfirmarSenha;

    @FXML
    private TextField txtSenhaMestre;

    @FXML
    private ListView<String> listaSenhas;

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "rm552496";
    final String PASS = "240103";
    final String SENHA_MESTRA = "VAIPALMEIRAS";
    
    private ArrayList<String> senhas = new ArrayList<>();

    public void adicionarSenha() {
       
        if (!txtSenha.getText().equals(txtConfirmarSenha.getText())) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setHeaderText("ERRO");
            alerta.setContentText("As senhas inserida não coincidem.");
            alerta.show();
        }

        try {
            var conn = DriverManager.getConnection(URL, USER, PASS);

            var stm = conn.prepareStatement("INSERT INTO senhas (senha) VALUES (?)");
            stm.setString(1,txtSenha.getText());
            stm.execute();
            conn.close(); 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        atualizarTela();
    }

    public void atualizarTela() {
        
        var arraySenha = new ArrayList<String>();

        try {
            var conn = DriverManager.getConnection(URL, USER, PASS);      
            var stm = conn.prepareStatement("SELECT * FROM senhas");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                arraySenha.add(rs.getString(1));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        var senhasCod = codificaSenha(senhas);
        listaSenhas.getItems().addAll(senhasCod);
    }

    public ArrayList<String> codificaSenha(ArrayList<String> senhas){
        
        var senhasCodificado = new ArrayList<String>();
        
        for (var senha : senhas) {
            senha.hashCode();
            senhasCodificado.add(senha);
        }

        return senhasCodificado;
    }

    public void mostrarSenhas(){
        if(txtSenhaMestre.getText().equals(SENHA_MESTRA)){
            
        }
    }

    
   

}
