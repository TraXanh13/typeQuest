package typeQuest;

public class Character {
	String name = "";
	int health = 10;
	int damage;
	int level = 1;
	Item firstItem;
	static String choice;

	/**
	 * Battle sequence between the user and enemy
	 * 
	 * @param neMe uses the stats of the enemies
	 * @param p uses the stats of the player
	 */
	public static void commenceBattle(Enemy neMe, Player p) {
		/*
		 * int, a class specific var for random damage depending on player strength
		 * int, a class specific var for random damage depending on enemy strength
		 * String, holds the decisions the user makes
		 */
		int playerDmg;
		int neMeDmg;
		String battleChoice = "";
		System.out.println(
				"\nYou have encountered a " + neMe + " >> " + neMe.getEnemyHealthBar() + " Atk:" + neMe.damage);
		System.out.println("\nLv." + p.level + " " + p.name + " >> " + p.getPlayerHealthBar() + " Atk:" + p.damage);
		do {
			// Creates a random damage based on the characters attack damage
			neMeDmg = (int) (Math.random() * (1.5 * 2) + neMe.damage);
			playerDmg = (int) (Math.random() * (1.5 * 2) + p.damage);
			do {
				//Ask the user to attack or use inventory
				System.out.println("What would you like to do?\nAttack\nInventory");
				battleChoice = Keyboard.keyb.nextLine();
			} while (!battleChoice.equalsIgnoreCase("attack") && !battleChoice.equalsIgnoreCase("inventory"));
			if (battleChoice.equalsIgnoreCase("inventory")) {
				useItem(p);
				//After the user uses an item, enemy attacks
				p.health -= neMeDmg;
				System.out.println(neMe.name + " used " + neMe.basicAbility + " dealing " + neMeDmg + "Atk");
			} else {
				//If the user decides to attack
				neMe.health -= playerDmg;
				p.health -= neMeDmg;
				// If the enemy dies
				if (neMe.health < 1) {
					//returned the health the player lost
					p.health += neMeDmg;
					System.out.println(p.name + " used slash dealing " + playerDmg + "Atk");
					// If the user dies
				} else {
					System.out.println(p.name + " used slash dealing " + playerDmg + "Atk\nThe " + neMe.name + " used "
							+ neMe.basicAbility + " dealing " + neMeDmg + "Atk");
				}
			}
			System.out.println(
					"\n" + p + " " + p.getPlayerHealthBar() + "\n" + neMe + " " + neMe.getEnemyHealthBar() + "\n");
		} while (neMe.health > 0 && p.health > 0);
		//Continuous looping until someone dies
		if (p.health < 1)
			// If the user happens to die
			endGame(p);
		int exp = (int) (Math.random() * (5 * neMe.level) + neMe.level);
		//Randomly generated experience depending on enemy level
		if (neMe.money = true) {
			// If the user is able to pick up gold
			int goldEarned = (int) (Math.random() * (1.5 * 5) + neMe.level);
			p.money += goldEarned;
			System.out.println("You have defeated " + neMe.name + " gaining " + exp + "exp"
					+ "\nYou have also acquired " + goldEarned + " Gold\n");
			// If no gold is obtained
		} else {
			System.out.println("You have defeated " + neMe.name + " gaining " + exp + "exp\n");
		}
		p.experience += exp;
		p.levelUp();
	}

	static void useItem(Player p) {
		System.out.println("Your items consist of:" + p.inventory);
		do {
			System.out.println("Which item would you like to use?");
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equals("Potion") && !choice.equals("Super Potion") && !choice.equals("Poison Antidote"));
		if (choice.equalsIgnoreCase("Potion")) {
			if (p.health < p.maxHealth) {
				p.health += 10;
				System.out.println("You have been healed for 10");
				removeItem(p);
			} else {
				System.out.println("You cannot be healed anymore!");
			}
		} else if (choice.equalsIgnoreCase("Super Potion")) {
			if (p.health < p.maxHealth) {
				p.health += 20;
				System.out.println("You have been healed for 20");
				p.inventory.remove("Super Potion");
				removeItem(p);
			} else {
				System.out.println("You cannot be healed anymore!");
			}
		} else if (choice.equalsIgnoreCase("Paralyze Antidote")) {
			System.out.println("This does nothing");
			removeItem(p);
		} else {
			System.out.println("This also does nothing");
			removeItem(p);
		}
	}

	/**
	 * 
	 * @param p
	 */
	static void removeItem(Player p) {
		for (int i = 0; i < p.inventory.size(); i++) {
			if (p.inventory.get(i).type.equalsIgnoreCase(choice)) {
				p.inventory.remove(i);
				System.out.println(p.inventory);
				break;
			}
		}

	}

	public Item getFirstItem() {
		return firstItem;
	}

	public void setFirstItem(Item firstItem) {
		this.firstItem = firstItem;
	}

	static void endGame(Player p) {
		if (p.health > 0) {
			System.out.println(
					"You took the key off the prison guard and released the \nprincess from her cell.  You and the Princess return to Northbury\n-End-");
			System.exit(0);
		} else {
			System.out.println("You have died... You let us down...");
			System.exit(0);
		}
	}

	public String toString() {
		String temp = "";
		temp += "Lv." + level + " " + name;
		return temp;
	}
}
