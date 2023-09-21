package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.model.Cliente;
import com.example.model.Veiculo;

public class VeiculoDao {

    private Connection conexao;
    private Random random = new Random();

    public VeiculoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void inserir(Veiculo veiculo) throws SQLException {

        var sql = "INSERT INTO veiculos (marca, modelo, ano, valor, id_cliente) VALUES (?, ?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1,veiculo.getMarca());
        comando.setString(2, veiculo.getModelo());
        comando.setInt(3, veiculo.getAno());
        comando.setBigDecimal(4, veiculo.getValor());
        comando.setLong(5, veiculo.getCliente().getId());
        comando.executeUpdate();
    }

    public List<Veiculo> buscarTodos() throws SQLException{
        var lista = new ArrayList<Veiculo>();
        var comando = conexao.prepareStatement("SELECT veiculos.*, clientes.nome, clientes.email, clientes.telefone FROM VEICULOS INNER JOIN clientes ON veiculos.id_cliente= clientes.id");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (new Veiculo(
                resultado.getLong("id"), 
                resultado.getString("marca"), 
                resultado.getString("modelo"), 
                resultado.getInt("ano"), 
                resultado.getBigDecimal("valor"),
                new Cliente(
                    resultado.getLong("id_cliente"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone")
                )
            ));
        }
        return lista;
    }

    public void apagar(Long id) throws SQLException{
        var comando = conexao.prepareStatement("DELETE FROM veiculos WHERE ID=?");
        comando.setLong(1, id);
        comando.executeUpdate();
    }

    public void atualizar(Veiculo veiculo) throws SQLException{
        var comando = conexao.prepareStatement("UPDATE veiculos SET marca=?, modelo=?,ano=?,valor=? WHERE id=?");
        comando.setString(1, veiculo.getMarca());
        comando.setString(1, veiculo.getModelo());
        comando.setInt(1, veiculo.getAno());
        comando.setBigDecimal(1, veiculo.getValor());
        comando.setLong(1, veiculo.getId());

        comando.executeUpdate();
    }
}
