package dominio;

public class Cachorro{
	
	private String nome;
	private String raca;
	private int idade;
	
	public Cachorro(String nome, String raca, int idade) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	} 
	
	public String getinformarEstado() {
		return nome +", " + raca+ ", " +idade;
	}
	
	public Cachorro clonarCachorro() {
		Cachorro clone = new Cachorro(this.getNome(), this.getRaca(), this.getIdade());
		return clone;
	}
	
	public boolean equals(Cachorro c) {
		if((this.nome == c.getNome()) && (this.raca == c.getRaca()) && (this.idade == c.getIdade())){
			return true;

			}else {
				return false;
			}
		
		}
	
	
	
	
}