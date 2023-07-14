package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orders = new ArrayList<>();
	
	SimpleDateFormat sdfSummary = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	
	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrder() {
		return orders;
	}
	
	public void addItem (OrderItem order) {
		orders.add(order);
	}
	
	public void removeItem (OrderItem order) {
		orders.remove(order);
	}
	
	public Double total() {
		double total = 0;
		for (OrderItem o : orders) {
			total += o.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdfSummary.format(moment) + "\n");
		sb.append(status + "\n");
		
		return sb.toString();
		}
	
	
}
