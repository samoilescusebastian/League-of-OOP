package angel;

import character.Character;
import location.Point;

public class DamageAngel extends Angel{
    DamageAngel(Point location) {
        super(AngelType.DamageAngel, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
