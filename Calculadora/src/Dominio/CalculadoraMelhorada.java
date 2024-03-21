package Dominio;

public class CalculadoraMelhorada extends calculadora {
	
	private String memoria;
	
	public CalculadoraMelhorada() {
		super();
	}
	
	private void potencia() {
		int i;

		if(super.getOperando2() == 1) {
			super.setResultado(super.getOperando1());
		}else {
			for(i=1; i <= super.getOperando2();i++) {
				super.setResultado(super.getResultado() + (super.getOperando1() * super.getOperando1()));
			}
		}
	}
	
	public String verUltimaOperacao() {
		return memoria;
	}
	
	public int calcular(int operando1,int operando2) {
		super.setOperando1(operando1);
		super.setOperando2(operando2);
		potencia();
		
		return super.getResultado();
	}
}
