package angel;

import character.Character;
import game.Observer;
import location.Point;

import java.io.IOException;

import static utils.Constants.HIT;

public class Dracula extends Angel{
    public Dracula(Point location) {
        super(AngelType.Dracula, location);
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
