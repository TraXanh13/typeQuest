package typeQuest;

public class Character {
	public static Player p = new Player();
	public static Enemy neMe = new Enemy();
	int health;
	int damage;
	int level;

	public void battle() {
		String battleChoice = "";
		System.out.println("You have encountered a " + neMe + " >> " + "HP:" + healthBar() + " Atk:" + neMe.damage);
		do{
			System.out.println("What would you like to do?\nAttack\nBlock");
			battleChoice = Keyboard.keyb.nextLine();
		}while(!battleChoice.equalsIgnoreCase("attack") && !battleChoice.equalsIgnoreCase("block"));
		
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
