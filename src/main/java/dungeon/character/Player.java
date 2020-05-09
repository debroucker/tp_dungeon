package dungeon.character;
import java.util.*;
 
import dungeon.action.*;
import dungeon.dungeon.*;

/**
 * The class Player extends the abstract class GameCharacter.
 * This class represent the player in the dungeon.
 */
public class Player extends GameCharacter {
	
	protected HashMap<String, Action> allActions;
	
	/**
	 * Constructor of the object player.
	 * @param lifepoint : an int that represents the amount of life points of the player.
	 * @param strength : an int that represents the amount of point of strength of the player. 
	 * @param gold : an int that represents the amount of gold pieces of the player.
	 * @param name : a String, the name of the player.
	 * @param game : an instance of the AdventureGame class.
	 */
	public Player(int lifepoint, int strength, int gold, String name, AdventureGame game) {
		super(lifepoint, strength, gold, name, game);
		this.allActions = new HashMap<String, Action>();
	}
	
	/**
	 * Methods which represent the progress of a fight with a monster.
	 * @param other : a GameCharacter who represent the opponent.
	 */
	public void attackMonster(GameCharacter other) {
		this.attack(other);
		this.displayPlayerHitMonster(other);
		if (!other.isDead()) {
			other.attack(this);
			this.displayMonsterHitPlayer(other);
		}
	}
	
	/**
	 * Displaying of the player hitting a monster.
	 * @param other : the monster to hit.
	 */
	public void displayPlayerHitMonster(GameCharacter other) {
		System.out.println("You just hit " + other.getName() + ".");
		System.out.println(other.getName() + " just lost " + this.getStrength() + " lifepoints.");
		System.out.println(other.getName() + " has got " + other.getLifepoint() + " remaining lifepoints.");
	}
	
	/**
	 * Displaying of the monster hitting the player.
	 * @param other : the monster to hit.
	 */
	public void displayMonsterHitPlayer(GameCharacter other) {
		System.out.println(other.getName() + " just hit " + this.getName() + ".");
		System.out.println("You just lost " + other.getStrength() + " lifepoints.");
		System.out.println("You has got " + this.getLifepoint() + " remaining lifepoints.");
	}

	/**
	 * Execute the action that have been chosen by the player.
	 * @param c : the action that have been chosen.
	 */
	public void act(int c) {
		possibleAction().get(c).execute(this);
	}
	
	/**
	 * Methods that add an action to the possible actions list.
	 * @param actionToAdd the action we want to add to the list.
	 */
	public void addAction(Action actionToAdd) {
		allActions.put(actionToAdd.getActionName(), actionToAdd);
	}
	
	/**
	 * Method that return the Action correlated with her name.
	 * @param str : the name of the Action to get.
	 * @return the Action we want to get.
	 */
	public Action getAction(String str) {
		return allActions.get(str);
	}

	/**
	 * Method that return the all Actions.
	 * @return the all Actions.
	 */
	public List<Action> getAllActions(){
		List<Action> res = new ArrayList<Action>();
		res.addAll(this.allActions.values());
        return res;
	}
	
	/**
	 * Method that provide the list of the possible actions for the player.
	 * @return the list of the possible actions for the player.
	 */
	public List<Action> possibleAction(){
		List<Action> res = new ArrayList<Action>();
		for(Action a : getAllActions()){
			if(a.isPossible(this, this.getGame()))
				res.add(a);
		}
		return res;
	}
	
	/**
	 * String representation of the player.
	 */
	public String toString(){
		return "You have " + this.getLifepoint() + " hp, " + this.getStrength() + " strength points and " + this.getGold() + " gold.";

	}
	
}
