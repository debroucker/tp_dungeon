package dungeon.action;
import dungeon.character.*;
import dungeon.dungeon.*;
import java.util.*;

/**
 * AttackAction class extends the abstract class ActionAdaptor.
 * This class represents the offensive choice of the player.
 */
public class AttackAction extends ActionAdaptor {

	
	/**
	 * Constructor of the AttackAction class.
	 * @param n a string : the name of the AttackAction object.
	 */
    public AttackAction(String n){
        super(n);
    }
    
    /**
     * This method execute the player choice, which is to attack the opponent.
     * @param p the player.
     */
    public void execute(Player p) {
        List<Monster> listOfPossiblesMonsters = p.getGame().currentRoom().getMonsters();
        int nbOfMonsters = listOfPossiblesMonsters.size();
        displayThePossiblesMonsters(listOfPossiblesMonsters);
        int choice = takeChoice(nbOfMonsters);
        Monster monsterToHit = listOfPossiblesMonsters.get(choice-1);
    	while( !p.isDead() && !monsterToHit.isDead()) {
            p.attackMonster(monsterToHit);
        }
        if(monsterToHit.isDead()){
            monsterToHit.die();
            p.getGame().currentRoom().getMonsters().remove(choice-1);
        }
    }

    public int takeChoice(int nbMonsters){
        System.out.println("Choose a Monster correlated with her number :");
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int choice = sc.nextInt();
    	while( ! (choice > 0 && choice <= nbMonsters) ) {
    		System.out.println("You choose a wrong number, try again :");
            choice = sc.nextInt();
        }
        return choice;
    }

    public void displayThePossiblesMonsters(List<Monster> listMonsters){
        int i = 1;
        System.out.println("Here are the monsters that are in the room :");
		for (Monster monster : listMonsters) {
			System.out.println("Monster number " + i + " : " + monster.toString());
			i++;
		}
    }
    
    /**
     * This method says if it's possible to attack an opponent.
     * @param p the player.
     * @param g the instance of AdventureGame.
     * @return a boolean : true if it's possible, false otherwise.
     */
    public boolean isPossible(Player p, AdventureGame g){
        return g.currentRoom().getMonsters().size() >= 1;
    }

    public String toString(){
		return "Attack monster";
	}
}