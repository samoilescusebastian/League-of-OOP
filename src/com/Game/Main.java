package com.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            fileio.FileSystem fs = new fileio.FileSystem(args[0], args[1]);
            GameInputLoader gameInputLoader = new GameInputLoader();
            GameInput gameInput = gameInputLoader.load(fs);
            GameEngine newGame = new GameEngine(gameInput, fs);
            newGame.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
