package GUI.Fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Dependancies.Bill;
import Domain.Menu.Menu;
import Domain.Order.OrderList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class addOrderController implements Initializable{

	Menu menu = new Menu();
	OrderList orders = new OrderList();

	@FXML
	private ListView<String> miniMenu;
	ObservableList<String> Menudata = FXCollections.observableArrayList("Monster Shake - 1100/-","Ronaldo Tikka Burger - 1300/-","Messi Tikka Burger - 1200/-","Cheese Kebab Shahi - 990/-");
	private ListView<String> miniBill;
	ObservableList<String> Billdata = FXCollections.observableArrayList("Complimentery Water 5ml - 0/-");


	public void dataFromPrevCont(Menu menu, OrderList orders) throws IOException{

	}

	//data from main and other controllers
	public void dataToNextCont(Menu menu, OrderList orders) throws IOException{
		this.menu = menu;
		this.orders = orders;
		System.out.println("in add order");orders.printList();

		Bill newBill = new Bill();

		miniMenu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        // Your action here
		        System.out.println("Selected item: " + newValue);
		        float salesTax = (float) 15.5;
		        newBill.generateBill(salesTax);
		    }
		});

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

			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
			miniMenu.setItems(Menudata);



}}
