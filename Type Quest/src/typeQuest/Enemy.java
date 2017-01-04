package typeQuest;

public class Enemy{
	String type = "";
	boolean money;
	static int health;
	static int damage;
	int level;

	// @Override
	public String toString() {
		return "Lv." + level + " " + type;
	}
}
