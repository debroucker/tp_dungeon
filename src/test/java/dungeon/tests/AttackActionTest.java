package dungeon.tests;
import dungeon.action.*;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.room.*;
import org.junit.Before;

import org.junit.Test;
import org.junit.Assert;

public class AttackActionTest {

  private AttackAction attackAction;
  private Player player;
  private Room startingRoom;
  private AdventureGame game;
  private Monster monster;

  @Before
  public void init(){
    this.attackAction = new AttackAction("attackAction");
    this.startingRoom = new Room("startingRoom");
    this.game = new AdventureGame(this.startingRoom);
    this.player = new Player(15, 5, 10,"player", this.game);
    this.monster = new BuilderLittleMonster(game);
  }

  @Test
  public void isNotPossibleTest(){
    Assert.assertFalse(this.attackAction.isPossible(this.player, this.game));
  }

  @Test
  public void isPossibleTest(){
    this.game.currentRoom().addMonster(this.monster);
    Assert.assertTrue(this.attackAction.isPossible(this.player, this.game));
  }

}
