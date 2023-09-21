package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Jogo;

public class VinteUmDAO{

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "rm552496";
    final String PASSWORD = "240103";
    
    public void salvarJogada(Jogo jogo) throws SQLException {
        var conn = DriverManager.getConnection(URL, USER, PASSWORD);

        var query = "INSERT INTO T_BLACKJACK (id_jogo, pt_jogador, pt_computador, resultado) VALUES (?,?,?)";
        var stmt = conn.prepareStatement(query);
        stmt.setInt(1,jogo.getId());
        stmt.setInt(2,jogo.getJogador().getPontos());
        stmt.setInt(3, jogo.getComputador().getPontos());
        stmt.setString(4, jogo.resultado());

        stmt.executeUpdate();

        conn.close();
    }

        
    public List<String> ranking() throws SQLException {
        
        var resultados = new ArrayList<String>();

        var conn = DriverManager.getConnection(URL, USER, PASSWORD);

        var rs = conn.createStatement().executeQuery("SELECT resultado FROM T_BLACKJACK ORDER BY ID_JOGO FETCH FIRST 5 ROWS ONLY");

        while(rs.next()){
            resultados.add(rs.getString("resultado"));
        }

        conn.close();
        return resultados;
    }


}