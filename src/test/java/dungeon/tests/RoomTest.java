package dungeon.tests;
import dungeon.room.*;
import org.junit.Before;
import org.junit.*;


public class RoomTest {

  private Room room1;
  private Room room2;

  @Before
  public void init(){
    this.room1 = new Room("room1");
    this.room2 = new Room("room2");
  }

  @Test
  public void changeRoomTest(){
    this.room1.addNeighboors(Direction.North, this.room2);
    this.room2.addNeighboors(Direction.South, this.room1);
    Assert.assertEquals(this.room1.changeRoom(Direction.North), this.room2);
  }


}
