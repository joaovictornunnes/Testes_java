package visao;

import dominio.Cachorro;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Cachorro c1,c2;
		c1 = new Cachorro("Cachorro sem nome", "nehnuma raça definida", 0);
		
		System.out.println("Nome do cachorro: "+c1.getNome());
		System.out.println("Raca do cachorro: "+c1.getRaca());
		System.out.println("Idade do cachorro: "+c1.getIdade());
		
		
		c1.setNome("Mel");
		c1.setRaca("labrador");
		c1.setIdade(10);
		
		//c1.setNome(teclado.nextLine());
		//c1.setRaca(teclado.nextLine());
		//c1.setIdade(teclado.nextInt());
		
		System.out.println(c1.getinformarEstado());
		
		c2 = c1.clonarCachorro();
		
		System.out.println(c2.getinformarEstado());
		
		if(c1.getinformarEstado().equals(c2.getinformarEstado())) {
			System.out.println("estados iguais");
		}else {
			System.out.println("diferentes");
		}
	}

}
