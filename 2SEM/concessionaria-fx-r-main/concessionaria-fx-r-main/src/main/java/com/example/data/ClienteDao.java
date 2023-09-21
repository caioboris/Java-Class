package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Cliente;

public class ClienteDao {

    private Connection conexao;
    private Random random = new Random();

    public ClienteDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void inserir(Cliente cliente) throws SQLException {
        var sql = "INSERT INTO clientes (id,nome, email, telefone) VALUES ( ?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1,random.nextLong());
        comando.setString(2, cliente.getNome());
        comando.setString(3, cliente.getEmail());
        comando.setString(4, cliente.getTelefone());
        comando.executeUpdate();
    }

    public List<Cliente> buscarTodos() throws SQLException{
        var lista = new ArrayList<Cliente>();
        var comando = conexao.prepareStatement("SELECT * FROM clientes");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (new Cliente(
                resultado.getLong("id"), 
                resultado.getString("nome"), 
                resultado.getString("email"), 
                resultado.getString("telefone")
            ));
        }
        return lista;
    }
}
