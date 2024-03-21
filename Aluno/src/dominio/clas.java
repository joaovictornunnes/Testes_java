package dominio;

public class clas {
	private String nome;
	private int matricula;
	private float nota1;
	private float nota2;
	private float nota3;
	private float media;
	private String situacao;
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setMatricula(int novaMatricula) {
		this.matricula = novaMatricula;
	}
	
	public void setNotas(float n1,float n2, float n3) {
		this.nota1 = n1;
		this.nota2 = n2;
		this.nota3 = n3;
	}
	
	public void calcularMedia() {
		media = (nota1 + nota2 + nota3) / 3;
	}
	
	public boolean buscarAluno(int matricula) {
		if(this.matricula == matricula) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public float getNota1() {
		return nota1;
	}
	
	public float getNota2() {
		return nota2;
	}
	
	public float getNota3() {
		return nota3;
	}
	
	public float getMedia() {
		calcularMedia();
		
		return media;
	}
	
	public String getSituacao() {
		if(media < 3) {
			situacao = "reprovado";
		}else if (media >= 7) {
			situacao = "aprovado";
		}else {
			situacao = "recuperacao";
		}
		return situacao;
	}
	
	public String alterarNota(int codNota,float valorNota ) {
		return situacao;
	}
}
