package dungeon.tests;
import dungeon.action.*;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.item.*;
import dungeon.room.*;
import org.junit.Before;
import org.junit.*;

public class UseActionTest {

  private UseAction useAction;
  private Player player;
  private Room startingRoom;
  private AdventureGame game;
  private Item item;

  @Before
  public void init(){
    this.useAction = new UseAction("useAction");
    this.startingRoom = new Room("startingRoom");
    this.game = new AdventureGame(this.startingRoom);
    this.player = new Player(15, 5, 10,"player", this.game);
    this.item = new GoldPurse(10);
  }

  @Test
  public void isNotPossibleTest(){
    Assert.assertFalse(this.useAction.isPossible(this.player, this.game));
  }

  @Test
  public void isPossibleTest(){
    this.game.currentRoom().addItem(this.item);
    Assert.assertTrue(this.useAction.isPossible(this.player, this.game));
  }


}
