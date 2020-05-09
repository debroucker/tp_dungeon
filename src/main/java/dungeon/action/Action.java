package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;


/**
 * interface that implements the functions execute and isPossible.
 */
public interface Action {
    public void execute(Player p);
    public boolean isPossible(Player p, AdventureGame g);
	public String getActionName();
}