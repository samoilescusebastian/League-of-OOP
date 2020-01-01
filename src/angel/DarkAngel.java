package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HIT;

public final class DarkAngel extends Angel {
    public DarkAngel(final Point location) {
        super(AngelType.DarkAngel, location);
    }

    @Override
    public void visitPlayer(final Character player) throws IOException {
        player.acceptVisit(this);
    }

    @Override
    public void setHelpState(final Character player) throws IOException {
        helpType = HIT;
        setFullHelpState(player);
    }
}
