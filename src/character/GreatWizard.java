package character;

import game.Observer;

import java.io.IOException;

public class GreatWizard implements Observer {
    private static GreatWizard greatWizard = null;
    @Override
    public void update(final fileio.FileSystem fs, final String message) throws IOException {
        fs.writeWord(message);
        fs.writeWord("\n");
    }
    public static GreatWizard getInstance() {
        if (greatWizard == null) {
            greatWizard = new GreatWizard();
        }
        return  greatWizard;
    }
}
