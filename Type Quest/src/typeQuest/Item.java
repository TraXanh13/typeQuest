package typeQuest;

/**
 * Creates the items that will be placed in an inventory
 */
public class Item {
	// Properties of the item
	private int amount;
	private String type;
	private int price;
	private String description;
	private Item nextItem;
	
	Item(int amount, String type, String description, int price){
		this.setAmount(amount);
		this.setType(type);
		this.setPrice(price);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Item getNextItem() {
		return nextItem;
	}

	public void setNextItem(Item items) {
		this.nextItem = items;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
		
}