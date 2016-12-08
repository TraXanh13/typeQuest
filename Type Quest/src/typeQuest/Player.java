package typeQuest;

public class Player extends Character {
	String name;
	String role;
	int block;
	int experience;
	int money;
	
	public String getName(){
		return name;
	}
	
	// @Override
	public String toString() {
		return name + super.toString() + "Money: $" + money;
	}
}
