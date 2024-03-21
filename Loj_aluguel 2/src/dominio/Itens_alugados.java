package dominio;

public class Itens_alugados {
	
	
	private int id;
	private int fk_aluguel;
	private int fk_itens;

	public Itens_alugados(int fk_aluguel, int fk_itens){
		this.fk_aluguel = fk_aluguel;
		this.fk_itens = fk_itens;
	}
	
	public Itens_alugados(int fk_itens){
		this.fk_itens = fk_itens;
	}
	
	public Itens_alugados(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_aluguel() {
		return fk_aluguel;
	}
	public void setFk_aluguel(int fk_aluguel) {
		this.fk_aluguel = fk_aluguel;
	}
	public int getFk_itens() {
		return fk_itens;
	}
	public void setFk_itens(int fk_itens) {
		this.fk_itens = fk_itens;
	}
	
}
