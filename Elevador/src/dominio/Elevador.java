package dominio;

public class Elevador {
	private int andarAtual;
	private int totalAndares;
	private int capacidade;
	private int qtdPessoas;

	
	
	
	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Elevador() {
		andarAtual = 0;
		totalAndares = 4;
		capacidade = 3;
		qtdPessoas = 0;
	}
	
	public Elevador(int c, int t) {
		capacidade = c;
		totalAndares = t;
		andarAtual = 0; //térreo
		qtdPessoas = 0; //elevador vazio
	}
	
	public Elevador(int andarAtual, int totalAndares, int capacidade, int qtdPessoas) {
		this.andarAtual = andarAtual;
		this.totalAndares = totalAndares;
		this.capacidade = capacidade;
		this.qtdPessoas = qtdPessoas;
	}
	
	
//	public void inicializa(int c, int t) {
//		capacidade = c;
//		totalAndares = t;
//		andarAtual = 0; //térreo
//		qtdPessoas = 0; //elevador vazio
//	}

	public boolean entra() {
		if(qtdPessoas < capacidade) {
			qtdPessoas++;
			return true;
		}else {
			return false;
		}
	}
	public boolean sai() {
		if(qtdPessoas>0) {
			qtdPessoas--;
			return true;
		}else {
			return false;
		}
	}
	public int sobe() {
		if(andarAtual<totalAndares) {
			andarAtual++;
		}
		return andarAtual;
	}
	public int desce() {
		if(andarAtual>0) {
			andarAtual--;
		}
		return andarAtual;
	}
}
