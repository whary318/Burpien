package Application.modules;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Item> items;
	
	public Category(String name) {
		this.name = name;
		items = new ArrayList<Item>();
	}
	
	//setters
	public void additem(String nameOfItem, double price, PriceType unit, int id) {
		items.add(new Item(nameOfItem, price, unit, id));
	}

	//getters
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public String getName() {
		return name;
	}


	
	
	
	
	

	
}
