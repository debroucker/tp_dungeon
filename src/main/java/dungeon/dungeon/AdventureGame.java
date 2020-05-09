package dungeon.dungeon;
import dungeon.room.*;
import dungeon.character.*;
import dungeon.item.*;
import java.util.*;
import dungeon.action.*;

/**
 * The class AdventureGame represent the current instance of the game.
 */
public class AdventureGame {

    private Room currentRoom;
    private Player player;

    /**
     * The constructor of an instance of AdventureGame.
     * @param stratingRoom the room where the player start his journey.
     */
    public AdventureGame(Room stratingRoom){
        this.currentRoom = stratingRoom;
    }
    
    /**
     * Provide the room in which is the player.
     * @return the room in which is the player.
     */
    public Room currentRoom(){
        return this.currentRoom;
    }
    
    /**
     * Return the player which is in the dungeon.
     * @return the player which is in the dungeon.
     */
    public Player getPlayer(){
        return this.player;
    }
    
    /**
     * Method which to set a player in the game the progress of the game.
     * @param p the player to add.
     */
    public void addPlayer(Player p){
        this.player = p;
    }
    
    /**
     * Methods that allows to add a monster in the chosen room.
     * @param m : The monster we want to add.
     * @param r : The room where we want to put the monster.
     */
    public void addMonster(Monster m, Room r){
        r.addMonster(m);
    }

    /**
     * Method that allows to add an item in the chosen room.
     * @param i : the item we want to add.
     * @param r : the room where we want to put the item.
     */
    public void addItem(Item i, Room r){
        r.addItem(i);
    }
    
    /**
     * Method that says if the game is over or not.
     * @return a boolean : true if the game is over, false otherwise.
     */
    public boolean isFinished(){
        return this.getPlayer().isDead() || this.currentRoom().isExit();
    }
    
    /**
     * Setter that allows to change the currentRoom (which is the room where we are)
     * @param roomToSet : the room we want to set.
     */
    public void setRoom(Room roomToSet) {
    	this.currentRoom = roomToSet;
    }
    
    /**
     * Methods that change the current room following the direction which were chosen by the player.
     * @param dir : the direction where we want to go.
     */
    public void playerMoveTo(Direction dir) {
    	Room roomToMove = this.currentRoom().changeRoom(dir);
    	this.setRoom(roomToMove);
    }
    
