package dominio;

public abstract class Animal {
	private int pernas;
	private static int qtdAnimais;
	
	public Animal() {

	}
	public String caminha() {
		return "O animal est� caminhando";
	}	
	public String come() {
		return "O animal est� comendo";
	}
	public int getPernas() {
		return pernas;
	}
	public void setPernas(int pernas) {
		this.pernas = pernas;
	}
	public static int getQtdAnimais() {
		return qtdAnimais;
	}
	public static void setQtdAnimais(int qtdAnimais) {
		Animal.qtdAnimais = qtdAnimais;
	}
	
}







