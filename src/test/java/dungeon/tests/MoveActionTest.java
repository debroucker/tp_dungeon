package dungeon.tests;
import dungeon.action.*;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.room.*;
import org.junit.Before;
import org.junit.*;



public class MoveActionTest {

  private MoveAction moveAction;
  private Player player;
  private Room startingRoom;
  private AdventureGame game;
  private Monster monster;

  @Before
  public void init(){
    this.moveAction = new MoveAction("moveAction");
    this.startingRoom = new Room("startingRoom");
    this.game = new AdventureGame(this.startingRoom);
    this.player = new Player(15, 5, 10,"player", this.game);
    this.monster = new BuilderLittleMonster(game);
  }

  @Test
  public void isPossibleTest(){
    Assert.assertTrue(this.moveAction.isPossible(this.player, this.game));
  }

  @Test
  public void isNotPossibleTest(){
    this.game.currentRoom().addMonster(this.monster);
    Assert.assertFalse(this.moveAction.isPossible(this.player, this.game));
  }

  

}
