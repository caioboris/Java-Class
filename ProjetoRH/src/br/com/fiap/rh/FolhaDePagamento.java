package br.com.fiap.rh;

public class FolhaDePagamento {
	
	private double total;
	
	public void registrar(Funcionario funcionario) {
		total = getTotal() + funcionario.calcularSalario();
	}

	public double getTotal() {
		return total;
	}
	
	public void login(Autenticavel funcionario, String senha) {
		if(funcionario.autenticar(senha)) {
			System.out.println(funcionario.getClass().getSimpleName() + " Autenticado");
		}
	}

	

}

