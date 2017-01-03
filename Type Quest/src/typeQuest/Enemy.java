package typeQuest;

public class Enemy extends Character {
	static String[] type = {"Slime", "Goblin", "Dwarf", "Loogaroo", "Ahool", "Lindworm", "Cerastes"};
	boolean money;

	// @Override
	public String toString() {
		return super.toString() + type;
	}
}
