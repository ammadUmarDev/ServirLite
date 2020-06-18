package GUI.Fxml;

import Domain.Menu.Menu;
import Domain.Order.Order;
import Domain.Order.OrderList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;




public class Main extends Application {

	//Globally save data:
	Menu menu = new Menu();
	OrderList orders = new OrderList();


	public void start(Stage primaryStage) {

		Order tempOrder = new Order(1, "December 2,2019");
		orders.addItem(tempOrder);
		System.out.println("in main");orders.printList();


		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
			Region root = (Region) loader.load();

			Scene scene = new Scene(root);
			primaryStage.setTitle("Servir Lite");
			primaryStage.setScene(scene);
			primaryStage.show();

			dashboardController dashBoardCont = loader.<dashboardController>getController();
			dashBoardCont.dataToNextCont(this.menu , this.orders);

			//passing data to controller
			//dashboardController dashBoardCont = new dashboardController();
			//dashBoardCont.dataToNextCont(menu, orders);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}


}
