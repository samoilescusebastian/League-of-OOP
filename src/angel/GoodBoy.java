package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HELPED;

public final class GoodBoy extends Angel {
    public GoodBoy(final Point location) {
        super(AngelType.GoodBoy, location);
    }
    @Override
    public void visitPlayer(final Character player) throws IOException {
        player.acceptVisit(this);
    }

    @Override
    public void setHelpState(final Character player) throws IOException {
        helpType = HELPED;
        setFullHelpState(player);
    }
}
