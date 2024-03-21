package visao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.Ingresso;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);	
		ArrayList<Ingresso> sala = new ArrayList<Ingresso>();
		Ingresso ing;
		
		int op, tipoIngresso, i, numPoltronaAux;
		String nomeFilme, cpfAux;
		boolean achou;
		
		System.out.println("Digite o nome do filme da sala: ");
		nomeFilme = teclado.nextLine();
		
		
		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - Comprar ingresso");
			System.out.println("2 - Alterar ingresso");
			System.out.println("3 - Desistir do ingresso");
			System.out.println("4 - Sair");
			System.out.println("Qual a opção desejada? ");
			op = teclado.nextInt();
			
			switch(op) {
				case 1:
					ing = new Ingresso();
					ing.setNomeFilme(nomeFilme); //automático para todo ingresso desta sala
					teclado.nextLine();

					do {
						achou = false;
						System.out.println("Digite o cpf do cliente: ");
						cpfAux = teclado.nextLine();
						for(i=0; i<sala.size(); i++) {
							if(cpfAux.equals(sala.get(i).getCpf())){
								achou = true;
								break;
							}
						}
						if(achou)
							System.out.println("Cliente já comprou ingresso");
					}while(achou);
					ing.setCpf(cpfAux);

					// mostrar as poltronas disponíveis
					System.out.println("Poltronas vendidas (1-120): ");
					for(i=0; i<sala.size(); i++) 
						System.out.println(sala.get(i).getNumeroPoltrona()+"-");
					//controlar a venda considerando poltronas disponíveis/vendidas
					do {
						achou = false;
						System.out.println("Digite o número da poltrona do cliente: ");
						numPoltronaAux = teclado.nextInt();
						for(i=0; i<sala.size(); i++) {
							if(numPoltronaAux == sala.get(i).getNumeroPoltrona()){
								achou = true;
								break;
							}
						}
						if(achou)
							System.out.println("Poltrona vendida");
					}while(achou);
					ing.setNumeroPoltrona(numPoltronaAux);
					
					System.out.println("Digite 1-Meia, 2-Inteira: ");
					do{
						tipoIngresso = teclado.nextInt();
					}while((tipoIngresso!=1)&&(tipoIngresso!=2));
					ing.calculaValorIngresso(tipoIngresso);
					
					
					sala.add(ing);
				break;
				case 2: 
				break;
				case 3: 
				break;
				case 4: System.out.println("Fim de programa");
				break;
				default: System.out.println("Opção inválida");
			}
			
		}while(op!=4);

	}

}
