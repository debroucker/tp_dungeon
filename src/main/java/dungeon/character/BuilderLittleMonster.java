package dungeon.character;
import dungeon.dungeon.*;

/**
 * Builder of a Little Monster, that extends the Monster class.
 *
 */
public class BuilderLittleMonster extends Monster {
	public BuilderLittleMonster(AdventureGame game) {
		super(50, 20, 5, "littleMonster", game);
	}
}
