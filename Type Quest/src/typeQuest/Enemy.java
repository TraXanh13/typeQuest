package typeQuest;

public class Enemy extends Character {
	String type;
	boolean money;

	public String getName() {
		return type;
	}

	// @Override
	public String toString() {
		return type + super.toString();
	}
}
