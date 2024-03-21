package dominio;

import java.util.ArrayList;

public class Formiga extends Animal{
	private ArrayList<Local> caminho;
	
	public Formiga() {
		//super.setPernas(6);
		this.setPernas(6);
		caminho = new ArrayList<Local>();
	}
	
	public void adicionarCaminho(String desc) {
		Local l = new Local();
		l.setDescricao(desc);
		caminho.add(l);
	}
	
	public String informarCaminho() {
		String caminhoPercorrido = " ";
		int i;
		for(i=0; i<caminho.size(); i++) {
			caminhoPercorrido = caminhoPercorrido + caminho.get(i).getDescricao() + ", ";
		}
		
		return caminhoPercorrido;
	}
	
	public Formiga clone() {
		int i;
		Local l;
		Formiga f = new Formiga();
		f.setPernas(this.getPernas());

		// REFEITO PORQUE A FORMIGA JÁ TEM UM ARRAYLIST NOVO QUANDO É INSTANCIADA,
		// PORTANTO A CRIAÇÃO DE UM NOVO ARRAYLIST PARA ELA TORNA-SE REDUNDANTE
		for(i = 0; i < caminho.size(); i++) {
			l = new Local();
			l.setDescricao(caminho.get(i).getDescricao());
			f.caminho.add(l);
		}
		return f;

		/*FEITO EM SALA - CÓDIGO ANTERIOR
		ArrayList<Local> caminhoF = new ArrayList<Local>();
		for(i = 0; i < caminho.size(); i++) {
			l = new Local();
			l.setDescricao(caminho.get(i).getDescricao());
			caminhoF.add(l);
		}
		f.caminho = caminhoF;
		return f;
		*/
	}
	
}
