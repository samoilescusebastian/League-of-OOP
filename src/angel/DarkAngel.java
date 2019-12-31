package angel;

import character.Character;
import com.sun.source.doctree.HiddenTree;
import location.Point;

import java.io.IOException;

import static utils.Constants.HIT;

public class DarkAngel extends Angel{
    public DarkAngel(Point location) {
        super(AngelType.DarkAngel, location);
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
