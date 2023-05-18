package br.com.fiap.banco;

public class App {
	
	public static void main(String[] args) {
		Conta conta = new Conta("00123-5");
		ContaPoupanca poupanca = new ContaPoupanca("00321-5");
		
		
		try {
			conta.depositar(100);
			conta.sacar(20);
			conta.transferencia(poupanca, -1000);
			poupanca.depositar(200);
			poupanca.sacar(20);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}