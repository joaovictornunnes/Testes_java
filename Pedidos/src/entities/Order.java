package entities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import entities.enums.OrderStatus;

public class Order {
	private Date moment = new Date();
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}
	
	public Order() {
		
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Double total() {
		Double subTotal = 0.0;
		
		for(OrderItem o: items) {
			subTotal += o.subTotal();
		}
		return subTotal;
	}
	
public String toString(int i) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(items.get(i).getProduct().getName() + ", ");
		sb.append(items.get(i).getProduct().getPrice() + ", ");
		sb.append("Quantity: " + items.get(i).getQuantity()+ ", ");
		sb.append("Subtotal: $" + items.get(i).subTotal());
		
		return sb.toString();
	}
}
