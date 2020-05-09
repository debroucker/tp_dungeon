package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;
/**
 * LookAction extends the abstract class ActionAdaptor.
 * This class allows the player to look upon a room and see his content.
 */
public class LookAction extends ActionAdaptor {
	
	/**
	 * Constructor of the LookAction class.
	 * @param n the name of the LookAction object.
	 */
    public LookAction(String n){
        super(n);
    }
    
    /**
     * Allows the player to look upon the room and see his content.
     * @param p : the player.
     */
    public void execute(Player p) {
    	System.out.println(p.getGame().currentRoom().toString());   
    }
    
    
    
    /**
     * This method says if it's possible to attack an opponent.
     * @param p the player.
     * @param g the instance of AdventureGame.
     * @return a boolean : true.
     */
    public boolean isPossible(Player p, AdventureGame g) {
    	return true;
    }
    public String toString(){
		return "Look upon what's in the room";
	}
}