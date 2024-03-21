package visao;

import dominio.Carro;
import dominio.CarroDeBrinquedo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CarroDeBrinquedo cb = new CarroDeBrinquedo();
		
		cb.acelera();
		System.out.println("Velocidade = "+cb.getVelocidade());
		cb.acelera(100);
		System.out.println("Velocidade = "+cb.getVelocidade());
		
	}

}
