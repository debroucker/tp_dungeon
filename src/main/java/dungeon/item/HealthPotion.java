package dungeon.item;
import dungeon.character.*;

/**
 * Class that implements the item interface. 
 * HealthPotion represents a potion who heal the player.
 */
public class HealthPotion implements Item {

    private int health;
    
    /**
     * Constructor of the HealthPotion.
     * @param h : the amount of life points this potion give back to the player.
     */
    public HealthPotion(int h){
        this.health = h;
    }
    
    /**
     * Return the amount of life points this potion give back to the player.
     * @return the amount of life points this potion give back to the player.
     */
    public int getHealth(){
        return this.health;
    }
    
    /**
     * Method that allows the player to use the HealthPotion.
     */
    public void use(Player p){
        p.changeLifepoint(this.getHealth());
    }
    
    /**
     * Method that provide a String representation of the healthPotion.
     */
    public String toString(){
        return "This potion heals " + this.getHealth() + " life points.";
    }
}