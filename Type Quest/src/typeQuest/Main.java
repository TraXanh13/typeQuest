package typeQuest;


public class Main {
	public static Player p = new Player();
	static String choice = "";
	static Room[] rooms = new Room[41];
	static Page[] pages = new Page[12];


	public static void main(String[] args) {
		start();
		intialize();
		for (int i = 0; i <= 4; i++) {
			System.out.println(pages[i]);
			if (i == 2) {
				p.name = Keyboard.keyb.nextLine();
				do {
					System.out.println("King: \"Okay " + p.name + ", what is your profession?\"(Warrior, Rogue, Mage)");
					p.role = Keyboard.keyb.nextLine();
				} while (!p.role.equalsIgnoreCase("warrior") && !p.role.equalsIgnoreCase("rogue")
						&& !p.role.equalsIgnoreCase("mage"));
				System.out.println("King: \"A " + p.role + "? Okay, I will get my finest equipment for you. "
						+ "\nMeet my delivery man at the front gate in the next hour.\""
						+ "\n\nThe celebration comes to an end and you head home to "
						+ "\nprepare for your upcoming adventure.");
			}
			hitEnter();
		}
		storyBegins();
		do{
			System.out.println(rooms[0]);//TODO: Add the different paths he could go
			choice = Keyboard.keyb.nextLine();
		}while(!choice.equalsIgnoreCase("proceed") && !choice.equalsIgnoreCase("return") && !choice.equalsIgnoreCase("investigate") && !choice.equalsIgnoreCase("inventory"));
		if(choice.equalsIgnoreCase("return")){
			System.out.println("We've only just begun, you cannot go back already!");
		}else if(choice.equalsIgnoreCase("investigate")){
			do{
				System.out.println(pages[5]);
				choice = Keyboard.keyb.nextLine();
			}while(!choice.equalsIgnoreCase("bush") && !choice.equalsIgnoreCase("proceed"));
		}
	}

	//TODO: Place the initialize in a different class
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
				+ "\n\nMother: \"" + p.name + ", please be careful. I will be praying for your safety. " //TODO: Have the mother read out the users name -Issue: The initializer is called before the player gets a name
				+ "\nI have also went out and bought this for you.\""
				+ "\n\nYou have obtained: \n+1 Poison Antidote \n+1 Paralyze Antidote \n+1 Awakening Spell \n+1 Potion" //TODO: Insert a DDS to add items to the inventory
				+ "\n\nYou then head out to the front gate where you meet a delivery man holding a package");
		pages[4] = new Page("Delivery Man: \"This is yours\"" + "\n\nYou: \"Thank you\""
				+ "\n\nThe delivery man leaves and you open the package. There is a note."
				+ "\n\n\"Here is the finest equipment I could find for you. It is very unlikely that you "
				+ "\nwill find anything else during your quest. Be sure you come back with my daughter, "
				+ "\nI am counting on you.\"" + "\n-The King" + "\n\nYou put on the equipment");
		pages[5] = new Page("You search the area to find the footprints are similar to a human’s but isn’t."
				+ "/nYou decipher this because no human could possible have size 20 shoes."
				+ "/nYou also notice an odd looking bush and a faint line of slime."
				+ "\n\nWhat do you want to do? (Check the “bush”, “proceed” or “return”)");
		rooms[0] = new Room("\nYou are now in the woods outside your town following the footprints left behind. \nShould we \"proceed\", \"return\", or \"investigate\"?");
	}


	public static void hitEnter() {
		System.out.println("\n-Hit Enter to Continue-");
		Keyboard.keyb.nextLine();
	}


	/*
	 * Main menu of the game
	 * Help options
	 */
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


	//The start of the journey
	public static void storyBegins(){
		System.out.println("===========" + "\nStory Begin" + "\n===========");
		do{
			System.out.println("You are well prepared for adventure ahead. Are you ready to proceed? \n(Type “yes” or “no”)");
			choice = Keyboard.keyb.nextLine();
		}while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));
		if(choice.equalsIgnoreCase("no")){
			System.out.println("You: \"I don't think I have any time to waste, I should leave right away\""
					+ "\n\n*Your hero leaves anyway*");
		}else{
			System.out.println("\n*Your hero leaves Northbury*");
		}
	}
}