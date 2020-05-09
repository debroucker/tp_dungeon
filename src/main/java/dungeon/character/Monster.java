package dungeon.character;
import dungeon.dungeon.*;

/**
 * The class Monster implements the abstract class GameCharacter.
 * Monster represents the player's opponent in the dungeons.
 */
public class Monster extends GameCharacter {
	
	/**
	 * Constructor of the Monster object.
	 * @param lifepoint : an int that represents the amount of life points of the monster.
	 * @param strength : an int that represents the amount of point of strength of the monster. 
	 * @param gold : an int that represents the amount of gold pieces of the monster.
	 * @param name : a String, the name of the monster.
	 * @param game : an instance of the AdventureGame class.
	 */
	public Monster(int lifepoint, int strength, int gold, String name, AdventureGame game) {
		super(lifepoint, strength, gold, name, game);
	}
	
	/**
	 * Methods that provide gold to the player when the monster is dead. 
	 */
	public void die() {
		System.out.println("-> You kill the monster.");
		this.getGame().getPlayer().changeGold(this.getGold());
	}

	/**
	 * String representation of a monster.
	 */
	public String toString(){
		return "He has " + this.getLifepoint() + " hp, " + this.getStrength() + " strength points and " + this.getGold() + " gold.";
	}

}
