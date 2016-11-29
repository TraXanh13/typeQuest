package typeQuest;

public class Enemy {
	String type;
	int health;
	int atk;
	int level;

	public Enemy(String type) {
		if (type.equals("slime")) {
			health = 5;
			atk = 3;
			level = 1;
		}
	}
}
