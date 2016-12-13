package typeQuest;

public class Character {
	int health;
	int damage;
	int level;

	public void battle() {
		int playerDmg;
		int neMeDmg;
		String battleChoice = "";
		do {
			neMeDmg = (int) (Math.random() * (1.5 * neMe.damage) + 1);
			playerDmg = (int) (Math.random() * (1.5 * p.damage) + 1);
			System.out.println("You have encountered a " + neMe + " >> " + "HP:" + healthBar() + " Atk:" + neMe.damage);
			do {
				System.out.println("What would you like to do?\nAttack\nInventory");
				battleChoice = Keyboard.keyb.nextLine();
			} while (!battleChoice.equalsIgnoreCase("attack") && !battleChoice.equalsIgnoreCase("inventory"));
			if (battleChoice.equalsIgnoreCase("attack")) {
				neMe.health -= playerDmg;
				p.health -= neMe.damage;
			} else {
				// TODO: insert an inventory option
			}
			System.out.println(p.name + " used slash dealing " + playerDmg + "Atk\nThe " + neMe.type
					+ " used tackle dealing " + neMeDmg + "Atk");
			System.out.println("\n" + p + "\n" + neMe + "\n");
		} while (neMe.health > 0);
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
		temp += "Lv." + level + " ";
		return temp;
	}
}
