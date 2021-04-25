package Application.modules;

public class Item {
	private String nameOfItem;
	private double price;
	private PriceType unit;
	private int id;

	public Item(String nameOfItem, double price, PriceType unit, int id) {
		this.nameOfItem = nameOfItem;
		this.price = price;
		this.unit = unit;
		this.id = id;
	}

	public String getNameOfItem() {
		return nameOfItem;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PriceType getUnit() {
		return unit;
	}

	public void setUnit(PriceType unit) {
		this.unit = unit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {// Half Spicy Sub\nPrice: $4.99
		return nameOfItem + "\nPrice: $" + price + "\nItem ID: " + id;
	}
}
