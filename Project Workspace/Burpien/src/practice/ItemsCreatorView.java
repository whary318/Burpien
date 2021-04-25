package practice;

import Application.controller.Controller;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ItemsCreatorView extends Application {

	private  VBox basketView;
	private  HBox hbox1,hbox2;
	private  Basket currentBasket;
	private  Label infollbl,typelbl,namelbl;
	private  Button itembtnbtn, infobtn, createbtn;
	private  ListView<String> listViewOfItems;
	private ChoiceBox cb1;

	@Override
	public void start(Stage primaryStage){


			infollbl = new Label("Items List and Information");
			itembtnbtn = new Button("Items");
			infobtn = new Button("Info");
			typelbl = new Label("Type: ");
			namelbl= new Label("Name: ");
			createbtn = new Button("Create");






		// layout of basket
			basketView = new VBox(20);
			basketView.setPadding(new Insets(20));
			//basketView.setAlignment(Pos.TOP_RIGHT);
			Region spacer = new Region();
			VBox.setVgrow(spacer, Priority.ALWAYS);


			hbox1 = new HBox();
			HBox.setMargin(infollbl, new Insets(10));
			HBox.setMargin(itembtnbtn, new Insets(5));
			HBox.setMargin(infobtn, new Insets(5));
			hbox1.getChildren().addAll(itembtnbtn, infobtn);



			cb1 = new ChoiceBox();
			cb1.setItems(FXCollections.observableArrayList(
				"Category",
				new Separator(), "Item"));



			hbox2 = new HBox();
			HBox.setMargin(typelbl, new Insets(10));
			HBox.setMargin(cb1, new Insets(10));

			hbox2.getChildren().addAll(typelbl, cb1);




			basketView.getChildren().addAll(infollbl,hbox1,hbox2,namelbl,spacer,createbtn);

			Scene scene = new Scene(basketView, 1050, 700);
			primaryStage.setMinWidth(720);
			primaryStage.setMinHeight(500);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Burpien - Settings Page");
			primaryStage.show();

		}

	}





