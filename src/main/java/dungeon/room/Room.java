package dungeon.room;
import java.util.*;
import dungeon.character.*;
import dungeon.item.*;

/**
 * Class that represents a room of the dungeon.
 */
public class Room {
    
    protected List<Monster> monsters;
    protected List<Item> items;
    protected Map<Direction, Room> neighboors;
    protected String name;

    /**
     * Constructor of an instance of Room.
     * @param n : the name of the room.
     */
    public Room(String n){
        this.name = n;
        this.monsters = new ArrayList<Monster>();
        this.items = new ArrayList<Item>();
        this.neighboors = new HashMap<Direction, Room>();
    }
    
    /**
     * Allows to add monster in the room.
     * @param m : the monster to add.
     */
    public void addMonster(Monster m){
        this.monsters.add(m);
    }
    
    /**
     * Return the name of the room.
     * @return the name of the room.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Allows to add an item to the room.
     * @param i : the item to had.
     */
    public void addItem(Item i){
        this.items.add(i);
    }
    
    /**
     * Allows to add an adjacent room to this room.
     * @param d : the direction where we want to set the room.
     * @param r : the room we want to associate to the direction.
     */
    public void addNeighboors(Direction d, Room r){
        this.neighboors.put(d,r);
    }
    
    /**
     * Provides the list of the monsters which are in the room.
     * @return the list of the monsters which are in the room.
     */
    public List<Monster> getMonsters(){
        return this.monsters;
    }
    
    /**
     * Provides the list of items available in the room.
     * @return the list of items available in the room.
     */
    public List<Item> getItems(){
        return this.items;
    }
    
    /**
     * Return the adjacent rooms of this room.
     * @return the adjacent rooms of this room.
     */
    public List<Room> getNeighboors(){
        List<Room> res = new ArrayList<Room>();
        res.addAll(this.neighboors.values());
        return res;
    }

    /**
     * Return the different directions available to the player.
     * @return the different directions available to the player.
     */
    public List<Direction> getDirection(){
        List<Direction> dir = new ArrayList<Direction>();
        dir.addAll(this.neighboors.keySet());
        return dir;
    }
    
    /**
     * Tells if this room is an exit room.
     * @return false, exit room are implemented in another class.
     */
    public boolean isExit(){
        return false;
    }
    
    /**
     * Methods that permits to change room.
     * @param dir : the direction where we want to go.
     * @return the direction where we want to go.
     */
    public Room changeRoom(Direction dir) {
    	return this.neighboors.get(dir);
    }
    
    /**
     * A generic methods that allow us to represent list of any types.
     * @param l the list we want to represent.
     * @return the string representation of this list. 
     */
    public String listToString(List<?> l) {
    	int i = 1;
    	String res = "";
    	Iterator <?> iterator = l.iterator();
    	while(iterator.hasNext()) {
    		res += i + " : " + iterator.next().toString() + ".\n";
    		i++;
    	} return res;
    }

    
    /**
     * Overiding the equals method.
     * @param otherRoom : the room to compare.
     * @return true if two rooms are equals, false otherwise.
     */
    public boolean equals(Room otherRoom){
        return this.getName().equals(otherRoom.getName());
    }
    
    /**
     * Provides a string representation of the room.
     * @return a string representation of the room.
     */
    public String toString() {
        String res = "There is in this room : \n";
        if(this.getItems().size() > 0)
            res += "-> Item(s) : " + "\n" + listToString(this.getItems());
        if(this.getMonsters().size() > 0)
            res += "-> Monster(s) : " + "\n" + this.listToString(this.getMonsters());
        if(this.getDirection().size() > 0)
            res += "-> Direction(s) available : " + "\n" + this.listToString(this.getDirection());
        return res;
    }
    
}