package dungeon.tests;
import dungeon.character.*;
import dungeon.dungeon.*;
import dungeon.item.*;
import dungeon.room.*;
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class GoldPurseTest extends ItemTest {

	@Before
	public void init() {
		gp = new GoldPurse(20);
	}
	
	@Test
	public void useWorksProperly() {
		Room startingRoom = new Room("starting");
	    AdventureGame g = new AdventureGame(startingRoom);
		startingRoom.addItem(hp);
	    Player p1 = new Player(200, 35, 0, "Adil", g);
		g.addPlayer(p1);
		gp.use(p1);
		assertEquals(20, p1.getGold());
	}
}
