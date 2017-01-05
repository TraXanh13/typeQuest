package typeQuest;

public class Player {
	static String name;
	static int experience = 0;
	int money = 0;
	static int health;
	static int damage;
	static int level = 1;
	static int experienceNeeded = 10;

	/**
	 * If the character levels up Multiply the experience needed by the level
	 * Increases the heal and attack damage by a random number Print out new
	 * stats
	 */
	public static void levelUp() {
		int temp;
		int bonusHealth;
		if (experience >= experienceNeeded) {
			level++;
			temp = experience % experienceNeeded;
			experienceNeeded = 10 * level;
			experience = temp;
			if (level % 5 == 0) {
				temp = (int) (Math.random() * (3 * 4) + 2);
				bonusHealth = (int) (Math.random() * (3 * 4) + 3);
			} else {
				temp = (int) (Math.random() * (1.5 * 2) + 2);
				bonusHealth = (int) (Math.random() * (1.5 * 2) + 3);
			}
			System.out.println("\nYou have leveled up!" + "\nlv." + level + " " + name + "\n+" + bonusHealth + " HP"
					+ "\n+" + temp + " Atk\n\nExperience until next level up:" + experienceNeeded);
			damage += temp;
			health += bonusHealth;
			System.out.println("\nLv." + level + " " + name + " >> " + getPlayerHealthBar() + " Atk:" + damage + " "
					+ experience + "exp");
		}
	}

	/**
	 * Print out the players health in '*'
	 * 
	 * @return
	 */
	public static String getPlayerHealthBar() {
		String playerHp = "Hp:";
		if (health < 51) {
			for (int i = 0; i < health; i++) {
				playerHp += '*';
			}
			return playerHp;
		} else {
			return "HP:" + health;
		}
	}

	// @Override
	public String toString() {
		return "Lv." + level + " " + name;
	}
}
