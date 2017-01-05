package typeQuest;

public class Enemy{
	String type = "";
	String basicAbility = "";
	boolean money;
	int health;
	int damage;
	int level;

	// @Override
	public String toString() {
		return "Lv." + level + " " + type;
	}
}
