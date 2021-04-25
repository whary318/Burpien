package Application.controller;

import java.util.ArrayList;

import Application.modules.*;
import Application.views.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Controller extends Application {

	public final static double TAX_RATE = 0.06;
	private static ArrayList<User> users;
	private static ArrayList<Category> categories;

	private static ArrayList<Basket> baskets;
	private static User currentUser;

	private static Stage stage;
	
	//start up the application
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
    	specialSetup();
		stage = primaryStage;
		newStart();
    }
    
    //setup - temporary - until database is made
    private void specialSetup() {
    	//initialization of needed variables
		baskets = new ArrayList<Basket>();

    	//add users
    	users = new ArrayList<User>();
    	users.add(new User("RootUser", 0000, Privilage.Root));
    	users.add(new User("Supervisor", 0001, Privilage.SuperVisor));
    	users.add(new User("Wael A.", 1234, Privilage.Employee));
    	users.add(new User("Alan A.", 1235, Privilage.Employee));
    	
    	//add some dummy categories
    	categories = new ArrayList<Category>();
    	categories.add(new Category("Sandwichs"));
    	categories.add(new Category("Drinks"));
    	categories.add(new Category("Deals"));
    	
    	//add some dummy items   
		categories.get(0).additem("Full Spicy Sub", 8.99, PriceType.Unit, 00012);
		categories.get(0).additem("Half Spicy Sub", 4.99, PriceType.Unit, 00013);
		categories.get(0).additem("Full Mild Sub", 8.99, PriceType.Unit, 00015);
		categories.get(0).additem("Half Mild Sub", 4.99, PriceType.Unit, 00016);
		categories.get(0).additem("Full Vege Sub", 7.99, PriceType.Unit, 00020);
		categories.get(0).additem("Half Vege Sub", 3.99, PriceType.Unit, 00021);
		categories.get(0).additem("Full SP Vege Sub", 7.99, PriceType.Unit, 00023);
		categories.get(0).additem("Half SP Vege Sub", 3.99, PriceType.Unit, 00024);

		categories.get(0).additem("Full Spicy Sub", 8.99, PriceType.Unit, 00012);
		categories.get(0).additem("Half Spicy Sub", 4.99, PriceType.Unit, 00013);
		categories.get(0).additem("Full Mild Sub", 8.99, PriceType.Unit, 00015);
		categories.get(0).additem("Half Mild Sub", 4.99, PriceType.Unit, 00016);
		categories.get(0).additem("Full Vege Sub", 7.99, PriceType.Unit, 00020);
		categories.get(0).additem("Half Vege Sub", 3.99, PriceType.Unit, 00021);
		categories.get(0).additem("Full SP Vege Sub", 7.99, PriceType.Unit, 00023);
		categories.get(0).additem("Half SP Vege Sub", 3.99, PriceType.Unit, 00024);

		categories.get(0).additem("Full Spicy Sub", 8.99, PriceType.Unit, 00012);
		categories.get(0).additem("Half Spicy Sub", 4.99, PriceType.Unit, 00013);
		categories.get(0).additem("Full Mild Sub", 8.99, PriceType.Unit, 00015);
		categories.get(0).additem("Half Mild Sub", 4.99, PriceType.Unit, 00016);
		categories.get(0).additem("Full Vege Sub", 7.99, PriceType.Unit, 00020);
		categories.get(0).additem("Half Vege Sub", 3.99, PriceType.Unit, 00021);
		categories.get(0).additem("Full SP Vege Sub", 7.99, PriceType.Unit, 00023);
		categories.get(0).additem("Half SP Vege Sub", 3.99, PriceType.Unit, 00024);
    	
    	categories.get(1).additem("Large Spicy Soup", 16.99, PriceType.Unit, 00212);
    	categories.get(1).additem("Medium Spicy Soup", 10.99, PriceType.Unit, 00213);
    	categories.get(1).additem("Small Spicy Soup", 5.99, PriceType.Unit, 00215);
    	categories.get(1).additem("Large Mild Soup", 12.98, PriceType.Unit, 00216);
    	categories.get(1).additem("Medium Vege Soup", 7.99, PriceType.Unit, 00220);
    	categories.get(1).additem("Small Vege Soup", 5.00, PriceType.Unit, 00221);

    	categories.get(2).additem("Large Spicy Soup\nHalf Spicy Sub", 18.99, PriceType.Unit, 00312);
    	
    	
    }
    
    //handlers
    public static void handleEventsFromMainPage(ActionEvent e) {
		//handle events
	} // for later versions
	public static void switchToSettingsPage(){
		SettingsPageView.start(stage);
	}
	public static void switchToMainPage(){
		MainPageView.start(stage);
	}
	public static void logout() {
		Controller.setCurrentUser(null);
		newStart();
	}
	private static void newStart() {
		new LoginPage(stage);
	}

    //getters
	public static ArrayList<Category> getCategories() {
		return categories;
	}
	public static ArrayList<User> getUsers() {
		return users;
	}
	public static User getCurrentUser() {
		return currentUser;
	}
	public static ArrayList<Basket> getBaskets() {
		return baskets;
	}
	//setters	
	public static void setCurrentUser(User currentUser) {
		Controller.currentUser = currentUser;
	}
	
}
