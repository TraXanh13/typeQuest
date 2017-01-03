package typeQuest;

public class Enemy{
	static String[] type = {"Slime", "Goblin", "Dwarf", "Loogaroo", "Ahool", "Lindworm", "Cerastes"};
	boolean money;
	static int health;
	static int damage;
	int level;

	// @Override
	public String toString() {
		return super.toString() + type;
	}
}
