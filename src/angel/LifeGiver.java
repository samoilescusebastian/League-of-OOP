package angel;

import character.Character;
import location.Point;

public class LifeGiver extends Angel {
    public LifeGiver(Point location) {
        super(AngelType.LifeGiver, location);
    }
    @Override
    public void visitPlayer(Character player) {

    }
}
