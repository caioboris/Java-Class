package br.com.fiap.rh;

public class Gerente extends Funcionario implements Autenticavel {

    private String departamento;
    private String senha;
    private double bonus;
    
    
    @Override
    public double calcularSalario(){
        return super.calcularSalario() + bonus;
    }

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
       

}
