package visao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.Pedido;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		Pedido p;
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		int opcao, opcao2, totalPedidos=1,codigo,i, codconfirmado = 0;
		
		
		do {
			System.out.println("Menu Principal");
			System.out.println("1 - Fazer pedido");
			System.out.println("2 - Confirmar Entrega");
			System.out.println("3 - Ver pedidos confirmados ou entregues");

			opcao = teclado.nextInt();
			switch(opcao) {
			case 1:
				p = new Pedido();
				System.out.println("Novo pedido");
				System.out.println("Digite a hora da compra: ");
				p.setHora(teclado.nextInt());
				teclado.nextLine(); //para suprimir o enter
				System.out.println("Digite o endere�o de entrega: ");
				p.setEndEntrega(teclado.nextLine());
				System.out.println("Dados do pedido: "+p.getHora()+", "+p.getEndEntrega());
				System.out.println("Deseja 1-confirmar ou 2-alterar? ");
				opcao2 = teclado.nextInt();
				if(opcao2==2) {
					System.out.println("Digite a hora da compra: ");
					p.setHora(teclado.nextInt());
					teclado.nextLine(); //para suprimir o enter
					System.out.println("Digite o endere�o de entrega: ");
					p.setEndEntrega(teclado.nextLine());
					System.out.println("Dados do pedido: "+p.getHora()+", "+p.getEndEntrega());
				}
				System.out.println("Qual a quantidade de botij�es desejada? ");
				p.setQtdBotijoes(teclado.nextInt());
				teclado.nextLine(); //para suprimir o enter
				System.out.println("Total da compra: "+p.getTotalCompra());
				System.out.println("Hora de entrega: "+p.getHoraEntrega());
				System.out.println("Digite o cart�o de cr�dito: ");
				p.setCartaoCredito(teclado.nextLine());
				p.CalcularCodPedido(totalPedidos);
				totalPedidos++; //errado errad�ssimo
				listaPedidos.add(p);
				break;
			case 2:
				do {
					System.out.println("Informe o código do pedido");
					codigo = teclado.nextInt();
					for(i=0; i<listaPedidos.size() ;i++)
						if(codigo == listaPedidos.get(i).getCodigo()) {
							listaPedidos.get(i).confirmarPedido();
							codconfirmado = 1;
						}else {
							System.out.println("Pedido não encrontrado");
							codconfirmado = 0;
						}
				}while (codconfirmado == 0);
				break;
				
			default: System.out.println("Op��o Inv�lida");	
			}
		
		}while(opcao!=5);
		
	}
}
