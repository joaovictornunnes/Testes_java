package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Aluguel;
import dominio.Cliente;
import dominio.Funcionario;
import dominio.Itens;
import dominio.Itens_alugados;


public class AluguelDAO {
	
	private Conexao c;
	private String Relatorio = "select * from \"aluguel\"";
	private String Buscar = "select * from \"aluguel\" where \"id\"=?";
	private String Buscar2 = "select id from \"aluguel\" where \"fk_item\"=? and \"fk_cliente\"=? and \"fk_funcionario\"=?";
	private String Incluir = "insert into \"aluguel\" (\"fk_cliente\", \"fk_funcionario\", \"data_saida\", \"forma_pag\", \"qtd_itens\", \"data_entrega\", \"ajuste\", \"observacao\", \"valor_total\") values (?,?,?,?,?,?,?,?,?)";
	private String Deletar = "on delete cascade from \"aluguel\" where \"id\" = ?";
	private String Alterar = "on update cascade \"aluguel\" set \"fk_cliente\"= ? , \"fk_funcionario\" = ?, \"data_saida\" = ? , \"forma_pagamento\"  = ? , \"quantidade_itens\" = ? , \"data_devolucao\" = ? , \"ajuste\" = ? , \"observacao\" = ? , \"valor_total\" = ?";	

	public AluguelDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/Aluguel","postgres","postgres");
	}
	
	public ArrayList<Aluguel> Relatorio() {
		Aluguel aluguel;
		ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
		Cliente cliente = null;
		Funcionario funcionario = null;
		Itens item = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		FuncionarioDAO fDAO = new FuncionarioDAO();
		ItensDAO iDAO = new ItensDAO();
		try {
			c.conectar(); 
			Statement instrucao = c.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(Relatorio);
			while(rs.next()) { 
				aluguel = new Aluguel(rs.getInt("id"), rs.getString("data_saida"), rs.getString("forma_pag"), rs.getInt("qtd_itens"), rs.getString("data_entrega"), rs.getString("ajuste"), rs.getString("observacao"), rs.getFloat("valor_total"));
				cliente = clienteDAO.buscar(rs.getString("fk_cliente"));
				funcionario = fDAO.buscar(rs.getString("fk_funcionario"));
				item = iDAO.buscar(rs.getInt("id"));
				aluguel.setFk_cliente(cliente);
				aluguel.setFk_funcionario(funcionario);
				aluguel.setFk_item(item);
				lista.add(aluguel);
			}
			c.desconectar(); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public Aluguel buscar(int id) {
		Cliente cliente = null;
		Aluguel aluguel = null;
		Funcionario funcionario = null;
		Itens_alugados ialuguel = null;
		Itens item = null;
		ClienteDAO clienteDAO = new ClienteDAO();
		FuncionarioDAO fDAO = new FuncionarioDAO();
		ItensDAO iDAO = new ItensDAO();
		Itens_alugadosDAO iaDAO = new Itens_alugadosDAO();

		
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
			
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				aluguel = new Aluguel(rs.getInt("id"), rs.getString("data_saida"), rs.getString("forma_pag"), rs.getInt("qtd_itens"), rs.getString("data_entrega"), rs.getString("ajuste"), rs.getString("observacao"), rs.getFloat("valor_total"));
				cliente = clienteDAO.buscar(rs.getString("fk_cliente"));
				funcionario = fDAO.buscar(rs.getString("fk_funcionario"));
				item = iDAO.buscar(rs.getInt("fk_item"));
				aluguel.setFk_cliente(cliente);
				aluguel.setFk_funcionario(funcionario);
				aluguel.setFk_item(item);
			};
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return aluguel;
	}
	
	public void incluir(Aluguel aluguel, Cliente Clientes, Funcionario Funcionarios) {
		Itens_alugadosDAO iaDAO = new Itens_alugadosDAO();
		
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Incluir);
			instrucao.setString(1, Clientes.getCpf());
			instrucao.setString(2, Funcionarios.getCpf());
			instrucao.setString(3, aluguel.getData_saida());
			instrucao.setString(4, aluguel.getForma_pagamento());
			instrucao.setInt(5, aluguel.getQuantidade_itens());
			instrucao.setString(6, aluguel.getData_devolucao());
			instrucao.setString(7, aluguel.getAjuste());
			instrucao.setString(8, aluguel.getObservacao());
			instrucao.setFloat(9, aluguel.getValor_total());
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
		
	public void Alterar (Aluguel aluguel, Cliente cliente, Funcionario funcionario){
        try{
        	c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, aluguel.getId());
			instrucao.setString(2, cliente.getCpf());
			instrucao.setString(3, funcionario.getCpf());
			instrucao.setString(4, aluguel.getData_saida());
			instrucao.setString(5, aluguel.getForma_pagamento());
			instrucao.setInt(6, aluguel.getQuantidade_itens());
			instrucao.setString(7, aluguel.getData_devolucao());
			instrucao.setString(8, aluguel.getAjuste());
			instrucao.setString(9, aluguel.getObservacao());
			instrucao.setFloat(10, aluguel.getValor_total());
            c.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
	}
	
	public Aluguel buscar2(Aluguel aluguel, Cliente cliente, Funcionario funcionario, Itens item) {
		try {
			c.conectar();
			PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar2);
			
			instrucao.setInt(1, item.getId());
			instrucao.setString(2, cliente.getCpf());
			instrucao.setString(3, funcionario.getCpf());
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				aluguel.setId(rs.getInt("id"));
			};
			c.desconectar();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return aluguel;
	}

}