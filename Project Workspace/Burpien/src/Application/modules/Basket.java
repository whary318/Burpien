package Application.modules;

import Application.controller.Controller;

import java.util.ArrayList;

public class Basket {
	private ArrayList<Item> itemsInOrder;
	private User user;
	private boolean isEditable;
	private double subTotal, tax, total;

	public Basket(User user) {
		this.user = user;
		isEditable = true;
		itemsInOrder = new ArrayList<Item>();

		subTotal = 0.0;
		tax = 0.0;
		total = 0.0;
	}

	public void addItemToOrder(Item item) {		
		itemsInOrder.add(item);
		calculation();
	}
	public void removeItemInOrder(int itemIndex) {
		//itemsInOrder.remove(item);
		itemsInOrder.remove(itemIndex);
		calculation();
	}
	public ArrayList<Item> getItemsInOrder() {
		return itemsInOrder;
	}

	private void calculation() {
		subTotal = 0.0;
		for (Item item: itemsInOrder)
			subTotal += item.getPrice();
		tax = subTotal * Controller.TAX_RATE;
		total = subTotal + tax;
	}

	public double getSubTotal() {
		return subTotal;
	}
	public double getTax() {
		return tax;
	}
	public double getTotal() {
		return total;
	}

	public boolean isOrderEditable() {
		return isEditable;
	}
	public void finalizeOrder() {
		isEditable = false;
	}
}
