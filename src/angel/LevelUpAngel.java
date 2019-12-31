package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HELPED;

public class LevelUpAngel extends Angel{
    public LevelUpAngel(Point location) {
        super(AngelType.LevelUpAngel, location);
    }

    @Override
    public void visitPlayer(Character player) throws IOException {
        player.acceptVisit(this);
    }

    @Override
    public void setHelpState(Character player) throws IOException {
        helpType = HELPED;
        setFullHelpState(player);
    }
}
