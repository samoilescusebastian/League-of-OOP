package angel;

import character.Character;
import location.Point;

public class TheDoomer extends Angel {
    public TheDoomer(Point location) {
        super(AngelType.TheDoomer, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
