package com.example;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.data.ClienteDao;
import com.example.data.VeiculoDao;
import com.example.model.Cliente;
import com.example.model.Veiculo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class PrimaryController implements Initializable {

    @FXML TextField txtMarca;
    @FXML TextField txtModelo;
    @FXML TextField txtAno;
    @FXML TextField txtValor;

    @FXML TableView<Veiculo> tabelaVeiculo;

    @FXML TableColumn<Veiculo, String> colMarca;
    @FXML TableColumn<Veiculo, String> colModelo;
    @FXML TableColumn<Veiculo, Integer> colAno;
    @FXML TableColumn<Veiculo, BigDecimal> colValor;
    @FXML TableColumn<Veiculo, String> colCliente;

    @FXML TextField txtNome;
    @FXML TextField txtEmail;
    @FXML TextField txtTelefone;

    @FXML TableView<Cliente> tabelaCliente;

    @FXML TableColumn<Cliente, String> colNome;
    @FXML TableColumn<Cliente, String> colEmail;
    @FXML TableColumn<Cliente, String> colTelefone;

    @FXML ComboBox<Cliente> cbCliente;

    ClienteDao clienteDao;
    VeiculoDao veiculoDao;

    public void adicionarVeiculo(){
        var veiculo = new Veiculo(
            null, 
            txtMarca.getText(), 
            txtModelo.getText(), 
            Integer.valueOf( txtAno.getText() ), 
            new BigDecimal( txtValor.getText() ),
            cbCliente.getSelectionModel().getSelectedItem()
        );

        try{
            veiculoDao.inserir(veiculo);
            tabelaVeiculo.getItems().add(veiculo);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void carregarVeiculos(){
        tabelaVeiculo.getItems().clear();
        try {
            var veiculos = veiculoDao.buscarTodos();
            veiculos.forEach(veiculo -> tabelaVeiculo.getItems().add(veiculo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarCliente(){
        var cliente = new Cliente(
            null, 
            txtNome.getText(), 
            txtEmail.getText(), 
            txtTelefone.getText()
        );

        try{
            clienteDao.inserir(cliente);
            tabelaCliente.getItems().add(cliente);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void carregarClientes(){
        tabelaCliente.getItems().clear();
        try {
            var clientes = clienteDao.buscarTodos();
            clientes.forEach(cliente -> tabelaCliente.getItems().add(cliente));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagarVeiculo(){
        var veiculo = tabelaVeiculo.getSelectionModel().getSelectedItem();
        
        if(veiculo == null){
            mostrarMensagem("Erro", "Selecione um veículo para apagar.");
            return;
        }
        try {
            veiculoDao.apagar(veiculo.getId());
            tabelaVeiculo.getItems().remove(veiculo);
        } catch (SQLException e) {
            mostrarMensagem("Erro", "Erro ao apagar");
        }
    }
    
    public void atualizarVeiculo(Veiculo veiculo){
        try {
            veiculoDao.atualizar(veiculo);
        } catch (SQLException e) {
           mostrarMensagem("Erro", "Erro ao atualizar");
        }
    }

    private void mostrarMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colMarca.setCellFactory(TextFieldTableCell.forTableColumn());
        colMarca.setOnEditCommit(e ->atualizarVeiculo(e.getRowValue().marca(e.getNewValue())));
        
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colModelo.setCellFactory(TextFieldTableCell.forTableColumn());
        colModelo.setOnEditCommit(e ->atualizarVeiculo(e.getRowValue().modelo(e.getNewValue())));
        
        colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colAno.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        colAno.setOnEditCommit(e ->atualizarVeiculo(e.getRowValue().ano(e.getNewValue())));
        
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colValor.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
        colValor.setOnEditCommit(e ->atualizarVeiculo(e.getRowValue().valor(e.getNewValue())));

        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        try {
            clienteDao = new ClienteDao();
            veiculoDao = new VeiculoDao();
            cbCliente.getItems().addAll(clienteDao.buscarTodos());
        } catch (Exception e) {
           mostrarMensagem("Erro", "Erro ao buscar clientes");
           e.printStackTrace();
        }

        carregarVeiculos();
        carregarClientes();
    }

   
}
