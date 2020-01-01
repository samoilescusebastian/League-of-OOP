package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HIT;

public final class TheDoomer extends Angel {
    public TheDoomer(final Point location) {
        super(AngelType.TheDoomer, location);
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
