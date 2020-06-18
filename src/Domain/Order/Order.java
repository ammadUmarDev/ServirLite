package Domain.Order;

public class Order {
	String date;
	int orderId;

	public Order(int o, String d){
		this.date = d;
		this.orderId = o;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




}
