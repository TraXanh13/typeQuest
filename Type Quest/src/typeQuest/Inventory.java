package typeQuest;

public class Inventory {
private Item firstItem;
	
	public void additem(Item i){
		//if the list is empty
		if(this.getFirstItem() == null){
			this.setFirstItem(i);
		//if the list has items
		}else{
			Item j = this.getFirstItem();
			while(j.getNextItem() != null){
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
	
	@Override
	public String toString(){
		String temp = "";
		Item i = this.getFirstItem();
		while(i != null){
			temp += i.getDescription() + "\n";
			i = i.getNextItem();
		}
		return temp;
	}
}
