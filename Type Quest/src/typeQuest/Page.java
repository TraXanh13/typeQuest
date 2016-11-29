package typeQuest;

public class Page {
	String unfold = ""; //The description of the page
	
	Page(String unfold) {
		this.unfold = unfold;
	}

	public String toString(){
		return unfold;
	}
}
