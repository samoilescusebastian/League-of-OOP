package angel;

import character.Character;
import location.Point;

public class SmallAngel extends Angel {
    public SmallAngel(Point location) {
        super(AngelType.SmallAngel, location);
    }
    @Override
    public void visitPlayer(Character player) {

    }
}
