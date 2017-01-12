package typeQuest;

/**
 * Runs all the text and story
 * @author minia
 *
 */
public class Main {
	static Player p = new Player();
	static Enemy neMe = new Enemy();
	static String choice = "";
	static Room[] rooms = new Room[41];
	static Page[] pages = new Page[12];

	public static void main(String[] args) {
		p.damage = (int) (Math.random() * (1.5 * 3) + 2);
		initialize();
		mainMenu();
	}

	/**
	 * The first screen the user will see before they enter the game
	 */
	public static void mainMenu() {
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
							+ "\nIn your inventory, you will start with a potion (restores 3 health), and an antidote for every effect (Poison and paralyze)"
							+ "\nThe console what tell you what to do for the rest of the game");
			hitEnter();
		}
		storyBegins();
	}

	/**
	 * Forces the user to interact Proceeds as long as the user hits enter
	 */
	public static void hitEnter() {
		System.out.println("\n-Hit Enter to Continue-");
		Keyboard.keyb.nextLine();
	}

	/**
	 * If user decides to proceed or investigate
	 */
	static void shallWeProceed() {
		do {
			System.out.println("Should we \"proceed\" or \"investigate\"?");
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equalsIgnoreCase("Proceed") && !choice.equalsIgnoreCase("Investigate"));
	}

	static void getItem() {
		int temp = (int) (Math.random() * 4 + 1);
		if (temp == 1) {
			p.inventory.add(new Item("Potion"));
			System.out.println("\nYou have obtained:\n+1 Potion\n");
		} else if (temp == 2) {
			p.inventory.add(new Item( "Super Potion"));
			System.out.println("\nYou have obtained:\n+1 Super Potion\n");
		} else if (temp == 3) {
			p.inventory.add(new Item("Paralyze Antidote"));
			System.out.println("\nYou have obtained:\n+1 Paralyze Antidote\n");
		} else if (temp == 4) {
			p.inventory.add(new Item("Poison Antidote"));
			System.out.println("\nYou have obtained:\n+1 Poison Antidote\n");
		}
		System.out.println(p.inventory);
	}

	/**
	 * Everything up to the fork in the road
	 */
	public static void storyBegins() {
		p.inventory.add(new Item("Poison Antidote"));
		p.inventory.add(new Item("Paralyze Antidote"));
		p.inventory.add(new Item("Potion"));
		for (int i = 0; i <= 5; i++) {
			System.out.println(pages[i]);
			if (i == 2) {
				p.name = Keyboard.keyb.nextLine();
				initialize();
			} else {
				hitEnter();
			}
		}
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
		System.out.println(rooms[0]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println(rooms[13]);
			do {
				System.out.println("What do you want to do? (Check the \"bush\" or \"proceed\"?)");
				choice = Keyboard.keyb.nextLine();
			} while (!choice.equalsIgnoreCase("bush") && !choice.equalsIgnoreCase("proceed"));
			if (choice.equalsIgnoreCase("bush")) {
				System.out.println("\nYou check in the bush to find one of the towwns guard dead"
						+ "\nYou look through the guards pouch to find a flask\n");
				getItem();
				do {
					System.out.println("\nShall we \"proceed\"?");
					choice = Keyboard.keyb.nextLine();
				} while (!choice.equalsIgnoreCase("proceed") && !choice.equalsIgnoreCase("hero"));
				if (choice.equalsIgnoreCase("proceed")) {
					System.out.println(
							"\nYou don't think you can go any further\nYou should head back to the main trail");
					System.out.println("\nAfter returning to the main trail you proceed with your quest");
				} else if (choice.equalsIgnoreCase("hero")) {
					System.out.println(rooms[14]);
					neMe.level = 1;
					neMe.money = false;
					neMe.name = "Goblin";
					neMe.basicAbility = "Club Smash";
					neMe.damage = (int) (Math.random() * (1.5 * 2) + 1);
					neMe.health = (int) (Math.random() * (1.5 * 3) + 5);
					Character.commenceBattle(neMe, p);
					System.out.println(
							"\nYou were victorious!\nYou should continue on with our quest, but first you should return to the main trail");
					System.out.println("\nAfter returning to the main trail you proceed with your quest");
				} else {
					System.out.println("\nAfter returning to the main trail you proceed with your quest");
				}
			} else {
				System.out.println("I don't think you can go any further\nYou should head back to the main trail");
				System.out.println("\nAfter returning to the main trail you proceed with your quest");
			}
		}
		do {
			System.out.println(rooms[1]);
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equalsIgnoreCase("Shadow Cavern") && !choice.equalsIgnoreCase("Starlight Path"));
		if (choice.equalsIgnoreCase("shadow cavern")) {
			headToShadowCavern();
		} else {
			headToStarlightPath();
		}
	}

	/**
	 * The path the user will follow if they decide to go down starlight path
	 */
	static void headToStarlightPath() {
		System.out.println("\n==============\nStarlight Path\n==============");
		System.out.println(pages[7]);
		System.out.println(rooms[15]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			do {
				System.out.println(rooms[16]);
				getItem();
				System.out.println("\nShould we adventure \"further\" out or \"continue\" on with our quest?");
				choice = Keyboard.keyb.nextLine();
			} while (!choice.equalsIgnoreCase("proceed") && !choice.equalsIgnoreCase("further"));
			if (choice.equalsIgnoreCase("further")) {
				System.out.println(rooms[17]);
				neMe.name = "Reptilian Humanoid";
				neMe.basicAbility = "Stab";
				neMe.level = 2;
				neMe.health = (int) (Math.random() * (1.5 * 3) + 3);
				neMe.damage = (int) (Math.random() * (1.5 * 2) + 2);
				neMe.money = false;
				Character.commenceBattle(neMe, p);
				System.out.println("\nThere may be more enemies further ahead. You decide to head back the trail and"
						+ "\ncontinue on with your quest");
			}
		}
		System.out.println(rooms[18]);
		neMe.name = "Giant";
		neMe.basicAbility = "Smash";
		neMe.level = 5;
		neMe.health = (int) (Math.random() * (1.5 * 3) + 7);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 3);
		neMe.money = false;
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[19]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("You poke your head into the flowers. You found a flask!");
			getItem();
		}
		System.out.println(
				"You continue around the corner. The sun is starting to set now. The sky is painted with an array of pink, orange, and yellow. It is truly mesmerizing.\n"
						+ rooms[20]);
		neMe.name = "Ghost";
		neMe.basicAbility = "Play mate";
		neMe.level = 13;
		neMe.health = (int) (Math.random() * (1.5 * 2) + 14);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 1);
		neMe.money = false;
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[21]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("OUCH! something bit you! You took 3 damage");
			p.health -= 3;
			if (p.health < 0) {
				Character.endGame(p);
			}
		}
		System.out.println(rooms[22]);
		neMe.name = "Zombie";
		neMe.basicAbility = "BRAIIINSS";
		neMe.level = 15;
		neMe.health = (int) (Math.random() * (1.5 * 2) + 5);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 9);
		neMe.money = true;
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[23]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("You found a flask on the zombies body");
			getItem();
		}
		System.out.println(rooms[24]);
		neMe.name = "Skeleton Warrior";
		neMe.basicAbility = "Breaking Bones";
		neMe.level = 16;
		neMe.health = (int) (Math.random() * (1.5 * 3) + 4);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 18);
		neMe.money = true;
		Character.commenceBattle(neMe, p);
		runTheFinalStretch();
	}

	/**
	 * The path the user will follow if they decide to go down the shadow cavern
	 */
	static void headToShadowCavern() {
		System.out.println("\n=============\nShadow Cavern\n=============");
		System.out.println(pages[6]);
		hitEnter();
		System.out.println(rooms[2]);
		hitEnter();
		System.out.println(rooms[3]);
		neMe.name = "Dwarf";
		neMe.basicAbility = "Punch";
		neMe.money = true;
		neMe.level = 1;
		neMe.health = (int) (Math.random() * (1.5 * 3) + 2);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 1);
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[4]);
		shallWeProceed();
		// If the user chooses to investigate
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("You look around but it is too hard to see anything so you proceed");
		}
		System.out.println(rooms[5]);
		neMe.level = 2;
		neMe.money = true;
		neMe.name = "Giant Rat";
		neMe.basicAbility = "Bite";
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 3);
		neMe.health = (int) (Math.random() * (1.5 * 3) + 4);
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[6]);
		shallWeProceed();
		// If the user chooses to investigate
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("You look around but it is too hard to see anything so you proceed");
		}
		System.out.println(rooms[7]);
		neMe.level = 4;
		neMe.money = true;
		neMe.name = "Bat Humanoid";
		neMe.basicAbility = "Wing Swipe";
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 5);
		neMe.health = (int) (Math.random() * (1.5 * 3) + 9);
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[8]);
		shallWeProceed();
		// If the user chooses to investigate
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println(
					"You put your arm in a hole the wall" + "\nOUCH! Something bit you!" + "\nLet's just proceed");
			p.health -= 3;
			if (p.health < 1) {
				Character.endGame(p);
			}
		}
		System.out.println(rooms[9]);
		neMe.level = 5;
		neMe.money = false;
		neMe.name = "Lindworm";
		neMe.basicAbility = "Tackle";
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 8);
		neMe.health = (int) (Math.random() * (1.5 * 3) + 7);
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[10]);
		shallWeProceed();
		// If the user chooses to investigate
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("You find a flask behind a stone on the floor!");
			getItem();
		}
		System.out.println(rooms[11]);
		neMe.level = 9;
		neMe.money = true;
		neMe.name = "Giant Snake";
		neMe.basicAbility = "Squeeze";
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 7);
		neMe.health = (int) (Math.random() * (1.5 * 3) + 18);
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[12]);
		runTheFinalStretch();
	}

	/**
	 * Final few stages of the game
	 */
	static void runTheFinalStretch() {
		System.out.println(pages[10]);
		System.out.println(rooms[26]);
		shallWeProceed();
		if (choice.equalsIgnoreCase("investigate")) {
			System.out.println("There is nothing around here, lets continue");
		}
		System.out.println(rooms[27]);
		do {
			System.out.println("Should we \"shop\" or \"proceed\"?");
			choice = Keyboard.keyb.nextLine();
		} while (!choice.equalsIgnoreCase("shop") && !choice.equalsIgnoreCase("proceed"));
		if (choice.equalsIgnoreCase("shop")) {
			System.out.println("To buy items, type the number before the item. To leave the shop type \"leave\"");
			do {
				System.out.println(
						"You have " + p.money + " gold" + "\n\n\"What would you like to buy\"" + "\n-Shop Keeper");
				System.out.println(
						"\n1.Potion 10 gold\n2.Super Potion 20 gold\n3.Paralyze Antidote 15 gold\n4.Poison Antidote 15 gold\n-Leave-");
				choice = Keyboard.keyb.nextLine();
				if (p.money >= 10 && choice.equals("1")) {
					p.inventory.add(new Item("Potion"));
					p.money -= 10;
				} else if (p.money >= 20 && choice.equals("2")) {
					p.inventory.add(new Item("Super Potion"));
					p.money -= 20;
				} else if (p.money >= 15 && choice.equals("3")) {
					p.inventory.add(new Item("Paralyze Antidote"));
					p.money -= 15;
				} else if (p.money >= 15 && choice.equals("4")) {
					p.inventory.add(new Item("Poison Antidote"));
					p.money -= 15;
				}
			} while (!choice.equalsIgnoreCase("leave"));
			System.out.println("You currently hold: " + p.inventory);
			System.out.println("\n\"Take care!\"\n-Shop Keeper");
			System.out.println("\nYou proceed onward\n");
		}
		System.out.println(rooms[28]);
		hitEnter();
		System.out.println(pages[8]);
		hitEnter();
		System.out.println(pages[9]);
		neMe.name = "Guard";
		neMe.basicAbility = "Spear thrust";
		neMe.level = 18;
		neMe.health = (int) (Math.random() * (1.5 * 3) + 18);
		neMe.damage = (int) (Math.random() * (1.5 * 2) + 7);
		neMe.money = true;
		Character.commenceBattle(neMe, p);
		System.out.println(rooms[29]);
		hitEnter();
		do{
			System.out.println(rooms[30]);
			choice = Keyboard.keyb.nextLine();
		}while(!choice.equalsIgnoreCase("boss") && !choice.equalsIgnoreCase("door"));
		if(choice.equalsIgnoreCase("door")){
			System.out.println(rooms[31]);
			getItem();
		}
		// TODO: the rest
	}

	/**
	 * Adds a description for each area or set of the story
	 */
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
				+ "\nYou make your way to the front door when you are stopped by your mother" + "\n\nMother: \""
				+ p.name + ", please be careful. I will be praying for your safety. "
				+ "\nI have also went out and bought this for you.\""
				+ "\n\nYou have obtained: \n+1 Poison Antidote \n+1 Paralyze Antidote \n+1 Potion"
				+ "\n\nYou then head out to the front gate where you meet a delivery man holding a package");
		pages[5] = new Page("Delivery Man: \"This is yours\"" + "\n\nYou: \"Thank you\""
				+ "\n\nThe delivery man leaves and you open the package. There is a note."
				+ "\n\n\"Here is the finest equipment I could find for you. It is very unlikely that you "
				+ "\nwill find anything else during your quest. Be sure you come back with my daughter, "
				+ "\nI am counting on you.\"" + "\n-The King" + "\n\nYou put on the equipment");
		pages[6] = new Page(
				"\nYou had decided to go down Shadow Cavern. Just like the name, the cavern looks too dark to see anything"
						+ "\nYou can hear the drops of water hitting the floor but other than that, it is quiet but you can sense danger. Be prepared!");
		pages[7] = new Page("You have decided to go down Starlight Path. The path looks really peaceful and quiet"
				+ "\nThis should be a nice and easy journey towards Jack-E's castle.");
		pages[8] = new Page("\"It is I, " + p.name + ", I have come to save the princess from the Troll King!"
				+ "\n\n\"Impossible, Jack-E will not allow it!\"\n-Guard");
		pages[9] = new Page("\"Move aside, let me through!\"" + "\n\n\"Over my dead body!\"\n-Guard"
				+ "\n\n\"That can be arranged\"");
		pages[10] = new Page("\n=====\nFINAL\n=====");
		// Rooms
		rooms[0] = new Room("You are now in the woods outside your town following the footprints left behind. ");
		// First fork in the road
		rooms[1] = new Room(
				"\nThere is now a fork in the road; one path leads to Shadow Cavern, the other leads to Starlight path"
						+ "\nShould we go down \"Shadow Cavern\" or \"Starlight Path\"?");
		// Shadow Cavern
		rooms[2] = new Room("The cavern surrounds you, you can't stop the feeling of being watched"
				+ "\nChills are starting to run down your back. Maybe you've made a bad decision...");
		rooms[3] = new Room("Your suspescion was correct, a Dwarf jumps out at you trying to steal your stuff"
				+ "\nThis means WAR!");
		rooms[4] = new Room("The path keeps getting darker the further you go"
				+ "\nAlthough you killed the Dwarf, you still feel like you are being watched"
				+ "\nThe feeling keeps getting worst, what could it be?");
		rooms[5] = new Room("You are in an open area of the cavern, here you are able to see your surroundings"
				+ "\nThe cave looks damp but other than that, nothing seems out of place"
				+ "\nYou start to hear rustling and the sounds of someone walking up to you"
				+ "\n\n*It steps into the light*\n"
				+ "\nIt's a Giant Rat! Quickly, kill it before it can suck all your blood!");
		rooms[6] = new Room("It looks like it is just a long dark walkway from here..."
				+ "\nYou have a feeling that you are being watched more closely... WHAT IS IT?!");
		rooms[7] = new Room("It's another opening, but it is very dark in here. It makes it kind of hard to see"
				+ "\nA rock hits your shoulder, you look up"
				+ "\nA bat Humanoid swoops down befores you and begins to attack, fight your way out of this one");
		rooms[8] = new Room("There is nothing new with the cave... Still dark and damp..."
				+ "\nAnd you still feel like you are being watched... I'm not sure what you think would happen");
		rooms[9] = new Room("You come across a body of water within the cave, if you follow it you can get out!"
				+ "\n*You begin to follow the water when you hear a splash from behind*"
				+ "\nYou turn to see a Lindworm heading your direction!");
		rooms[10] = new Room("You continue to follow the water into the unknown darkness"
				+ "\nYou still have the unsettling feeling that something big has yet to come");
		rooms[11] = new Room("You can see a faint light coming from the distance, you must be nearing the end!"
				+ "\n*Your hero sprints to the end" + "\n*THUD*"
				+ "\nYou hit some soft object and get propelled backwards" + "\nA Giant Snake stands before you");
		rooms[12] = new Room("You made it though the caves system in one piece!"
				+ "\nYou are more than half way to the Jack-E's castle");
		// Exploration outside the town
		rooms[13] = new Room("\nYou search the area to find the footprints are similar to a human’s but isn’t"
				+ "\nYou decipher this because no human could possible have size 20 shoes"
				+ "\nYou also notice an odd looking bush and a faint line of slime");
		rooms[14] = new Room("Having your new weapon, you swing the weapon around at some trees and bushes when you"
				+ "\nuncover a hidden path you didn't see. You walk through the path to find a goblin!");
		// Starlight Path
		rooms[15] = new Room("The path is bordered by beautiful yellow flowers, nothings seems to be a problem"
				+ "\nI think I made the best choice, this is going to be a walk in the park.");
		rooms[16] = new Room("You poke your head into the flowers and find a flask!");
		rooms[17] = new Room(
				"You adventure further into the flowers to find yourself face to face with a Reptilian Humanoid");
		rooms[18] = new Room("You go back to the main trial and continue on with the quest"
				+ "\n\nIn the far distance you can see something very large. You continue to follow the path only to "
				+ "\nfind a 8ft tall human standing before you. Before you have the chance the speak, it swings a bat at you.");
		rooms[19] = new Room(
				"The path from here just cuts off suddenly. I think there is a turn up ahead. I don’t think there is anywhere else to go");
		rooms[20] = new Room("Suddenly, a ghost emerges from the ground before you");
		rooms[21] = new Room("We somehow managed to kill the dead.. Ghost... With a sword..."
				+ "\nIt has gotten dark. Now I see why it is called Starlight Path! It's beautiful! The stars"
				+ "\nIlluminate the path. I think I see someone ahead! It might be an NPC, maybe I'll get some free stuff");
		rooms[22] = new Room(
				"\n*You walk up to the person*\n\n" + "IT ISN'T A PERSON!! IT'S A ZOMBIE! WE HAVE TO FIGHT IT!");
		rooms[23] = new Room("That was a tough one, we should get up before it gets back up again");
		rooms[24] = new Room(
				"Again, you see something ahead. But we must move onwards!" + "\nIt is a warrior skeleton!");
		rooms[25] = new Room("We must be really close to the castle! That skeleton must've been a nnight guard");
		// Towards the princess!
		rooms[26] = new Room(
				"It seems all the paths come togerther now. You made it! You look onwards and you see the castle "
						+ "\nin the distance. You are almost there!");
		rooms[27] = new Room("As you follow the path towards the castle, you find yourself at a shop");
		rooms[28] = new Room("You approach the front gates of the castle \n\n\"Who goes there?!\"\n-Guard");
		rooms[29] = new Room("The guard has been defeated and you have made your way into the castle"
				+ "\nAfter wondering around for a while you realize you are comepletely lost...");
		rooms[30] = new Room("You eventually come across two doors. Should we go through the \"Boss\" room, or go through the other \"door\"?");
		rooms[31] = new Room("You find yourself in the storage room. The storage rooms is quite empty but you"
				+ "\nstill take whatever you find useful and head towards the boss's throne room");
		rooms[32] = new Room("");
		rooms[33] = new Room("");
		rooms[34] = new Room("");
		rooms[35] = new Room("");
		rooms[36] = new Room("");
		rooms[37] = new Room("");
		rooms[38] = new Room("");
		rooms[39] = new Room("");
		rooms[40] = new Room("");
		// TODO:
	}

}
