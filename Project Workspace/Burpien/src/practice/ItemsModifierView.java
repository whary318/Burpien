package practice;

import Application.modules.Basket;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ItemsModifierView extends Application {


	private  VBox basketView;
	private  HBox hbox1,hbox2,hbox3,hbox4,hbox5;
	private  Label infollbl,typelbl,namelbl,catlbl,prclbl, bylbl, barcodelbl, priceshowlbl;
	private  Button itembtnbtn, infobtn, createbtn;
	private ChoiceBox cb1,cb2,cb3;



	@Override
	public void start(Stage primaryStage){

		infollbl = new Label("Items List and Information");
		itembtnbtn = new Button("Items");
		infobtn = new Button("Info");
		typelbl = new Label("Type: ");
		namelbl= new Label("Name: ");
		createbtn = new Button("Create");

		catlbl = new Label("Category: ");
		prclbl = new Label("Price: ");
		bylbl = new Label("By: ");
		barcodelbl = new Label("Barcode ID: ");

		priceshowlbl = new Label("$5.99");



		basketView = new VBox(20);
		basketView.setPadding(new Insets(20));
		//basketView.setAlignment(Pos.TOP_RIGHT);
		Region spacer = new Region();
		VBox.setVgrow(spacer, Priority.ALWAYS);


		hbox1 = new HBox();
		HBox.setMargin(infollbl, new Insets(5));
		HBox.setMargin(itembtnbtn, new Insets(5));
		HBox.setMargin(infobtn, new Insets(5));
		hbox1.getChildren().addAll(itembtnbtn, infobtn);



		cb1 = new ChoiceBox();
		cb1.setItems(FXCollections.observableArrayList(
				"Category",
				new Separator(), "Item"));



		hbox2 = new HBox();
		HBox.setMargin(typelbl, new Insets(5));
		HBox.setMargin(cb1, new Insets(5));

		hbox2.getChildren().addAll(typelbl, cb1);





		cb2 = new ChoiceBox();
		cb2.setItems(FXCollections.observableArrayList(
				"Cat 1",
				new Separator(), "Cat 2",
				new Separator(), "Etc"));


		hbox3 = new HBox();
		HBox.setMargin(catlbl, new Insets(5));
		HBox.setMargin(cb2, new Insets(5));

		hbox3.getChildren().addAll(catlbl, cb2);




		cb3 = new ChoiceBox();
		cb3.setItems(FXCollections.observableArrayList(
				"Unit",
				new Separator(), "Weight (1 lb)"));


		hbox4 = new HBox();
		HBox.setMargin(prclbl, new Insets(5));
		HBox.setMargin(priceshowlbl, new Insets(5));
		HBox.setMargin(bylbl, new Insets(5));
		HBox.setMargin(cb3, new Insets(5));

		hbox4.getChildren().addAll(prclbl, priceshowlbl,bylbl, cb3);



		hbox5 = new HBox();
		HBox.setMargin(barcodelbl, new Insets(5));
		hbox5.getChildren().addAll(barcodelbl);

		basketView.getChildren().addAll(infollbl,hbox1,hbox2,namelbl,hbox3,hbox4,hbox5,spacer,createbtn);

		Scene scene = new Scene(basketView, 1050, 700);
		primaryStage.setMinWidth(720);
		primaryStage.setMinHeight(500);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Burpien - Settings Page");
		primaryStage.show();
	}
	//private static void handleButtonClicks(ActionEvent e, Stage stage) {
		//handle events
	}


