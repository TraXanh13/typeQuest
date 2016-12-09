package typeQuest;

public class Character {
	int health;
	int damage;
	int level;

	public void battle(Character oppenent) {

	}

	public String healthBar() {
		String hp = "Health:";
		for (int i = 0; i < health; i++) {
			hp += '*';
		}
		return hp;
	}

	public String toString() {
		String temp = "";
		temp += " Lv." + level + " >> Dmg:" + damage + "\n" + healthBar();
		return temp;
	}
}
