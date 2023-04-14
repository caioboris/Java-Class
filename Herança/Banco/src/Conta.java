public class Conta {
    
    private String numero;
    private double saldo;
    private double taxa;

    public Conta(String numero) {
        this.numero = numero;
    }
    
    
    public void depositar(double valor){
        saldo += valor;
    }
    
    public void sacar (double valor){
        saldo -= valor;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getTaxa() {
        return taxa;
    }
}
