package typeQuest;
/**
 * 
 * @author Mr.Prowse
 *
 */
public class Inventory {
	/*private Item firstItem;

	public void additem(Item i) {
		// if the list is empty
		if (this.getFirstItem() == null) {
			this.setFirstItem(i);
			// if the list has items, it will move to the next slot
		} else {
			Item j = this.getFirstItem();
			while (j.getNextItem() != null) {
				j = j.getNextItem();
			}
			j.setNextItem(i);
		}
	}

	public Item getFirstItem() {
		return firstItem;
	}

	public void setFirstItem(Item firstItem) {
		this.firstItem = firstItem;
	}

	public void removeItem(String type) {
		Item temp = this.getFirstItem();
		if (temp == null) {
			// Nothing happens if inventory is empty
		} else if (temp.getType().equalsIgnoreCase(type)) {
			// Replaces the first item with the second item
			this.setFirstItem(temp.getNextItem());
		} else {
			// If the first item isn't what we were looking for
			while (temp.getNextItem() != null) {
				// Loops as long as next item exists
				if (temp.getNextItem().getType().equalsIgnoreCase(type)){
					temp.setNextItem(temp.getNextItem().getNextItem());
				break;
			} else {
				//Move to the next item
				temp = temp.getNextItem();
				}
			}
		}
	}

	@Override
	public String toString() {
		String temp = "";
		Item i = this.getFirstItem();
		while (i != null) {
			temp += i.getType() + "\n";
			i = i.getNextItem();
		}
		return temp;
	}*/
}
