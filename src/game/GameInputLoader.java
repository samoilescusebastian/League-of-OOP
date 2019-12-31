package game;

import angel.Angel;
import angel.AngelFactory;
import location.CellFactory;
import location.Map;
import location.Point;
import character.CharacterFactory;
import character.Character;

import java.util.ArrayList;
import java.util.List;

import static utils.Constants.ZERO;

public final class  GameInputLoader {

    public GameInputLoader() {

    }

    public GameInput load(final fileio.FileSystem fs) {
        int rows = 0;
        int columns = 0;
        int playersNumber = 0;
        int roundsNumber = 0;
        String types = null;
        char cellType = 0;
        Map map = null;
        List<Character> players = new ArrayList<>();
        List<Round> rounds = new ArrayList<>();
        try {

            rows = fs.nextInt();
            columns = fs.nextInt();
            map = Map.getInstance(rows, columns);
            CellFactory cellFactory = CellFactory.getInstance();
            for (int i = 0; i < rows; i++) {
                types = fs.nextWord();
                for (int j = 0; j < columns; j++) {
                    cellType  = types.charAt(j);
                    map.setCell(cellFactory.createCell(cellType), i, j);
                }
            }
            playersNumber = fs.nextInt();
            char type;
            Point location;
            CharacterFactory characterFactory = CharacterFactory.getInstance();
            for (int i = 0; i < playersNumber; i++) {
                type = fs.nextWord().charAt(ZERO);
                location = new Point(fs.nextInt(), fs.nextInt());
                players.add(characterFactory.createCharacter(type, location));
            }
            roundsNumber = fs.nextInt();
            for (int i = 0; i < roundsNumber; i++) {
                rounds.add(new Round());
                rounds.get(i).setMoves(fs.nextWord());
            }
            AngelFactory angelFactory = AngelFactory.getInstance();
            for (int i = 0; i < roundsNumber; i++) {
                int angels = fs.nextInt();
                for (int j = 0; j < angels; j++) {
                    String angelInfo = fs.nextWord();
                    String coordinates;
                    String angelType;
                    Point angelLocation;
                    int angelTypeEnd;
                    int coordSeparator;
                    angelTypeEnd = angelInfo.indexOf(',');
                    angelType = angelInfo.substring(0, angelTypeEnd);
                    coordinates = angelInfo.substring(angelTypeEnd + 1);
                    coordSeparator = coordinates.indexOf(',');
                    angelLocation = new Point(Integer.parseInt(coordinates.substring(0, coordSeparator)), Integer.parseInt(coordinates.substring(coordSeparator + 1)));
                    Angel angel = angelFactory.createAngel(angelType, angelLocation);
                    rounds.get(i).addAngel(angel);
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(map, players, roundsNumber, rounds);
    }
}
