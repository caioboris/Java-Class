package br.com.fiap.rh;

public class Engenheiro extends Funcionario {

    private String departamento;
    private String crea;

    @Override
    public double calcularSalario() {
        return super.calcularSalario()* 1.5;
    }
}
