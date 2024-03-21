package dominio;

public class CarroDeBrinquedo extends Carro{

	public CarroDeBrinquedo() {
		super(0);
	}

	public void acelera() {
		super.setVelocidade(super.getVelocidade()+2);
	}
	
	public void acelera(int forca) {
		super.setVelocidade(super.getVelocidade()+forca);
	}
}
