package typeQuest;

/**
 * 
 * @Author Mr. Prowse
 * Creates the items that will be placed in an inventory
 */
public class Item {
	// the type of item being created
	String type;
	private Item nextItem;
	
	Item(String type){
		this.setType(type);
	}

	public Item getNextItem() {
		return nextItem;
	}

	public void setNextItem(Item items) {
		this.nextItem = items;
	}

	public void setType(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}		
	
	public String toString() {
		return type;
	}
}