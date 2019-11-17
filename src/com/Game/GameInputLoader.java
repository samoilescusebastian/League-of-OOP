package com.Game;

import com.Location.Cell;
import com.Location.CellFactory;
import com.Location.Point;
import com.character.CharacterFactory;
import com.character.Character;

import java.util.ArrayList;
import java.util.List;

import static com.Utils.Constants.*;

public final class  GameInputLoader {

    GameInputLoader() {

    }

    public GameInput load(fileio.FileSystem fs) {
        int rows = 0;
        int columns = 0;
        int playersNumber = 0;
        String types = null;
        char cellType = 0;
        Cell [][]Map = null;
        List<Character> players = new ArrayList<>();
        try {

            rows = fs.nextInt();
            columns = fs.nextInt();
            Map = new Cell[rows][columns];
            CellFactory cellFactory = CellFactory.getInstance();
            for (int i = 0; i < rows; i++) {
                types = fs.nextWord();
                for (int j = 0; j < columns; j++) {
                    cellType  = types.charAt(j);
                    Map[i][j] = cellFactory.createCell(cellType);
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

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(Map, players);
    }
}
