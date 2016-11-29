package typeQuest;

public class Main {
	public static Player p = new Player();
	static String choice = "";
	static Room[] rooms = new Room[41];
	static Page[] pages = new Page[12];

	public static void main(String[] args) {
		start();
		intialize();
		for (int i = 0; i <= 3; i++) {
			System.out.println(pages[i]);
			if(i == 2){
				p.name = Keyboard.keyb.nextLine();
				do{
					System.out.println("King: \"Okay " + p.name + ", what is your profession?\"(Warrior, Rogue, Mage)");
					p.role = Keyboard.keyb.nextLine();
				}while(!p.role.equalsIgnoreCase("warrior") && !p.role.equalsIgnoreCase("rogue") && !p.role.equalsIgnoreCase("mage"));
				System.out.println("King: \"A " + p.role + "? Okay, I will get my finest equipment for you. "
						+ "\nMeet my delivery man at the front gate in the next hour.\""
						+ "\n\nThe celebration comes to an end and you head home to "
						+ "\nprepare for your upcoming adventure.");
			}
			hitEnter();
		}
		System.out.println("I wish I had written a game :/");
	}

	public static void intialize() {
		pages[0] = new Page("========" + "\nPrologue" + "\n========"
				+ "\nYou are a student learning fighting styles to one day be part of the"
				+ "\nKings royal knights. You aim to be the best knight there is and to"
				+ "\nprotect the town with every ounce of strength you have. Your town, Northbury"
				+ "\nhas won a war that has lasted over a decade. As a celebration, the king has"
				+ "\ninvited everyone to his castle to celebrate this long needed victory.");
		pages[1] = new Page("King: \"Today is a glorious day for Northbury! "
				+ "\nWe have won the long battle against our rival and today we celebrate.\""
				+ "\n\nKing’s Servant: \"The Princess has gone missing!\""
				+ "\n\nKing: \"Who shall save the princess?\""
				+ "\n\nThe king looks around the room to only find exhausted and injured knights "
				+ "\nalong with other townspeople and inexperienced warriors to be.");
		pages[2] = new Page("You: \"I will save the princess!\""
				+ "\n\nKing: \"Are you sure you are capable to take on the task? It will be very dangerous\""
				+ "\n\nYou: \"I can do this. I have been training to protect the people.\""
				+ "\n\nKing: \"Okay, what is your name?\" (Enter a name)");
		pages[3] = new Page("45 minutes have passed when you decide it’s time to leave. "
				+ "\nYou make your way to the front door when you are stopped by your mother"
				+ "\n\nMother: \"Joey the Grape, please be careful. I will be praying for your safety. "
				+ "\nI have also went out and bought this for you.\""
				+ "\n\nYou have obtained: \n+1 Poison Antidote \n+1 Paralyze Antidote \n+1 Awakening Spell \n+1 Potion"
				+ "\n\nYou then head out to the front gate where you meet a delivery man holding a package");
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
		} while (!choice.equalsIgnoreCase("play") && !choice.equalsIgnoreCase("help"));
		if (choice.equalsIgnoreCase("help")) {
			System.out.println("Follow your hero through battles to make way to the troll king and save the princess"
					+ "\nKeep on the lookout for hidden passages along the way"
					+ "\nThere will be some secret words you can type in order to open the path to the hidden passage");
			hitEnter();
			System.out.println(
					"Be sure you are able to fight and keep your health up, You don't want to end the journey early"
							+ "\nAt any point in the game, you can type \"inventory\" to open your bag to use the potions or antidotes you have picked up"
							+ "\nIn your inventory, you will start with a potion (restores 3 health), and an antidote for every effect (Poison, sleep, and paralyze)"
							+ "\nThe console what tell you what to do for the rest of the game");
			hitEnter();

		}
	}

}
