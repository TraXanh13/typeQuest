package typeQuest;

public class Character {
	static int health;
	static int damage;
	int level;

	/**
	 * Battle sequence
	 * Creates the atkdmg for the upcoming turn
	 * Asks the user to attack or use inventory
	 * 
	 */
	/*public void battle(Character opponent) {
		int playerDmg;
		int neMeDmg;
		String battleChoice = "";
		do {
			neMeDmg = (int) (Math.random() * (1.5 * Enemy.damage) + 1);
			playerDmg = (int) (Math.random() * (1.5 * Player.damage) + 1);
			//System.out.println("You have encountered a " + neMe + " >> " + "HP:" + healthBar() + " Atk:" + neMe.damage);
			do {
				System.out.println("What would you like to do?\nAttack\nInventory");
				battleChoice = Keyboard.keyb.nextLine();
			} while (!battleChoice.equalsIgnoreCase("attack") && !battleChoice.equalsIgnoreCase("inventory"));
			if (battleChoice.equalsIgnoreCase("attack")) {
				Enemy.health -= playerDmg;
				System.out.println(Player.name + " used slash dealing " + playerDmg + "Atk\nThe " + Enemy.type
					+ " used tackle dealing " + neMeDmg + "Atk");
				Player.health -= Enemy.damage;
			} else {
				// TODO: insert an inventory option
			}
			//System.out.println("\n" + Player + "\n" + Enemy + "\n");
		} while (Enemy.health > 0 || Player.health > 0);
	}*/
	
	public String getName() {
		return "";
	}

	/**
	 * Print out the health in '*'
	 * @return
	 */
	public String healthBar() {
		String hp = "Health:";
		for (int i = 0; i < health; i++) {
			hp += '*';
		}
		return hp;
	}

	public String toString() {
		String temp = "";
		temp += "Lv." + level + " ";
		return temp;
	}
}
