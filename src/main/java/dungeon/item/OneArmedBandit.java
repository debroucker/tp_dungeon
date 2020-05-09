package dungeon.item;
import dungeon.character.*;
import java.util.*;

/** 
 * This class implements the item interface.
 * An OneArmedBandit creates randomly a new object in exchange of a certain amount of gold.
 */
public class OneArmedBandit implements Item {
	private int goldToGive;
	private int givenLifePoint;
	private int givenStrength;
	private int givenGold;
	
	/**
	 * Constructor of an instance of OneArmedBandit.
	 * @param goldToGive : the amount of gold to give to use it.
	 * @param givenLifePoint : the lifepoints given by the One Armed Bandit.
	 * @param givenStrength : the strength given by the One Armed Bandit.
	 * @param givenGold : the gold given by the One Armed Bandit.
	 */
	public OneArmedBandit(int goldToGive, int givenLifePoint, int givenStrength, int givenGold) {
		this.goldToGive = goldToGive;
		this.givenLifePoint = givenLifePoint;
		this.givenStrength = givenStrength;
		this.givenGold = givenGold;
	}
	
	/**
	 * Return the amount of gold to give to use this OneArmedBandit.
	 * @return the amount of gold to give to use this OneArmedBandit.
	 */
	public int getGoldToGive() {
		return this.goldToGive;
	}
	
	/**
	 * Return the amount of LifePoints that gives this OneArmedBandit.
	 * @return the amount of LifePoints the gives this OneArmedBandit.
	 */
	public int getGivenLifePoint() {
		return this.givenLifePoint;
	}
	
	/**
	 * Return the amount of Strength that gives this OneArmedBandit.
	 * @return the amount of Strength that gives this OneArmedBandit.
	 */
	public int getGivenStrength() {
		return this.givenStrength;
	}
	
	/**
	 * Return the amount of gold that gives this OneArmedBandit.
	 * @return the amount of gold that gives this OneArmedBandit.
	 */
	public int getGivenGold() {
		return this.givenGold;
	}
	
	
	/**
	 * Allows the player to use the OneArmedBandit.
	 * @param p : the player.
	 */
	public void use(Player p) {
		if (p.getGold() < this.getGoldToGive()) {
			System.out.println("You don't have enough gold.");
		} else {
			System.out.println("Let's play a game.");
			Random rand = new Random();
			int n = rand.nextInt(3);
			if (n == 0) {
				HealthPotion hp = new HealthPotion(this.getGivenLifePoint());
				hp.use(p);
			} else if (n == 1) {
				GoldPurse gp = new GoldPurse(this.getGoldToGive());
				gp.use(p);
			} else {
				StrengthPotion sp = new StrengthPotion(this.getGivenStrength());
				sp.use(p);
			}
			}
	}		
	
	/**
	 * Provides a String representation of the OneArmedBandit.
	 * @return a String representation of the OneArmedBandit.
	 */
	public String toString() {
		return "This OneArmedBandit requires " + this.getGoldToGive() + " to be used";
	}
}
