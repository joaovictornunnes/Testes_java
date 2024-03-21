package visao;

import java.util.Scanner;
import dominio.Elevador;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		
		//Elevador e1 = new Elevador();
		Elevador e1 = null;
		
		int op;
		
		do {
			System.out.println("Como deseja que o elevador seja inicializado? "
					+ "\n1-sem parâmetros, 2-com 2 parâmetros, 3-com todos os parâmetros: ");
			switch(teclado.nextInt()) {
			case 1: e1 = new Elevador();
				break;
			case 2: System.out.println("Digite a capacidade e o total de andares do prédio: "); 
				e1 = new Elevador(teclado.nextInt(), teclado.nextInt());
				break;
			case 3: System.out.println("Digite o andar atual, total de andares, capacidade e quantidade de pessoas: "); 
				e1 = new Elevador(teclado.nextInt(), teclado.nextInt(), teclado.nextInt(), teclado.nextInt());
				break;
			}
		}while(e1==null);
		
		// inicializando o elevador de acordo com a opção do usuário
		//System.out.println("Qual a capacidade máxima do elevador e o total de andares do prédio? ");
		//e1.inicializa(teclado.nextInt(), teclado.nextInt());
		
		do {
			System.out.println("Menu principal");
			System.out.println("1 - Entra");
			System.out.println("2 - Sai");
			System.out.println("3 - Sobe");
			System.out.println("4 - Desce");
			System.out.println("5 - Sair");
			System.out.println("-----------------");
			System.out.println("Qual a opção desejada? ");
			op = teclado.nextInt();
			switch(op) {
			case 1:	
				if(e1.entra()) {
					System.out.println("Sucesso");
				}else {
					System.out.println("Elevador cheio");
				}
				break;
			case 2: 
				if(e1.sai()){
					System.out.println("Sucesso");
				}else {
					System.out.println("Elevador vazio");
				}
				break;
			case 3: System.out.println("Andar atual: "+e1.sobe());
				break;
			case 4: System.out.println("Andar atual: "+e1.desce());
				break;
			case 5: System.out.println("Fim de programa");
				break;
			default: System.out.println("Opção inválida");
			}
		}while(op!=5);
		
		
	}

}
