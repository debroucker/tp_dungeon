package dungeon.tests;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.room.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.*;




public class MonsterTest extends CharacterTest {

	@Before 
	public void init() {
	Room startingRoom = new Room("starting");
    AdventureGame g = new AdventureGame(startingRoom);
    p1 = new Player(200, 35, 0, "Adil", g);
    medMonster = new BuilderMediumMonster(g);
    almostDeadMonster = new Monster (1, 1, 20, "almostDead", g);
    g.setRoom(startingRoom);
    g.addPlayer(p1);
    g.addMonster(almostDeadMonster, startingRoom);
	}
	
	@Test
	public void attackPlayerWorksProperly() {
		medMonster.attack(p1);
		assertEquals(160, p1.getLifepoint());
	}
	
	@Test
	public void monsterDieAndPlayerGetsGold() {
		p1.attack(almostDeadMonster);
		assertTrue(almostDeadMonster.isDead());
		almostDeadMonster.die();
		assertEquals(20, p1.getGold());
	}

}
