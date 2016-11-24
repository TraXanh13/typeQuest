package typeQuest;

public class Main {
	public static Player p = new Player();
	static String choice = "";
	static Room[] rooms = new Room[41];
	static Page[] pages = new Page[12];

	public static void main(String[] args) {
		start();
		intialize();
		System.out.println(pages[0]);
		hitEnter();
		System.out.println("I wish I had written a game :/");
	}

	public static void intialize() {
		pages[0] = new Page(
				"========"
						+ "\nPrologue"
						+ "\n========"
						+ "\nYou are a student learning fighting styles to one day be part of the"
						+ "\nKings royal knights. You aim to be the best knight there is and to"
						+ "\nprotect the town with every ounce of strength you have. Your town, Northbury"
						+ "\nhas won a war that has lasted over a decade. As a celebration, the king has"
						+ "\ninvited everyone to his castle to celebrate this long needed victory.");
		pages[1] = new Page(
				"King: \""
				);
		rooms[0] = new Room("input stuff here");
	}

	public static void hitEnter() {
		System.out.println("\n-Hit Enter to Continue-");
		Keyboard.keyb.nextLine();
	}

	public static void start() {
		System.out.println("Welcome to Type Quest!");
		do {
			System.out.println("Would you like to \"play\" or get \"help\"");
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equalsIgnoreCase("play")
				&& !choice.equalsIgnoreCase("help"));
		if (choice.equalsIgnoreCase("help")) {
			System.out
					.println("Follow your hero through battles to make way to the troll king and save the princess"
							+ "\nKeep on the lookout for hidden passages along the way"
							+ "\nThere will be some secret words you can type in order to open the path to the hidden passage");
			hitEnter();
			System.out
					.println("Be sure you are able to fight and keep your health up, You don't want to end the journey early"
							+ "\nAt any point in the game, you can type \"inventory\" to open your bag to use the potions or antidotes you have picked up"
							+ "\nIn your inventory, you will start with a potion (restores 3 health), and an antidote for every effect (Poison, sleep, and paralyze)"
							+ "\nThe console what tell you what to do for the rest of the game");
			hitEnter();

		}
	}

}
