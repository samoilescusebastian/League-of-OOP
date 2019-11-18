package com.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            fileio.FileSystem fs = new fileio.FileSystem(args[0], args[1]);
            GameInputLoader gameInputLoader = new GameInputLoader();
            GameInput gameInput = gameInputLoader.load(fs);
            GameEngine game = new GameEngine(gameInput, fs);
            game.startGame();
            game.viewResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
