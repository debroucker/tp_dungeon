package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;



/**
 * Abstract class which implements the Action's interface.
 *
 */
public abstract class ActionAdaptor implements Action{

    protected String name;

    /** Constructor of the abstract class ActionAdaptor.
     * @param n a String : the name of the Action we want to create.
     */
    public ActionAdaptor(String n){
        this.name = n;
    }
    
    /**
     * Getter of the ActionAdaptor object which returns the action's name.
     * @return the Action's name.
     */
    public String getActionName(){
        return this.name;
    }
    
    /**
     * Abstract method which allows the player to make an action.
     * @param p the player.
     */
    public abstract void execute(Player p);
    
    /**
     * Abstract method which says if an Action is possible or not.
     * @param p the player.
     * @return a boolean : true if the action is possible, false otherwise.
     */
    public boolean isPossible(Player p, AdventureGame g){
        return true;
    }
}