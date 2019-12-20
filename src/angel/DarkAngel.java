package angel;

import character.Character;
import location.Point;

public class DarkAngel extends Angel{
    public DarkAngel(Point location) {
        super(AngelType.DarkAngel, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
