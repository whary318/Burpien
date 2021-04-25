package Application.views;


import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainPageView {
	static VBox topAndBottomOfMain;
	static HBox bottomRightAndLeftSide;

	public static void start(Stage primaryStage) {
		// The general layout of the program
		topAndBottomOfMain = new VBox();
		bottomRightAndLeftSide = new HBox();
		//-----------------------------------
		
		
		// the elements of the page
		BorderPane itemsAndCatview = new CatAndItemsView().getItemsAndCatView();
		VBox basketView = new BasketView().getBasketView();
		HBox menubar = new MainPageMenubarView().getMenuBar();
		//-----------------------------------
		

		// add all together
		Separator separatorTopButton = new Separator();
		Separator separatorButtomParts = new Separator();
		separatorButtomParts.setOrientation(Orientation.VERTICAL);
		
		HBox.setHgrow(itemsAndCatview, Priority.ALWAYS);
		
		bottomRightAndLeftSide.getChildren().addAll(itemsAndCatview, separatorButtomParts, basketView);
		topAndBottomOfMain.getChildren().addAll(menubar, separatorTopButton, bottomRightAndLeftSide);
		//----------------------------------

		
		// Display it all
		Scene scene = new Scene(topAndBottomOfMain, 1050, 700);
		primaryStage.setMinWidth(720);
		primaryStage.setMinHeight(500);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Burpien - Main Page");
		primaryStage.show();
		//----------------------------------
	}
}
