package typeQuest;

public class Main {
	public static Player p = new Player();
	public static Enemy neMe = new Enemy();
	static String choice = "";
	static Room[] rooms = new Room[41];
	static Page[] pages = new Page[12];

	public static void main(String[] args) {
		Item item = new Item(0, choice, choice, 0);
		item.createTheGoodies(1, "Potion", "Heal by 3", 30);
		/*start();
		initialize();
		for (int i = 0; i <= 4; i++) {
			System.out.println(pages[i]);
			if (i == 2) {
				p.name = Keyboard.keyb.nextLine();
				initialize();
			} else {
				hitEnter();
			}
		}
		storyBegins();
		neMe.type = "Jeffery";
		neMe.level = 1;
		neMe.damage = (int) (Math.random() * (3 * neMe.level) + 1);
		neMe.health = (int) (Math.random() * (2 * neMe.level) + 1);
		neMe.money = true;
		System.out.println(p);
		System.out.println(neMe);
		System.out.println("HP: " + neMe.health + " Atk " + neMe.damage);*/
	}

	// TODO: Place the initialize in a different class
	public static void initialize() {
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
		pages[3] = new Page("King: \"" + p.name + ", I will get my finest equipment for you. "
				+ "\nMeet my delivery man at the front gate in the next hour.\""
				+ "\n\nThe celebration comes to an end and you head home to "
				+ "\nprepare for your upcoming adventure.");
		pages[4] = new Page("45 minutes have passed when you decide it’s time to leave. "
				+ "\nYou make your way to the front door when you are stopped by your mother"
				+ "\n\nMother: \"" + p.name + ", please be careful. I will be praying for your safety. "
				+ "\nI have also went out and bought this for you.\""
				// TODO: Insert a DDS to add items to the inventory
				+ "\n\nYou have obtained: \n+1 Poison Antidote \n+1 Paralyze Antidote \n+1 Awakening Spell \n+1 Potion"
				+ "\n\nYou then head out to the front gate where you meet a delivery man holding a package");
		pages[5] = new Page("Delivery Man: \"This is yours\"" + "\n\nYou: \"Thank you\""
				+ "\n\nThe delivery man leaves and you open the package. There is a note."
				+ "\n\n\"Here is the finest equipment I could find for you. It is very unlikely that you "
				+ "\nwill find anything else during your quest. Be sure you come back with my daughter, "
				+ "\nI am counting on you.\"" + "\n-The King" + "\n\nYou put on the equipment");
		pages[6] = new Page(
				"\nYou had decided to go down Shadow Cavern. Just like the name, the cavern looks too dark to see anything"
						+ "\nYou can hear the drops of water hitting the floor but other than that, it is quiet but you can sense danger. Be prepared!");
		// Rooms
		rooms[0] = new Room("\nYou are now in the woods outside your town following the footprints left behind. "
				+ "\nShould we \"proceed\" or \"investigate\"?");
		// First fork in the road
		rooms[1] = new Room(
				"\nThere is now a fork in the road; one path leads to Shadow Cavern, the other leads to Starlight path"
						+ "\nShould we go down \"Shadow Cavern\" or \"Starlight Path\"?");
		// Shadow Cavern
		rooms[2] = new Room("\nThe cavern surrounds you, you can't stop the feeling of being watched"
				+ "\nChills are starting to run down your back. Maybe you've made a bad decision...");
		rooms[3] = new Room(
				"\nYour suspescion was correct, a dwarf jumps out at you trying to steal your money and equipment"
						+ "\nThis means WAR!");
		rooms[4] = new Room("\nThe path keeps getting darker the further you go"
				+ "\nAlthough you killed the dwarf, you still feel like you are being watched"
				+ "\nThe feeling keeps getting worst, what could it be?"
				+ "\nShould we \"proceed\" or \"investigate\"?");
		rooms[5] = new Room("\nYou are in an open area of the cavern, here you are able to see your surroundings"
				+ "\nThe cave looks damp but other than that, nothing seems out of place"
				+ "\nYou start to hear rustling and the sounds of someone walking up to you"
				+ "\n*It steps into the light*"
				+ "\nIt's a Loogaroo! Quickly, kill it before it can suck all your blood!");
		rooms[6] = new Room("\nIt looks like it is just a long dark walkway from here..."
				+ "\nYou have a feeling that you are being watched more closely... WHAT IS IT?!"
				+ "\nShould we \"proceed\" or \"investigate\"?");
		rooms[7] = new Room("\nIt's another opening, but it is very dark in here. It makes it kind of hard to see"
				+ "\nA rock hits your shoulder, you look up"
				+ "\nAn Ahool swoops down befores you and begins to attack, fight your way out of this one");
		rooms[8] = new Room("\nThere is nothing new with the cave... Still dark and damp..."
				+ "\nAnd you still feel like you are being watched... I'm not sure what you think would happen"
				+ "\nShould we \"proceed\" or \"investigate\"?");
		rooms[9] = new Room("\nYou come across a body of water within the cave, if you follow it you can get out!"
				+ "\n*You begin to follow the water when you hear a splash from behind*"
				+ "\nYou turn to see a lindworm heading your direction!");
		rooms[10] = new Room("\nYou continue to follow the water into the unknown darkness"
				+ "\nYou still have the unsettling feeling that something big has yet to come"
				+ "\nShould we \"proceed\" or \"investigate\"?");
		rooms[11] = new Room("\nYou can see a faint light coming from the distance, you must be nearing the end!"
				+ "\n*Your hero sprints to the end" + "\n*THUD*"
				+ "\nYou hit some soft object and get propelled backwards" + "\nA Cerastes stands before you");
		rooms[12] = new Room("\nYou made it though the caves system in one piece!"
				+ "\nYou are more than half way to the Jack-E's castle");
		// Starlight Path
		rooms[13] = new Room("");
		rooms[14] = new Room("");
		rooms[15] = new Room("");
	}

	/**
	 * Forces the user to interact Proceeds as long as the user hits enter
	 */
	public static void hitEnter() {
		System.out.println("\n-Hit Enter to Continue-");
		Keyboard.keyb.nextLine();
	}

	/**
	 * Main menu Starts the game or Print out the help option
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

	/**
	 * Forces the user to proceed
	 */
	public static void storyBegins() {
		System.out.println("===========" + "\nStory Begin" + "\n===========");
		do {
			System.out.println(
					"You are well prepared for adventure ahead. Are you ready to proceed? \n(Type “yes” or “no”)");
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no"));
		if (choice.equalsIgnoreCase("no")) {
			System.out.println("You: \"I don't think I have any time to waste, I should leave right away\""
					+ "\n\n*Your hero leaves anyway*");
		} else {
			System.out.println("\n*Your hero leaves Northbury*");
		}
	}
}
