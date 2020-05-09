package dungeon.room;

/**
 * An inherited class that represents the exit room of the dungeon.
 */
public class ExitRoom extends Room {

	/**
	 * Constructor of the Exit Room.
	 * @param n : the name of the ExitRoom.
	 */
    public ExitRoom(String n){
        super(n);
    }
    
    /**
     * Tells if this room is an exit room.
     * @return true.
     */
    public boolean isExit(){
        return true;
    }
}