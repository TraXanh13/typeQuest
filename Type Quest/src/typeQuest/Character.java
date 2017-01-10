package typeQuest;

public class Character {
	String name = "";
	int health;
	int damage;
	int level = 1;

	/**
	 * Battle sequence Creates the atk dmg for the upcoming turn Asks the user
	 * to attack or use inventory
	 * 
	 */
	public static void commenceBattle(Enemy neMe, Player p) {
		// TODO: Have specified abilities for the characters (Not in F-spec)
		int playerDmg;
		int neMeDmg;
		String battleChoice = "";
		System.out.println("\nYou have encountered a " + neMe + " >> "
				+ neMe.getEnemyHealthBar() + " Atk:" + neMe.damage);
		System.out.println("\n" + p.name + " >> " + p.getPlayerHealthBar()
				+ " Atk:" + p.damage);
		do {
			// Creates a random damage based on the characters attack damage
			neMeDmg = (int) (Math.random() * (1.5 * 2) + neMe.damage);
			playerDmg = (int) (Math.random() * (1.5 * 2) + p.damage);
			do {
				System.out
						.println("What would you like to do?\nAttack\nInventory");
				battleChoice = Keyboard.keyb.nextLine();
			} while (!battleChoice.equalsIgnoreCase("attack")
					&& !battleChoice.equalsIgnoreCase("inventory"));
			if (battleChoice.equalsIgnoreCase("attack")) {
				neMe.health -= playerDmg;
				p.health -= neMeDmg;
				// If the enemy dies
				if (neMe.health < 1) {
					p.health += neMeDmg;
					System.out.println(p.name + " used slash dealing "
							+ playerDmg + "Atk");
					// If the user dies
				} else {
					System.out.println(p.name + " used slash dealing "
							+ playerDmg + "Atk\nThe " + neMe.name
							+ " used tackle dealing " + neMeDmg + "Atk");
				}
			} else {
				useItem(p, null);
			}
			System.out.println("\n" + p + " " + p.getPlayerHealthBar() + "\n"
					+ neMe + " " + neMe.getEnemyHealthBar() + "\n");
		} while (neMe.health > 0 && p.health > 0);
		// If the user happens to die
		if (p.health < 1)
			endGame(p);
		int exp = (int) (Math.random() * (5 * neMe.level) + neMe.level);
		// If the user is able to pick up gold
		if (neMe.money = true) {
			int goldEarned = (int) (Math.random() * (1.5 * 5) + neMe.level);
			p.money += goldEarned;
			System.out.println("You have defeated " + neMe.name + " gaining "
					+ exp + "exp" + "\nYou have also acquired " + goldEarned
					+ " Gold");
			// If no gold is obtained
		} else {
			System.out.println("You have defeated " + neMe.name + " gaining "
					+ exp + "exp");
		}
		p.experience += exp;
		p.levelUp();
	}
	
	static void useItem(Player p, Inventory inventory){
		
	}

	static void endGame(Player p) {
		if (p.health > 0) {
			System.out
					.println("You took the key off the prison guard and released the \nprincess from her cell.  You and the Princess return to Northbury.\n-End-");
		} else {
			System.out.println("You have died... You let us down...");
		}
		/*
		 * do { String choice; System.out
		 * .println("\n\n-Would you like to play again? (\"yes\" or \"no\")-");
		 * choice = Keyboard.keyb.nextLine(); } while
		 * (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));
		 * if (choice.equalsIgnoreCase("yes")) { mainMenu();
		 */
	}

	public String toString() {
		String temp = "";
		temp += "Lv." + level + " ";
		return temp;
	}
}
