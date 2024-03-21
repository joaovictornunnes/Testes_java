package dominio;

public class Pedido {
	private int hora;
	private String endEntrega;
	private int qtdBotijoes;
	private float totalCompra;
	private int horaEntrega;
	private String cartaoCredito;
	private String status;
	private int codigoPedido;
	
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getHora() {
		return hora;
	}
	public void setEndEntrega(String endEntrega) {
		this.endEntrega =  endEntrega;
	}
	public String getEndEntrega() {
		return endEntrega;
	}
	public int getQtdBotijoes() {
		return qtdBotijoes;
	}
	public void setQtdBotijoes(int qtdBotijoes) {
		this.qtdBotijoes = qtdBotijoes;
	}
	public void calcularTotalCompra() {
		totalCompra = qtdBotijoes*60; // cada botij�o custa 60 reais
	}
	public float getTotalCompra() {
		return totalCompra;
	}
	public void calcularHoraEntrega() {
		horaEntrega = hora + 6;
		if(horaEntrega>24) {
			horaEntrega = horaEntrega-24;
		}
	}
	public int getHoraEntrega() {
		return horaEntrega;
	}
	public String getCartaoCredito() {
		return cartaoCredito;
	}
	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	public void confirmarPedido() {
		if(status == "confirmado") {
			status = "entregue";
		}else {
		status = "confirmado";
		}
	}
	public void CalcularCodPedido(int codigo) {
		codigoPedido = codigo;
	}
	public int getCodigo() {
			return codigoPedido;
	}
}






