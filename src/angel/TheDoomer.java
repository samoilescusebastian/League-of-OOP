package angel;

import character.Character;
import location.Point;

import java.io.IOException;

import static utils.Constants.HIT;

public class TheDoomer extends Angel {
    public TheDoomer(Point location) {
        super(AngelType.TheDoomer, location);
    }

    @Override
    public void visitPlayer(Character player) throws IOException {
        player.acceptVisit(this);
    }

    @Override
    public void setHelpState(Character player) throws IOException {
        helpType = HIT;
        setFullHelpState(player);
    }
}
