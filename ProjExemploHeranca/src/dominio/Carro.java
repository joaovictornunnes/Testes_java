package dominio;

public class Carro {
	private int velocidade;
	
	public Carro(int velocidadeInicial){
		velocidade = velocidadeInicial;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	
	public void acelera() {
		velocidade++;
	}
	
	public void setVelocidade(int v) {
		velocidade = v;
	}
}
