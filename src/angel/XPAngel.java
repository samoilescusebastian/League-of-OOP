package angel;

import character.Character;
import location.Point;

public class XPAngel extends Angel{
    public XPAngel(Point location) {
        super(AngelType.XPAngel, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
