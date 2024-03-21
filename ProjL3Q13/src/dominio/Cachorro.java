package dominio;

public class Cachorro extends Animal implements AnimalDeEstimacao{
	private String nome;
	
	public Cachorro() {
		super.setPernas(4);
	}
	public Cachorro(String nome) {
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public String brinca() {
		return "O cachorro está brincando";
	}
	public String come() {
		return "O animal - CACHORRO - está comendo";
	}
}
