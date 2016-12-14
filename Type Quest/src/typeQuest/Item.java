package typeQuest;

/**
 * Creates the items that will be placed in an inventory
 */
public class Item {
	// Creates the max the player can carry
	private int maxCarry = 20;
	Item[] item = new Item[maxCarry];

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
	 * @param amount
	 * @param type
	 * @param description
	 * @param Price
	 */
	public void createTheGoodies(int amount, String type, String description, int price) {
		if (total < maxCarry) {
			item[0] = new Item(amount, type, description, price);
		} else {
			System.out.println("You are carrying too much!");
		}
	}

	public String toString() {
		return "you have " + item[0];
	}
}