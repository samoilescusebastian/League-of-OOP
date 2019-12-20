package angel;

import character.Character;
import location.Point;

public class LevelUpAngel extends Angel{
    public LevelUpAngel(Point location) {
        super(AngelType.LevelUpAngel, location);
    }

    @Override
    public void visitPlayer(Character player) {

    }
}
