package angel;

import character.Character;
import location.Point;

public class Spawner extends Angel {
    public Spawner(Point location) {
        super(AngelType.Spawner, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
