package dungeon.tests;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.item.*;
import dungeon.room.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.*;


public class StrengthPotionTest extends ItemTest {

	@Before
	public void init() {
		sp = new StrengthPotion(20);
	}
	
	@Test
	public void useWorksProperly() {
		Room startingRoom = new Room("starting");
	    AdventureGame g = new AdventureGame(startingRoom);
		startingRoom.addItem(hp);
	    Player p1 = new Player(200, 35, 0, "Adil", g);
		g.addPlayer(p1);
		sp.use(p1);
		assertEquals(55, p1.getStrength());
	}
}
