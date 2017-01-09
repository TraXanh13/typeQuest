package typeQuest;

public class Enemy extends Character{
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
