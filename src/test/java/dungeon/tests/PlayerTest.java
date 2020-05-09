package dungeon.tests;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.room.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.*;

public class PlayerTest extends CharacterTest {

	@Before 
	public void init() {
	Room startingRoom = new Room("starting");
    AdventureGame g = new AdventureGame(startingRoom);
    p1 = new Player(200, 35, 0, "Adil", g);
    medMonster = new BuilderMediumMonster(g);
	}
	
	@Test
	public void attackMonsterWorksProperly() {
		p1.attackMonster(medMonster);
		assertEquals(160, p1.getLifepoint());
		assertEquals(35, medMonster.getLifepoint());
	}

}
