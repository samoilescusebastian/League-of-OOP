package com.Game;

import com.Location.Cell;
import com.character.Character;
import java.io.IOException;
import java.util.List;

import static com.Utils.Constants.ZERO;

public class GameEngine {
    private GameInput gameInput;
    private  fileio.FileSystem fs;
    public GameEngine(GameInput gameInput, fileio.FileSystem fs) {
        this.gameInput = gameInput;
        this.fs = fs;

    }

 public void startGame() throws IOException {

        Cell [][]Map = gameInput.getMap();
        List<Character> players = gameInput.getPlayers();
        int roundsNumber = fs.nextInt();
        String moves ;
        for (int i = ZERO; i < roundsNumber; i++) {
            moves = fs.nextWord();
        }
     //DEBUGGING
//     Cell[][] Map = gameInput.getMap();
//     List<Character> players  = gameInput.getPlayers();
//     for (int i = 0; i < Map.length; i++) {
//         for (int j = 0; j < Map[i].length;j++) {
//             System.out.println(Map[i][j]);
//         }
//     }
//     for (int i = 0; i < players.size(); i++) {
//         System.out.println(players.get(i).getType());
//     }

 }

}
