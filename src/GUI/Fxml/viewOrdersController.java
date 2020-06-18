package GUI.Fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Menu.Menu;
import Domain.Order.OrderList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class viewOrdersController implements Initializable {

	Menu menu = new Menu();
	OrderList orders = new OrderList();
	@FXML
	public ListView<String> orderList = new ListView<String>();
	public ObservableList<String> orderArray= FXCollections.observableArrayList("154 - December 1,2019","155 - December 1,2019","156 - December 1,2019","157 - December 1,2019","158 - December 1,2019","159 - December 1,2019","160 - December 1,2019","161 - December 1,2019","162 - December 1,2019","163 - December 1,2019","164 - December 1,2019","165 - December 1,2019","166 - December 1,2019");


	public void dataFromPrevCont(Menu menu, OrderList orders) throws IOException{

	}

	//data from main and other controllers
	public void dataToNextCont(Menu menu, OrderList orders) throws IOException{
		this.menu = menu;
		this.orders = orders;
		System.out.println("in view order");orders.printList();




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
		public void initialize(URL location, ResourceBundle resources) {
			for (int i=0;i<orders.getOrderList().size();i++)
				orderArray.add(orders.getOrderListID().toString()+" - "+orders.getDate());
				orderList.setItems(orderArray);

		}



}
