package Application.views;

import java.util.ArrayList;

import Application.modules.*;

import Application.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class CatAndItemsView {
	 
	private BorderPane itemsAndCatView;
	private ArrayList<Button> catButtons;
	private ArrayList<Button> itemButtons;
	private ArrayList<Category> categories;
	private int indexOfCurrentCategory;
	private HBox cats;
	private FlowPane items;
	
	public CatAndItemsView() {
		itemsAndCatView = new BorderPane();
		cats = new HBox(10);
		items = new FlowPane();
        items.setPadding(new Insets(15));
        items.setHgap(15);
        items.setVgap(10);

		initializeCategoriesButtons();
	}
	
	private void initializeCategoriesButtons() {
		categories = Controller.getCategories();
		catButtons = new ArrayList<Button>();

		for(Category cat: categories) {
			catButtons.add(new Button(cat.getName()));
			catButtons.get(catButtons.size() -1).setOnAction(e -> handleButtonActions(e));
			cats.getChildren().add(catButtons.get(catButtons.size() - 1));
		}

		itemsAndCatView.setTop(cats);
		indexOfCurrentCategory = 0;
		loadItemButtons(indexOfCurrentCategory);

	}
	private void loadItemButtons(int indexOfCategory) {
		itemButtons = new ArrayList<Button>();

		items = new FlowPane();
		items.setPadding(new Insets(15));
		items.setHgap(15);
		items.setVgap(10);

		for(Item item: categories.get(indexOfCategory).getItems()) {
			itemButtons.add(new Button(item.toString()));
			itemButtons.get(itemButtons.size() -1).setOnAction(e -> handleButtonActions(e));
			items.getChildren().add(itemButtons.get(itemButtons.size() -1));
		}

		itemsAndCatView.setCenter(items);
	}
	private void handleButtonActions(ActionEvent e) {
		if (catButtons.contains(e.getSource())){
			for(Button catBtn: catButtons){
				if(catBtn == e.getSource()){
					indexOfCurrentCategory = catButtons.indexOf(catBtn);
					loadItemButtons(indexOfCurrentCategory);
					break;
				}
			}
		}

		else if (itemButtons.contains(e.getSource())){
			BasketView.addItem(categories.get(indexOfCurrentCategory).getItems().get(itemButtons.indexOf(e.getSource())));
		}

	}
	
	public BorderPane getItemsAndCatView() {
		return itemsAndCatView;
	}

}
