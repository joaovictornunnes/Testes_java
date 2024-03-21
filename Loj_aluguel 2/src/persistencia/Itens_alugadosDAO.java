package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Aluguel;
import dominio.Itens;
import dominio.Itens_alugados;

public class Itens_alugadosDAO {
	
	private Conexao c;
	private String Relatorio = "select * from \"itens_alugados\"";
	private String Buscar = "select * from \"itens_alugados\" where \"fk_aluguel\"=?";
	private String Buscaritens = "select fk_itens from \"itens_alugados\" where \"fk_aluguel\"=?";
	private String Incluir = "insert into \"itens_alugados\" (\"fk_item\",\"fk_aluguel\") values (?,?)";
	private String Deletar = "delete from \"itens_alugados\" where \"id\" = ?";
	private String Alterar = "update \"itens_alugados\" set \"Fk_itens\" = ?, \"fk_aluguel\" = ? where \"id\" = ? ";	

	public Itens_alugadosDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","postgres");
	}
	
	public ArrayList<Itens_alugados> Relatorio() {
		Itens_alugados itens_alugados;
		ArrayList<Itens_alugados> lista = new ArrayList<Itens_alugados>();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				itens_alugados = new Itens_alugados(rs.getInt("fk_aluguel"), rs.getInt("fk_itens"));
				lista.add(itens_alugados);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Itens_alugados buscar(int fk_aluguel) {
		Itens_alugados itens_alugados = null;
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			instrucao.setInt(1, fk_aluguel);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				itens_alugados = new Itens_alugados(rs.getInt("fk_aluguel"), rs.getInt("fk_item"));
			}
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return itens_alugados;
	}
	
	public void incluir(Itens item, Aluguel aluguel) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setInt(1, item.getId());
			instrucao.setInt(2, aluguel.getId());
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Deletar (int idAux) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
			instrucao.setInt(1, idAux);
			instrucao.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void Alterar (Itens_alugados itens_alugados){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, itens_alugados.getFk_itens());
            instrucao.setInt(2, itens_alugados.getFk_aluguel());
            instrucao.setInt(3, itens_alugados.getId());
            instrucao.execute();
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}
	
	public Itens_alugados buscaritens(int fk_aluguel) {
		Itens_alugados itens_alugados = null;
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscaritens);
			instrucao.setInt(1, fk_aluguel); 
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				itens_alugados = new Itens_alugados(rs.getInt("fk_itens"));
			}
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return itens_alugados;
	}
}
