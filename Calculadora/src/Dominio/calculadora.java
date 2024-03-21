package Dominio;

public class calculadora {
	
	private char operador;
	private int operando1;
	private int operando2;
	private int resultado;

	public calculadora() {
		operador = 0;
		operando1 = 0;
		operando2 =0;
		resultado = 0;
	}
	
	public char getOperador() {
		return operador;
	}

	public void setOperador(char operador) {
		this.operador = operador;
	}

	public int getOperando1() {
		return operando1;
	}

	public void setOperando1(int operando1) {
		this.operando1 = operando1;
	}

	public int getOperando2() {
		return operando2;
	}

	public void setOperando2(int operando2) {
		this.operando2 = operando2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public int calcular(int operando1,int operando2, char operador) {
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.operador = operador;

		switch(operador) {
		case '+':
			soma();
			return resultado;
		case '-':
			subtracao();
			return resultado;
		case '/':
			divisao();
			return resultado;
		case '*':
			multiplicacao();
			return resultado;
		}
		return 0;
	}
	
	private void soma() {
		resultado = operando1 + operando2;
	}
	
	private void subtracao() {
		resultado = operando1 - operando2;
	}
	
	private void divisao() {
		resultado = operando1 / operando2;
	}
	
	private void multiplicacao() {
		resultado = operando1 * operando2;
	}

}
