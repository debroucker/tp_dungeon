package dungeon.item;
import dungeon.character.*;

/**
 * Class that implements the Item interface.
 * This class represents the GoldPurse.
 */
public class GoldPurse implements Item {

    private int gold;
    
    /**
     * Constructor of the gold purse class.
     * @param g : the amount of gold we want the GoldPurse to contain.
     */
    public GoldPurse(int g){
        this.gold = g;
    }
    
    /**
     * Return the amount of gold that contains the purse.
     * @return the amount of gold that contains the purse.
     */
    public int getGoldPurse(){
        return this.gold;
    }
    
    /**
     * Method that allows the player to use the GoldPurse item.
     */
    public void use(Player p){
        p.changeGold(this.getGoldPurse());
    }
    
    /**
     * A String representation of GoldPurse's content.
     */
    public String toString(){
        return "The purse contains " + this.getGoldPurse() + " pieces of gold.";
    }
}