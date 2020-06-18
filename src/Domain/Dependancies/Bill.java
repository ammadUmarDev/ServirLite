package Domain.Dependancies;

import java.util.ArrayList;

import Domain.Menu.MenuItem;

public class Bill {
	int billID;
	String date;
	float totalCostITax;
	float totalCostETax;
	ArrayList<MenuItem> billItems = new ArrayList<MenuItem>();
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getTotalCostITax() {
		return totalCostITax;
	}
	public void setTotalCostITax(float totalCostITax) {
		this.totalCostITax = totalCostITax;
	}
	public float getTotalCostETax() {
		return totalCostETax;
	}
	public void setTotalCostETax(float totalCostETax) {
		this.totalCostETax = totalCostETax;
	}

	public void addItem(MenuItem newItem){
		billItems.add(newItem);
	}

	public void removeItem(MenuItem newItem){
		billItems.remove(newItem);
	}

	public ArrayList<MenuItem> getMenu(){
		return this.billItems;
	}

	public void generateBill(float salesTax){
		float totalCostITaxTemp=0;
		float totalCostETaxTemp=0;
		for (int i=0;i<this.billItems.size();i++){
			totalCostETaxTemp+=this.billItems.get(i).getPrice();
		}
		totalCostITaxTemp=totalCostETaxTemp*salesTax+totalCostETaxTemp;
		this.totalCostETax=totalCostETaxTemp;
		this.totalCostITax=totalCostITaxTemp;
	}




}
