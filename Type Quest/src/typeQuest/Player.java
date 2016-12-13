package typeQuest;

public class Player extends Character {
	String name;
	int experience = 0;
	int money = 0;
	
	// @Override
	public String toString() {
		return super.toString() + name;
	}
}
