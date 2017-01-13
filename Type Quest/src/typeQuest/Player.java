package typeQuest;

import java.util.ArrayList;

/**
 * This player class holds specific data according to the players specific
 * attributes
 * 
 * @author minia
 * 
 */
public class Player extends Character {
	/**
	 * int to keep track of the users total max health int to count experience
	 * gained after battles int for money count int to track experienced needed
	 * per level ArrayList to hold all the items in the inventory
	 */
	int maxHealth = 10;
	int experience = 0;
	int money = 0;
	int experienceNeeded = 5;
	ArrayList<Item> inventory = new ArrayList<Item>();

	/**
	 * Levels up the player and
	 */
	public void levelUp() {
		int temp;
		int bonusHealth;
		// Checks to see if the exp >= the experience needed to level up
		while (experience >= experienceNeeded) {
			level++;
			temp = experience - experienceNeeded;
			// Changes the experience needed according to level
			experienceNeeded = 5 * level;
			experience = temp;
			// If the user levels up to a multiple of 5
			if (level % 5 == 0) {
				temp = (int) (Math.random() * (2 * 3) + 1);
				bonusHealth = (int) (Math.random() * (2 * 3) + 3);
			} else {
				temp = (int) (Math.random() * (1.5 * 2) + 1);
				bonusHealth = (int) (Math.random() * (1.5 * 2) + 2);
			}
			System.out.println("\nYou have leveled up!" + "\nlv." + level + " " + name + "\n+" + bonusHealth + " HP"
					+ "\n+" + temp + " Atk\n\nExperience until next level up:" + experienceNeeded);
			// Increase stats
			damage += temp;
			health += bonusHealth;
			maxHealth += bonusHealth;
			System.out.println("\nLv." + level + " " + name + " >> " + getPlayerHealthBar() + " Atk:" + damage + " "
					+ experience + "exp\n");
		}
	}

	/**
	 * Creates player health into "*"
	 * 
	 * @return players health in "*"
	 */
	public String getPlayerHealthBar() {
		String playerHp = "Hp:";
		if (health < 51) {
			for (int i = 0; i < health; i++) {
				playerHp += '*';
			}
			return playerHp;
		} else {
			return "HP:" + health;
		}
	}
}
