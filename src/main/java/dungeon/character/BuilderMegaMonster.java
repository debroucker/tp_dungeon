package dungeon.character;
import dungeon.dungeon.*;

/**
 * Builder of a Mega Monster, that extends the Monster class.
 *
 */
public class BuilderMegaMonster extends Monster {
	public BuilderMegaMonster(AdventureGame game) {
		super(150, 60, 15, "MegaMonster", game);
	}
}
