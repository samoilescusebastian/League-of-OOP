package angel;

import character.Character;
import location.Point;

public abstract class Angel {
    private AngelType type;
    private Point location;
    Angel(AngelType type, Point location) {
        this.type = type;
        this.location = location;
    }
    public abstract void visitPlayer(Character player);
}