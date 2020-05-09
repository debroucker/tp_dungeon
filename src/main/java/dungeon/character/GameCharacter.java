package dungeon.character;
import dungeon.dungeon.*;

/**
 * Abstract class which allows to create a new GameCharacter with the following attributes :
 */
public abstract class GameCharacter {

	protected int lifepoint;
	protected int strength;
	protected int gold;
	protected String name;
	protected AdventureGame game;
	
	/**
	 * Constructor of the abstract object GameCharacter.
	 * @param lifepoint : an int that represents the amount of life points of the character.
	 * @param strength : an int that represents the amount of point of strength of the character. 
	 * @param gold : an int that represents the amount of gold pieces of the character.
	 * @param name : a String, the name of the character.
	 * @param game : an instance of the AdventureGame class.
	 */
	public GameCharacter(int lifepoint, int strength, int gold, String name, AdventureGame game) {
		this.lifepoint = lifepoint;
		this.strength = strength;
		this.gold = gold;
		this.name = name;
		this.game = game;
	}
	
	/**
	 * Return the instance of the current dungeon.
	 * @return the instance of the current dungeon.
	 */
	public AdventureGame getGame() {
		return this.game;
	}
	
	/**
	 * Returns the life points of the character.
	 * @return the life points of the character.
	 */
	public int getLifepoint() {
		return this.lifepoint;
	}
	
	/**
	 * Returns the amounts of strength of a character.
	 * @return the amounts of strength of a character.
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Return the amount of gold pieces of the character.
	 * @return the amount of gold pieces of the character.
	 */
	public int getGold() {
		return this.gold;
	}
	
	/**
	 * Return the name of the character. 
	 * @return the name of the character.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Add the amount of life points passed in parameter.
	 * @param toAdd the amount of life points to add.
	 */
	public void changeLifepoint(int toAdd) {
		this.lifepoint += toAdd;
	}
	
	/**
	 * Add the amount of strength passed in parameter.
	 * @param toAdd the amount of strength to add.
	 */
	public void changeStrength(int toAdd) {
		this.strength += toAdd;
	}
	
	/**
	 * Add the amount of gold passed in parameter.
	 * @param toAdd the amount of gold to add.
	 */
	public void changeGold(int toAdd) {
		this.gold += toAdd;
	}
	
	/**
	 * Allows to change the name of the character.
	 * @param newName : the new name of the character.
	 */
	public void changeName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Decrease the life points of the opponent.
	 * @param otherCharacter : the opponent to attack.
	 */
	public void attack(GameCharacter otherCharacter) {
		otherCharacter.lifepoint -= this.getStrength();
	}
	
	/**
	 * Tells if the current character is dead or not.
	 * @return a boolean : true if he's dead, false otherwise.
	 */
	public boolean isDead() {
		return this.lifepoint <= 0;
	}
	
	/**
	 * Methods that provide a String representation of the character's death. 
	 */
	public void die() {
		System.out.println("============================");
		System.out.println("| YOU ARE DEAD, GAME OVER. | ");
		System.out.println("============================\n");
	}

}
