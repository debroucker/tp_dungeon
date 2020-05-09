package dungeon.character;

import dungeon.dungeon.*;

/**
 * Builder of a Medium Monster, that extends the Monster class.
 *
 */
public class BuilderMediumMonster extends Monster {
	public BuilderMediumMonster(AdventureGame game) {
		super(70, 40, 10, "mediumMonster", game);
	}
}
