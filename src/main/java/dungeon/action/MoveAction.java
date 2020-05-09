package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.room.*;
import java.util.*;

/**
 * MoveAction extends the abstract class ActionAdaptor.
 * This class allows the player to move to another room.
 */
public class MoveAction extends ActionAdaptor {

	/**
	 * Constructor of the MoveAction class.
	 * @param n the name of the MoveAction object.
	 */
    public MoveAction(String n){
        super(n);
    }
    
    /**
     * Allows the player to move to another room.
     * @param p : the player.
     * TO DO : checker pour le type du tableau de directions.
     */
    public void execute(Player p) {
		List<Direction> listOfDirections = p.getGame().currentRoom().getDirection();
		int nbOfDirections = listOfDirections.size();
		this.displayThePossiblesDirections(listOfDirections);
		int choice = takeChoice(nbOfDirections);
		Direction dirChosen = listOfDirections.get(choice-1);
		p.getGame().playerMoveTo(dirChosen);
	}

	public int takeChoice(int nbOfDir){
		System.out.println("Choose a direction correlated with her number :");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		while( ! (choice > 0 && choice <= nbOfDir)) {
			System.out.println("You choose a wrong number, try again :");
			choice = sc.nextInt();
		}
		return choice;
	}
	
	public void displayThePossiblesDirections(List<Direction> listDirections){
		int i = 1;
		System.out.println("Here are the possible directions :");
		for (Direction direction : listDirections) {
			System.out.println(i + " : " + direction.toString() + ".");
			i++;
		}
    }

	/**
	 * Says if its possible to move to another room.
	 * @param p : the player.
	 * @param g : the current instance of AdventureGame.
	 * @return a boolean : true if it's possible, false otherwise.
	 */
    public boolean isPossible(Player p, AdventureGame g){
        return g.currentRoom().getMonsters().size() == 0;
	}
	
	public String toString(){
		return "Move to the next room";
	}
}