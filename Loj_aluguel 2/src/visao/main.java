package visao;

import persistencia.AluguelDAO;
import persistencia.ClienteDAO;
import persistencia.FuncionarioDAO;
import persistencia.ItensDAO;
import persistencia.Itens_alugadosDAO;
import dominio.Aluguel;
import dominio.Cliente;
import dominio.Funcionario;
import dominio.Itens;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public main(String[] args) {
        // TODO Auto-generated method stub

        ItensDAO iDAO = new ItensDAO();
        ClienteDAO clDAO = new ClienteDAO();
        FuncionarioDAO fDAO= new FuncionarioDAO();
        AluguelDAO aDAO = new AluguelDAO();
        Itens_alugadosDAO iaDAO = new Itens_alugadosDAO(); 
        
        Itens Item;
        ArrayList<Itens> itens;
        Cliente cliente;
        Funcionario funcionario;
        Aluguel aluguel;
        
        int op, op2, idaux, i, contaux;
        float valortotal;
        String tipoaux,cpfaux ;
        Scanner teclado = new Scanner(System.in);
        boolean continuar = false;
        
        do {
			System.out.println("\nMenu Principal");
			System.out.println("1 - Buscar");
			System.out.println("2 - Incluir");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Relatório");
			System.out.println("6 - Alugar");
			System.out.println("7 - Sair");
			op = teclado.nextInt();
			teclado.nextLine();
			
			switch(op) {
				case 1:
					System.out.println("\nOque Voce deseja Buscar?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Aluguel");
					System.out.println("5 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Buscando Itens...");
						System.out.println("Digite o id de item: ");
						idaux = teclado.nextInt();
						Item = iDAO.buscar(idaux);
						if(Item == null) {
							System.out.println("Itens não encontrados no estoque");
						}else {
							System.out.println("Item encontrado");
							System.out.println("Tipo: "+Item.getTipo());
							System.out.println("Id: "+Item.getId());
							System.out.println("Tamanho: "+Item.getTamanho());
							System.out.println("Manutencao: "+Item.getManutencao());
							System.out.println("Valor: R$"+Item.getValor());
							}
					break;
					case 2:
						System.out.println("Buscando Cliente...");
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							System.out.println("Cliente encontrado");
							System.out.println("Nome: "+cliente.getNome());
							System.out.println("Cpf: "+cliente.getCpf());
							System.out.println("Cep: "+cliente.getCep());
							System.out.println("Numero da casa: "+cliente.getNumero_casa());
							System.out.println("Telefone: "+cliente.getTelefone());
							System.out.println("Email: "+cliente.getEmail());
						}
					break;
					case 3:
						System.out.println("Buscando Funcionário...");
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionário não encontrado");
						}else {
							System.out.println("Funcionário encontrado");
							System.out.println("Nome: "+funcionario.getNome());
							System.out.println("Cpf: "+funcionario.getCpf());
							System.out.println("Carteira de trab: "+funcionario.getCarteira_trab());
							System.out.println("Contrato: "+funcionario.getContrato());
							System.out.println("Cep: "+funcionario.getCep());
							System.out.println("Numero da casa: "+funcionario.getNumero_casa());
							System.out.println("Telefone: "+funcionario.getTelefone());
							System.out.println("Email: "+funcionario.getEmail());
						}
					break;
					case 4:
						System.out.println("Buscando o aluguel...");
						System.out.println("Digite o id do aluguel: ");
						idaux = teclado.nextInt();
						aluguel = aDAO.buscar(idaux);
						if(aluguel == null) {
							System.out.println("Aluguel não encontrado");
						}else {
							System.out.println("Aluguel encontrado: ");
							System.out.println("Id: "+aluguel.getId());
							cliente = aluguel.getFk_cliente();
							System.out.println("Cpf cliente: "+cliente.getCpf());
							funcionario = aluguel.getFk_funcionario();
							System.out.println("Cpf funcionario: "+funcionario.getCpf());
							itens = aluguel.getFk_item();
							System.out.println("Id item:" + itens.get(0).getId());
							System.out.println("Data de saida: "+aluguel.getData_saida());
							System.out.println("Data de entrega: "+aluguel.getData_devolucao());
							System.out.println("Quantidade: "+aluguel.getQuantidade_itens());
							System.out.println("Valor total: "+aluguel.getValor_total());
							System.out.println("Ajuste: "+aluguel.getAjuste());
							System.out.println("Observação: "+aluguel.getObservacao());
						}
					break;
					default:
					}
					
				break;
				case 2: 
					System.out.println("\nOque Voce deseja Incluir?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Digite o tipo de item: ");
						tipoaux = teclado.nextLine();
						Item = iDAO.buscartipo(tipoaux);
						if(Item == null) {
							Item = new Itens();
							Item.setTipo(tipoaux);
							
							System.out.println("Digite o tamanho");
							Item.setTamanho(teclado.nextLine());
							
							System.out.println("O item precisa de manuteção?");
							Item.setManutencao(teclado.nextLine());
							
							System.out.println("Qual o valor do item?");
							Item.setValor(teclado.nextFloat());
							
							iDAO.incluir(Item);
						}else {
							System.out.println("Itens já cadastrado no estoque");
						}
					break;
					case 2:
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							cliente = new Cliente();
							cliente.setCpf(cpfaux);
							System.out.println("Digite o nome do novo cliente: ");
							cliente.setNome(teclado.nextLine());
							
							System.out.println("Digite o cep do novo cliente: ");
							cliente.setCep(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o numero da casa do novo cliente: ");
							cliente.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o telefone do novo cliente: ");
							cliente.setTelefone(teclado.nextLine());
							
							System.out.println("Digite o Email do novo cliente: ");
							cliente.setEmail(teclado.nextLine());
							
							clDAO.incluir(cliente);
						}else {
							System.out.println("Cliente não encontrado");
						}
					break;
					case 3:
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							funcionario = new Funcionario();
							funcionario.setCpf(cpfaux);
							System.out.println("Digite o nome do novo funcionario: ");
							funcionario.setNome(teclado.nextLine());
							
							System.out.println("Digite o cep do novo funcionario: ");
							funcionario.setCep(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o numero da casa do novo funcionario: ");
							funcionario.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							
							System.out.println("Digite o telefone do novo funcionario: ");
							funcionario.setTelefone(teclado.nextLine());
							
							System.out.println("Digite o Email do novo funcionario: ");
							funcionario.setEmail(teclado.nextLine());
							
							System.out.println("Digite o contrato do novo funcionario: ");
							funcionario.setContrato(teclado.nextLine());
							
							System.out.println("Digite o numero da carteira de trabalho do novo funcionario: ");
							funcionario.setCarteira_trab(teclado.nextLine());
							
							fDAO.incluir(funcionario);
						}else {
							System.out.println("Funcionario já cadastrado");
						}
					break;
					default:
					}
				break;
				
				case 3:
					System.out.println("\nOque Voce Deseja Alterar?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Voltar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Buscando Itens...");
						System.out.println("Digite o id do item: ");
						idaux = teclado.nextInt();
						teclado.nextLine();
						Item = iDAO.buscar(idaux);
						if(Item == null) {
							System.out.println("Itens não encontrados no estoque");
						}else {
							System.out.println("Item encontrado");
							System.out.println("Tipo: "+Item.getTipo());
							System.out.println("Id: "+Item.getId());
							System.out.println("Tamanho: "+Item.getTamanho());
							System.out.println("Manutencao: "+Item.getManutencao());
							System.out.println("Valor: "+Item.getValor());
							
							System.out.println("Digite novo item: ");
							Item.setTipo(teclado.nextLine());
							System.out.println("Digite novo tamanho: ");
							Item.setTamanho(teclado.nextLine());
							System.out.println("Digite novo Manutenção: ");
							Item.setManutencao(teclado.nextLine());
							System.out.println("digite o novo valor: ");
							Item.setValor(teclado.nextFloat());
							iDAO.Alterar(Item);
							}
					break;
					case 2:
						System.out.println("Buscando Cliente...");
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							cpfaux = cliente.getCpf();
							System.out.println("Cliente encontrado");
							System.out.println("Nome: "+cliente.getNome());
							System.out.println("Cpf: "+cliente.getCpf());
							System.out.println("Cep: "+cliente.getCep());
							System.out.println("Numero da casa: "+cliente.getNumero_casa());
							System.out.println("Telefone: "+cliente.getTelefone());
							System.out.println("Email: "+cliente.getEmail());
							System.out.println("Digite novo nome: ");
							cliente.setNome(teclado.nextLine());
							System.out.println("Digite novo CPF: ");
							cliente.setCpf(teclado.nextLine());
							System.out.println("Digite novo CEP: ");
							cliente.setCep(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Numero da casa: ");
							cliente.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Telefone: ");
							cliente.setTelefone(teclado.nextLine());
							System.out.println("Digite novo Email: ");
							cliente.setEmail(teclado.nextLine());
							clDAO.Alterar(cliente,cpfaux);
						}
					break;
					case 3:
						System.out.println("Buscando Funcionário...");
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionário não encontrado");
						}else {
							cpfaux = funcionario.getCpf();
							System.out.println("Funcionário encontrado");
							System.out.println("Nome: "+funcionario.getNome());
							System.out.println("Cpf: "+funcionario.getCpf());
							System.out.println("Cpf: "+funcionario.getCarteira_trab());
							System.out.println("Cpf: "+funcionario.getContrato());
							System.out.println("Cep: "+funcionario.getCep());
							System.out.println("Numero da casa: "+funcionario.getNumero_casa());
							System.out.println("Telefone: "+funcionario.getTelefone());
							System.out.println("Email: "+funcionario.getEmail());
							System.out.println("Digite novo nome: ");
							funcionario.setNome(teclado.nextLine());
							System.out.println("Digite novo CPF: ");
							funcionario.setCpf(teclado.nextLine());
							System.out.println("Digite novo Carteira de Trabalho: ");
							funcionario.setCarteira_trab(teclado.nextLine());
							System.out.println("Digite novo Contrato: ");
							funcionario.setContrato(teclado.nextLine());
							System.out.println("Digite novo CEP: ");
							funcionario.setCep(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Numero da casa: ");
							funcionario.setNumero_casa(teclado.nextInt());
							teclado.nextLine();
							System.out.println("Digite novo Telefone: ");
							funcionario.setTelefone(teclado.nextLine());
							System.out.println("Digite novo Email: ");
							funcionario.setEmail(teclado.nextLine());
							fDAO.Alterar(funcionario, cpfaux);														
						}
					break;
					default:
					}		
				break;			
				case 4:
					System.out.println("\nOque Voce deseja excluir?");
					System.out.println("1 - Item");
					System.out.println("2 - Cliente");
					System.out.println("3 - Funcionario");
					System.out.println("4 - Voltar");

					op2 = teclado.nextInt();
					teclado.nextLine();
					switch(op2) {
					case 1:
						System.out.println("Digite o tipo de item: ");
						idaux = teclado.nextInt();
						Item = iDAO.buscar(idaux);
						if(Item == null) {
							System.out.println("Itens não encontrado");
						}else {
							iDAO.Deletar(idaux);
						}
					break;
					case 2:
						System.out.println("Digite o cpf do cliente: ");
						cpfaux = teclado.nextLine();
						cliente = clDAO.buscar(cpfaux);
						if(cliente == null) {
							System.out.println("Cliente não encontrado");
						}else {
							clDAO.Deletar(cpfaux);						
						}
					break;
					case 3:
						System.out.println("Digite o cpf do Funcionário: ");
						cpfaux = teclado.nextLine();
						funcionario = fDAO.buscar(cpfaux);
						if(funcionario == null) {
							System.out.println("Funcionario já cadastrado");
						}else {
							fDAO.Deletar(cpfaux);
						}
					break;
					default:
					}
				break;
				
				case 6:
					System.out.println("\nCadastrar um novo aluguel");
					System.out.println("\nDigite o CPF do Cliente");
					cpfaux = teclado.nextLine();
					
					cliente = clDAO.buscar(cpfaux);
					if(cliente == null) {
						System.out.println("Cliente não encontrado, por favor cadastrar cliente");
					}else {
						System.out.println("\nDigite o CPF do Funcionario");
						funcionario = fDAO.buscar(teclado.nextLine());
						if(funcionario == null) {
							System.out.println("Funcionario não encontrado, por favor cadastrar Funcionario");
						}else {
							aluguel = new Aluguel();
							System.out.println("\nDigite a data de saída");
							aluguel.setData_saida(teclado.nextLine());
							System.out.println("\nDigite a forma de pagamento");
							aluguel.setForma_pagamento(teclado.nextLine());
							System.out.println("\nDigite a Quantidade de itens");
							aluguel.setQuantidade_itens(teclado.nextInt());
							teclado.nextLine();
							System.out.println("\nDigite a data de devolução");
							aluguel.setData_devolucao(teclado.nextLine());
							System.out.println("\nDigite o tipo de ajuste");
							aluguel.setAjuste(teclado.nextLine());
							System.out.println("\nObservações");
							aluguel.setObservacao(teclado.nextLine());	
							aDAO.incluir(aluguel, cliente, funcionario);
							do {
								System.out.println("\nDigite o id Item a ser alugado");
								Item = iDAO.buscar(teclado.nextInt());
								teclado.nextLine();
								if(Item == null) {
									System.out.println("Item não encontrado!");
								}else {
									iaDAO.incluir(Item, aluguel);
									aluguel.setValor_total(Item.getValor());
									System.out.println("Deseja adicionar outro item? Sim-1 ou Nao-0?");
									contaux = teclado.nextInt();
									teclado.nextLine();
									if(contaux == 1) {
										continuar = true;
									}else {
										continuar = false;
									}
								}
							}while(continuar = true);
						}
					break;
				}
			}
		}while(op!=7);
     }
}