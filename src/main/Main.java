package main;

import game.GameEngine;
import game.GameInput;
import game.GameInputLoader;

import java.io.IOException;

final class Main {
    private Main() {
    }
    public static void main(final String[] args) {

        try {
            fileio.FileSystem fs = new fileio.FileSystem(args[0], args[1]);
            GameInputLoader gameInputLoader = new GameInputLoader();
            GameInput gameInput = gameInputLoader.load(fs);
            GameEngine game = new GameEngine(gameInput, fs);
            game.startGame();
            game.viewResults();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
