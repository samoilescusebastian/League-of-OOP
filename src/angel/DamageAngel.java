package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HELPED;

public final class DamageAngel extends Angel {
    DamageAngel(final Point location) {
        super(AngelType.DamageAngel, location);
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
