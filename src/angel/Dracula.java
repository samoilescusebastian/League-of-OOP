package angel;

import character.Character;
import location.Point;

public class Dracula extends Angel{
    public Dracula(Point location) {
        super(AngelType.Dracula, location);
    }
    @Override
    public void visitPlayer(Character player) {

    }
}
