package typeQuest;

public class Enemy extends Character{
	String basicAbility = "";
	boolean money;

	/**
	 * Print out the enemies health in '*'
	 * 
	 * @return
	 */
	public String getEnemyHealthBar() {
		String neMeHp = "Hp:";
		if (health < 51) {
			for (int i = 0; i < health; i++) {
				neMeHp += '*';
			}
			return neMeHp;
		} else {
			return "HP:" + health;
		}
	}
	
	// @Override
	public String toString() {
		return "Lv." + level + " " + name;
	}
}
