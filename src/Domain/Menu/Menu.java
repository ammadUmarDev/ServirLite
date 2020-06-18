package Domain.Menu;

import java.util.ArrayList;

public class Menu {
	ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;

	}

	public void addItem(MenuItem newItem){
		menuItemList.add(newItem);
	}

	public void removeItem(MenuItem newItem){
		menuItemList.remove(newItem);
	}

	public ArrayList<MenuItem> getMenu(){
		return this.menuItemList;
	}

}
