package angel;

import character.Character;
import location.Point;

public class GoodBoy extends Angel {
    public GoodBoy(Point location) {
        super(AngelType.GoodBoy, location);
    }
    @Override
    public void visitPlayer(Character player) {

    }
}
