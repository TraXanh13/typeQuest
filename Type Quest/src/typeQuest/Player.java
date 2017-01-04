package typeQuest;

public class Player{
	static String name;
	int experience = 0;
	int money = 0;
	static int health;
	static int damage;
	int level;
	
	// @Override
	public String toString() {
		return "Lv." + level + " " + name;
	}
}
