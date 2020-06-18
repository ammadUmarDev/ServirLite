package Domain.Order;

import java.util.ArrayList;

public class OrderList {
	Integer orderListID;
	ArrayList<Order> orderList = new ArrayList<Order>();
	String date;
	public Integer getOrderListID() {
		return orderListID;
	}
	public void setOrderListID(Integer orderListID) {
		this.orderListID = orderListID;
	}
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	public void addItem(Order newItem){
		orderList.add(newItem);
	}

	public void removeItem(Order newItem){
		orderList.remove(newItem);
	}

	public ArrayList<Order> getOrders(){
		return this.orderList;
	}

	public void printList(){
		for (int i=0; i<this.orderList.size();i++)
			System.out.println(this.orderList.get(i).orderId);
	}


}
