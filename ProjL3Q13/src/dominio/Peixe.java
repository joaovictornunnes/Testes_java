package dominio;

public class Peixe extends Animal implements AnimalDeEstimacao{
	private String nome;
	
	public Peixe() {
		super.setPernas(0);		
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public String brinca() {
		return "O peixe est� brincando";
	}
	public String nada() {
		return "O peixe est� nadando";
	}
	
}
