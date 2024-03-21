package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <OrderItem> itemsList;
		
		System.out.print("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birthdate (DD/MM/YYYY): ");
		Date clientBirthdate = sdf.parse(sc.next());
		Client client = new Client(clientName, clientEmail, clientBirthdate);
		
		System.out.println("Enter order data: ");
		sc.nextLine();
		System.out.println("Status: ");
		String statusOrder = sc.nextLine();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		Order order = new Order(OrderStatus.valueOf(statusOrder), client);

		for (int i=1; i<=n; i++) {
			System.out.println("Enter product #" + i + " data:");
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityOrderItem = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantityOrderItem, product);
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + " " + order.getClient().getAniersário() + " - " + order.getClient().getEmail());
		System.out.println("Order items: ");
		for(int i=0; i < n; i++) {
			
			System.out.println(order.toString(i));

		}
		System.out.println(order.total());

		sc.close();
	}

}
