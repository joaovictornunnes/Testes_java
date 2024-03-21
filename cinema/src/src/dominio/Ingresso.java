package dominio;

public class Ingresso {
	private int codigo;
	private String cpf;
	private String nomeFilme;
	private int numeroPoltrona; //1 a 120
	private float valor; //16 inteira ou 8 meia
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	public int getNumeroPoltrona() {
		return numeroPoltrona;
	}
	public void setNumeroPoltrona(int numeroPoltrona) {
		this.numeroPoltrona = numeroPoltrona;
	}
	public float getValor() {
		return valor;
	}
	public void calculaValorIngresso(int tipoIngresso) {
		if(tipoIngresso==1)
			this.valor = 8;
		else 
			this.valor = 16;
	}
	
	
	
}
