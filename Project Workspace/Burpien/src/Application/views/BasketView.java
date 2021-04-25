package Application.views;

import Application.controller.Controller;
import Application.modules.Basket;
import Application.modules.Item;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class BasketView {
	
	private static VBox basketView;
	private static HBox hbox;
	private static ListView<String> listViewOfItems;
	private static ArrayList<Basket> baskets;
	private static Basket currentBasket;
	private static Label basketLabel, subTotalLabel, taxLabel, totalLabel;
	private static Button deletebtn, paybtn;
	
	public BasketView() {
	    //initialization of nodes
		listViewOfItems = new ListView<String>();
        listViewOfItems.setPrefHeight(2000); //find a better way to do this.

		basketLabel = new Label("Basket");
        basketLabel.setFont(new Font(30));
        subTotalLabel = new Label("Subtotal:‬");
        taxLabel = new Label("Tax:‬");
        totalLabel = new Label("Total:");

        deletebtn = new Button("Del");
        paybtn = new Button("Pay");
        paybtn.setMinSize(250, 50);

        deletebtn.setOnAction(e -> setOnActionsForButtons(e));
        paybtn.setOnAction(e -> setOnActionsForButtons(e));

        baskets = Controller.getBaskets();
        currentBasket = null;
        newOrderToBasket();
        //--------------------------------


       // layout of basket
        basketView = new VBox(20);
        basketView.setPadding(new Insets(20));
        //basketView.setAlignment(Pos.TOP_RIGHT);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        hbox = new HBox();
        HBox.setMargin(basketLabel, new Insets(10));
        HBox.setMargin(deletebtn, new Insets(10));
        hbox.getChildren().addAll(basketLabel, deletebtn);

        basketView.getChildren().addAll(hbox,listViewOfItems,subTotalLabel,taxLabel, totalLabel, paybtn);
        //------------------------------
		
	}

	private static void setOnActionsForButtons(ActionEvent e) {
	    if(e.getSource() == paybtn){
            currentBasket.finalizeOrder();
        } else {
            removeItem();
        }
    }

    public static void addItem(Item item) {
	    if(currentBasket.isOrderEditable()) {
            currentBasket.addItemToOrder(item);
            refreshBasket();
        }

    }
    public static void removeItem(/*Item item*/) {
        if(currentBasket.isOrderEditable()) {
            if (listViewOfItems.getSelectionModel().getSelectedIndex() != -1) {
                currentBasket.removeItemInOrder(listViewOfItems.getSelectionModel().getSelectedIndex());
                listViewOfItems.getItems().remove(listViewOfItems.getSelectionModel().getSelectedItem());
                listViewOfItems.getSelectionModel().clearSelection();
            }
            refreshBasket();
        }
    }
	
	public VBox getBasketView() {
		return basketView;
	}

	public static void nextBasket() {
        int i = baskets.indexOf(currentBasket);
        if (i < baskets.size() - 1) {
            currentBasket = baskets.get(i + 1);
            refreshBasket();
            System.out.println("next Order");
        }
    }
	public static void prevBasket() {
        int i = baskets.indexOf(currentBasket);
        if (0 < i) {
            currentBasket = baskets.get(i - 1);
            refreshBasket();
            System.out.println("Prev Order");
        }
    }
	public static void newOrderToBasket(){
        baskets.add(new Basket(Controller.getCurrentUser()));
        currentBasket = baskets.get(baskets.size() - 1);
        refreshBasket();
        System.out.println("New Order Made");
    }
	public static void cancelCurrentOrder(){ // there is a bug here that would couse a "payed for" order to be deleted. -- fix it
	    if (!baskets.isEmpty()){
	        if(currentBasket.isOrderEditable()) {
                baskets.remove(currentBasket);
                if (!baskets.isEmpty()) {
                    currentBasket = baskets.get(baskets.size() - 1);
                    refreshBasket();
                } else
                    newOrderToBasket();
                System.out.println("Order Canceled");
            }
        }

    }

	private static void refreshBasket() {
        listViewOfItems.getItems().clear();
        for(Item item: currentBasket.getItemsInOrder())
            listViewOfItems.getItems().add(item.getNameOfItem() + "                             " + item.getPrice());

        subTotalLabel.setText(String.format("%-32s $%.2f", "Subtotal:",currentBasket.getSubTotal()));
        taxLabel.setText(String.format("%-32s $%.2f", "Tax:", currentBasket.getTax()));
        totalLabel.setText(String.format("%-32s $%.2f", "Total:", currentBasket.getTotal()));


    }



}
