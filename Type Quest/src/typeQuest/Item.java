package typeQuest;

public class Item {
	// Creates the max the player can carry
	private int maxCarry = 10;
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
	
	void addInventoryCount(){
		total += amount;
	}

	public void createTheGoodies(int amount, String type, String description, int Price) {
		if(total < maxCarry){
			item[0] = new Item(amount, type, description, price);
		}else{
			System.out.println("You are carrying too much!");
		}
	}
	
	public String toString(){
		return "you have " + item[0];
	}
}