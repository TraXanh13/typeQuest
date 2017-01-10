package typeQuest;

/**
 * Creates the items that will be placed in an inventory
 */
public class Item {
	// Properties of the item
	private int amount;
	private String type;
	private Item nextItem;
	
	Item(int amount, String type){
		this.setAmount(amount);
		this.setType(type);
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
}