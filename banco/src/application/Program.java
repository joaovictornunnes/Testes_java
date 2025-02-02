package application;

import java.util.Locale;
import java.util.Scanner;

import banco.Conta;

public class Program {

	public static void main(String[] args) {
		Conta c;
		double valor;
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vamos abrir sua conta!!! ");
		
		System.out.println("digite o numero da sua conta: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		System.out.println("digite o numero seu nome: ");
		String nome = sc.nextLine();
		System.out.println("Voce deseja realizar um deposito inicial? y-sim n-não");
		String teste = sc.nextLine();
		
		if(teste == "y") {
			System.out.println("digite o valor que deseja de positar na sua conta: ");
			valor = sc.nextDouble();
			c = new Conta(numeroConta, nome, valor);
		}else {
			c = new Conta(numeroConta, nome);
		}
		
		System.out.println("conta criada com sucesso");
		
		System.out.println("Dados da conta: " + c);
		
		System.out.println("digite um valor de deposito: ");
		valor = sc.nextDouble();
		c.depositar(valor);
		System.out.println("Dados atualizados da conta: " + c);
		
		System.out.println("digite um valor de saque: ");
		valor = sc.nextDouble();
		c.saque(valor);
		System.out.println("Dados atualizados da conta: " + c);
		
		sc.close();
	}

}
