package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.item.*;
import java.util.*;

/**
 * UseAction extends the abstract class ActionAdaptor.
 * This class allows the player to use an item.
 */
public class UseAction extends ActionAdaptor {

	/**
	 * Constructor of the UseAction class.
	 * @param n the name of the UseAction object.
	 */
    public UseAction(String n){
        super(n);
    }

	/**
	 * Allows the player to use an item.
	 * @param p : the player.
	 */
	public void execute(Player p) {
		List<Item> listOfPossiblesItems = p.getGame().currentRoom().getItems();
		int nbOfItems = listOfPossiblesItems.size();
		this.displayThePossiblesItems(listOfPossiblesItems);
		int choice = this.takeChoice(nbOfItems);
		Item itemChoosen = listOfPossiblesItems.get(choice-1);
		p.getGame().currentRoom().getItems().remove(choice-1);
		itemChoosen.use(p);
	}
	
	/**
	 * Allow the player to chose an item which is on the room.
	 * @param nbItems : the number of item in the room.
	 * @return the chosen item.
	 */
	public int takeChoice(int nbItems){
		System.out.println("Choose an Item correlated with her number :");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		while( ! (choice > 0 && choice <= nbItems)) {
			System.out.println("You choose a wrong number, try again :");
			choice = sc.nextInt();
		}
		return choice;
	}
	
	/**
	 * Methods that provide a displaying of the items in the room.
	 * @param listItems : the items in the room.
	 */
	public void displayThePossiblesItems(List<Item> listItems){
		int i = 1;
		System.out.println("Here are the possible(s) Item(s) :");
		for (Item item : listItems) {
			System.out.println("Item number : " + i + " : " + item.toString());
			i++;
		}
	}

    
	/**
	 * Says if it's possible to use an object.
	 * @param p : the player.
	 * @param g : the current instance of AdventureGame.
	 * @return a boolean : true if it's possible, false otherwise.
	 */
    public boolean isPossible(Player p, AdventureGame g){
        return g.currentRoom().getItems().size() >= 1;
	}
	
	public String toString(){
		return "Use Item";
	}
}