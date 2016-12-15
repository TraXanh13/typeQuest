package typeQuest;

/**
 * Creates the items that will be placed in an inventory
 */
public class Item {
	// Properties of the item
	int total;
	int amount;
	String type;
	String description;
	int price;

	public Item(int amount, String type, String description, int price) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.price = price;
	}

	/**
	 * Add to the total amount the player is holding
	 */
	void addInventoryCount() {
		total += amount;
	}

	/**
	 * Constructor Creates the item with parameters passed from the main
	 * Only creates item if there is space in the bag
	 * 
	 * explain what the params are
	 * @param amount
	 * @param type
	 * @param description
	 * @param price
	 */
	public void createTheGoodies(int amount, String type, String description, int price) {
		
	}

	/*
	 * public String toString() {
	 * return "you have " + ;
	 * }
	 */
		
}