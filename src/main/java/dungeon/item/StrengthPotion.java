package dungeon.item;
import dungeon.character.*;

/**
 * Class that implements the item interface.
 * This class represents a potion who gives more strength to the player.
 */
public class StrengthPotion implements Item {

    private int strenght;

    /**
     * Constructor of the strength potion.
     * @param s : the amount of strength this potion gives.
     */
    public StrengthPotion(int s) {
        this.strenght = s;
    }
    
    /**
     * Return the amount of strength this potion gives.
     * @return the amount of strength this potion gives.
     */
    public int getStrength(){
        return this.strenght;
    }

    /**
     * Allows the player to use the StrengthPotion.
     */
    public void use(Player p){
        p.changeStrength(this.getStrength());
    }
    
    /**
     * Provide a String representation of the StrengthPotion.
     * @return a String representation of the StrengthPotion.
     */
    public String toString(){
        return "This potion gives " + this.getStrength() + " strength points";
    }
}