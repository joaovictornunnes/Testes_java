package visao;

import java.util.ArrayList;

import dominio.Animal;
import dominio.AnimalDeEstimacao;
import dominio.Cachorro;
import dominio.Formiga;
import dominio.Peixe;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cachorro c = new Cachorro("Toto");
		Peixe p = new Peixe();
		Formiga f = new Formiga();
		
		Animal.setQtdAnimais(3);
		System.out.println("Classe Animal - quantidade de animais: "+Animal.getQtdAnimais());
		System.out.println("Classe Cachorro - quantidade de animais: "+c.getQtdAnimais());
		System.out.println("Classe Peixe - quantidade de animais: "+p.getQtdAnimais());
		
		//adicionar um caminho na formiga
		f.adicionarCaminho("Quintal");
		f.adicionarCaminho("Sala de jantar");
		f.adicionarCaminho("Jardim");

		System.out.println("Caminho percorrido por f: "+f.informarCaminho());
		
		//clonando a formiga
		Formiga f2 = f.clone();
		
		System.out.println("Caminho percorrido por f2: "+f2.informarCaminho());

		f.adicionarCaminho("Sala de jantar");
		f2.adicionarCaminho("Rua");

		System.out.println("Caminho percorrido por f: "+f.informarCaminho());
		System.out.println("Caminho percorrido por f2: "+f2.informarCaminho());
		
		ArrayList<AnimalDeEstimacao> ae = new ArrayList<AnimalDeEstimacao>();
		int i;
		
		ae.add(c);
		ae.add(p);

		for(i=0; i<ae.size(); i++) {
			System.out.println("brincando... "+ae.get(i).brinca());
		}

		for(i=0; i<ae.size(); i++) {
			if(ae.get(i) instanceof Peixe) {
				System.out.println("nadando... "+ ((Peixe) ae.get(i)).nada());
			}
/*			try {
				System.out.println("nadando... "+ ((Peixe) ae.get(i)).nada());
			}catch(Exception e) {
				System.out.println("Não foi possível a conversão");
			}
*/
		}

	}

}