    /**
     * Create a board for the dungeon.
     * @param startingRoom : the starting room of the dungeon.
     */
    public void createBoard(Room startingRoom){
        // Creating rooms : 
        Room exitRoom = new ExitRoom("exitRoom"); 
        Room room1 = new Room("1");
        Room room2 = new Room("2");
        Room room3 = new Room("3");
        Room room4 = new Room("4");
        Room room5 = new Room("5");
        Room room6 = new Room("6");
        Room room7 = new Room("7");
        Room room8 = new Room("8");
        Room roomBonus_3 = new Room("bonus_3");
        Room roomBonus_5 = new Room("bonus_5");
        // Add items in the rooms.
        
        // Room 1 : 
        room1.addItem(new HealthPotion(20));
        room1.addItem(new StrengthPotion(15));
        // Room 2 :
        room2.addItem(new GoldPurse(10));
        room2.addMonster(new BuilderLittleMonster(this));
        // Room 3 :
        room3.addItem(new HealthPotion(10));
        room3.addMonster(new BuilderLittleMonster(this));
        room3.addMonster(new BuilderLittleMonster(this));
        // Room 4 :
        room4.addItem(new HealthPotion(50));
        room4.addMonster(new BuilderMediumMonster(this));
        room4.addMonster(new BuilderMediumMonster(this));
        room4.addMonster(new BuilderMegaMonster(this));
        // Room 5 : 
        room5.addItem(new HealthPotion(20));
        room5.addMonster(new BuilderMediumMonster(this));
        room5.addMonster(new BuilderMediumMonster(this));
        // Room 6 : 
        room6.addMonster(new BuilderMegaMonster(this));
        // Room 7 : 
        room7.addItem(new GoldPurse(10));
        // Room 8 : 
        room8.addMonster(new BuilderMegaMonster(this));
        room8.addMonster(new BuilderLittleMonster(this));
        // One armed Bandit : 
        roomBonus_3.addItem(new OneArmedBandit(50, 55, 25, 10));
        roomBonus_5.addItem(new OneArmedBandit(70, 70, 40, 20));
        // Adding neighbors : 
        // Of the starting room :
        startingRoom.addNeighboors(Direction.North, room1);
        // Room 1 : 
        room1.addNeighboors(Direction.North, room2);
        room1.addNeighboors(Direction.East, room6);
        // Room 2 : 
        room2.addNeighboors(Direction.North, room5);
        room2.addNeighboors(Direction.East, room7);
        room2.addNeighboors(Direction.West, room3);
        room2.addNeighboors(Direction.South, room1);
        // Room 3 : 
        room3.addNeighboors(Direction.North, room4);
        room3.addNeighboors(Direction.East, room2);
        room3.addNeighboors(Direction.South, roomBonus_3);
        // Room 4 : 
        room4.addNeighboors(Direction.North, exitRoom);
        room4.addNeighboors(Direction.East, room5);
        room4.addNeighboors(Direction.South, room3);
        // Room 5 : 
        room5.addNeighboors(Direction.West, room4);
        room5.addNeighboors(Direction.East, roomBonus_5);
        room5.addNeighboors(Direction.South, room2);
        // Room 6 : 
        room6.addNeighboors(Direction.West, room1);
        // Room 7 : 
        room7.addNeighboors(Direction.West, room2);
        // Room 8 : 
        room8.addNeighboors(Direction.West, exitRoom);
        room8.addNeighboors(Direction.South, roomBonus_5);
        // Bonus : 
        roomBonus_3.addNeighboors(Direction.North, room3);
        roomBonus_5.addNeighboors(Direction.West, room5);
        roomBonus_5.addNeighboors(Direction.North, room8);
        // Exit : 
        exitRoom.addNeighboors(Direction.East, room8);
        exitRoom.addNeighboors(Direction.South, room4);
    }
    
    /**
     * Algorithm of the game.
     */
    public void play(){
        System.out.println("\n===================================");
        System.out.println("| WELCOME TO THE DUNGEON OF DEATH |");
        System.out.println("===================================");
        while(!this.getPlayer().isDead()){
            System.out.println("\n============================");
            System.out.println("You are in the " + this.currentRoom().getName() + " room.");
            System.out.println("=================================================");
            System.out.println(this.getPlayer().toString());
            System.out.println("=================================================\n");
            int choice = this.ListChooser();
            this.getPlayer().act(choice);
        }
        if (this.getPlayer().isDead()){
            this.getPlayer().die();
        }
        else{
            System.out.println("=============");
            System.out.println("| YOU WON ! |");
            System.out.println("=============\n");  
        }
    }
    
    /**
     * Chose an item upon a list with the Scanner class.
     * @return the number chosen upon the list.
     */
    public int ListChooser(){
        System.out.println("Here are the following action you can do :");
        System.out.print(this.currentRoom().listToString(this.getPlayer().possibleAction()));
        System.out.println("Choose an action by giving her corresponding number :");
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	int choice = sc.nextInt();
    	while( ! (choice > 0 && choice <= this.getPlayer().possibleAction().size()) ){
    		System.out.println("You choose a wrong number, try again :");
    		choice = sc.nextInt();
    	}
        return choice-1;
    }
    
    public static void main(String[] args) {
        Room startingRoom = new Room("starting");
        AdventureGame g = new AdventureGame(startingRoom);
        g.createBoard(startingRoom);
        Player p1 = new Player(200, 35, 0, "Michoux", g);
        g.addPlayer(p1);
        p1.addAction(new LookAction("lookAction"));
        p1.addAction(new UseAction("useAction"));
        p1.addAction(new MoveAction("moveAction"));
        p1.addAction(new AttackAction("acctackAction"));
        g.play();
    }

}