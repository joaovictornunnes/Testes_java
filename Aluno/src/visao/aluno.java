package visao;

import dominio.clas;
import java.util.Scanner;

public class aluno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int op,mat;
		
		clas c1 = new clas();
		clas c2 = new clas();
		clas c3 = new clas();
		
		do {
			System.out.println("Menu principal");
			System.out.println("1 - Cadastrar Alunos");
			System.out.println("2 - Cadastrar notas");
			System.out.println("3 - Calcular médias");
			System.out.println("4 - Informar situacao");
			System.out.println("5 - Informar dados de um Aluno");
			System.out.println("6 - Alterar nota");
			System.out.println("5 - Sair");
			System.out.println("-----------------");
			System.out.println("Qual a op��o desejada? ");
			op = teclado.nextInt();
			switch(op) {
			case 1:
				System.out.println("Digite o nome e a matricula de cada um dos alunos:");
				System.out.println("Nome do primeiro aluno:");
				c1.setNome(teclado.next());
				System.out.println("Matricula do primeiro aluno:");
				c1.setMatricula(teclado.nextInt());
				System.out.println("Nome do segundo aluno:");
				c2.setNome(teclado.next());
				System.out.println("Matricula do segundo aluno:");
				c2.setMatricula(teclado.nextInt());
				System.out.println("Nome do terceiro aluno:");
				c3.setNome(teclado.next());
				System.out.println("Matricula do terceiro aluno:");
				c3.setMatricula(teclado.nextInt());
				break;
				
			case 2:
				System.out.println("Digite as notas de cada um dos alunos:");
				System.out.println("Nota 1, 2 e 3 do primeiro aluno:");
				c1.setNotas(teclado.nextFloat(), teclado.nextFloat(), teclado.nextFloat());
				
				System.out.println("Nota 1, 2 e 3 do segundo aluno:");
				c2.setNotas(teclado.nextFloat(), teclado.nextFloat(), teclado.nextFloat());
				
				System.out.println("Nota 1, 2 e 3 do terceiro aluno:");
				c3.setNotas(teclado.nextFloat(), teclado.nextFloat(),teclado.nextFloat());
				break;
			
			case 3:
				
					c1.calcularMedia();
					System.out.println("A média do aluno "+ c1.getNome() +" é: " + c1.getMedia());
				
					System.out.println("A média do aluno" + c2.getNome() +" é: " + c2.getMedia());
					c2.calcularMedia();
		
					c3.calcularMedia();
					System.out.println("A média do aluno"+ c3.getNome() + "é: "  + c3.getMedia());
				break;
			case 4:
				System.out.println("A média do aluno"+ c1.getNome()+ " é: " + c1.getSituacao());
				System.out.println("A média do aluno"+ c2.getNome()+ " é: " + c2.getSituacao());
				System.out.println("A média do aluno"+ c3.getNome()+ " é: " + c3.getSituacao());
				break;
			case 5:
				System.out.println("Qual a mátricula do aluno?");
				mat = teclado.nextInt();
				if (mat == c1.getMatricula()) {
					System.out.println(c1.getNome());
					System.out.println(c1.getMedia());
					System.out.println(c1.getMatricula());
					System.out.println(c1.getSituacao());
				}
				if (mat == c2.getMatricula()) {
					System.out.println(c2.getNome());
					System.out.println(c2.getMedia());
					System.out.println(c2.getMatricula());
					System.out.println(c2.getSituacao());
				}
				if (mat == c3.getMatricula()) {
					System.out.println(c3.getNome());
					System.out.println(c3.getMedia());
					System.out.println(c3.getMatricula());
					System.out.println(c3.getSituacao());
				}
			}
		}while(op != 7);
		
	}

}
