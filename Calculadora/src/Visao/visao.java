package Visao;

import Dominio.calculadora;
import Dominio.CalculadoraMelhorada;


public class visao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int resultado,resultado2;
		
		calculadora e1 = new calculadora();
		CalculadoraMelhorada c1 = new CalculadoraMelhorada();
		
		resultado = e1.calcular(12,2,'+');
		System.out.println(resultado);
		
		
		resultado2 = c1.calcular(18, 1);
		System.out.println(resultado2);
	}

}
