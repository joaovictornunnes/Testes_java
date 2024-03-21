package entities;

public class OrderItem {

	private int quantity;
	private Double price;
	private Product product;
	
	public OrderItem(int quantity, Product Product) {
		this.quantity = quantity;
		this.product = Product;
	}
	
	public OrderItem() {
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		price = quantity * product.getPrice();
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setItem(Product item) {
		this.product = item;
	}
	
}
