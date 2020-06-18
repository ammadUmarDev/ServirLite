package GUI.Fxml;

import java.io.IOException;

import Domain.Menu.Menu;
import Domain.Order.OrderList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class menuController {

	Menu menu = new Menu();
	OrderList orders = new OrderList();

	public void dataFromPrevCont(Menu menu, OrderList orders) throws IOException{

	}

	//data from main and other controllers
	public void dataToNextCont(Menu menu, OrderList orders) throws IOException{
		this.menu = menu;
		this.orders = orders;
	}

	//side bar button functions---------------------------------------------------------------------------------------
	public void changeHome(ActionEvent event) throws IOException{

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
		dashboardController dashBoardCont = loader.<dashboardController>getController();
		dashBoardCont.dataToNextCont(this.menu , this.orders);
	}

	public void changeScreenOrder(ActionEvent event) throws IOException{

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
		System.out.println("in event");this.orders.printList();
		newOrderController newOrderCont = new newOrderController();
		newOrderCont.dataToNextCont(menu, orders);

	}

	public void changeScreenMenu(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
		menuController menuCont = new menuController();
		menuCont.dataToNextCont(menu, orders);
	}

	public void changeScreenEmployee(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("employee.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();

	}

	public void changeScreenInventory(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("inventory.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
	}


	public void changeScreenViewReport(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("reportArchive.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
	}
//side bar button functions END-----------------------------------------------------------------------------------

//select options button functions --------------------------------------------------------------------------------------
	public void changeScreenViewMenu(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("viewMenu.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
	}

	public void changeScreenEditMenu(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("editMenu.fxml"));
		Region root = (Region) loader.load();
		Scene scene = new Scene(root);
		window.setTitle("Servir Lite");
		window.setScene(scene);
		window.show();
	}
//select options button functions END-----------------------------------------------------------------------------------


}
