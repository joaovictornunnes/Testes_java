package banco;

public class Conta {
	
	private int numeroConta;
	private String nome;
	private double valor;
	
	public Conta(int numeroConta, String nome, double valor) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		depositar(valor);
	}
	
	public Conta(int numeroConta, String nome) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.valor = 0;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}
	
	public void depositar(double valor) {
		this.valor += valor;
	}
	
	public void saque(double valor) {
		
		this.valor -= (valor + 5.0);
	}
	
	public String toString() {
		return "Conta"
				+ this.numeroConta
				+ ", Dono: "
				+ nome
				+ ", Saldo: "
				+ valor;
	}
}
