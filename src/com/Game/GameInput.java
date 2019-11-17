package com.Game;

import com.Location.Cell;
import com.character.Character;
import java.util.List;

public class GameInput {
    Cell [][]Map;
    List<Character> players;

    public GameInput() {
        Map = null;
        players = null;
    }
    public GameInput(Cell [][]Map, List<Character> players) {
        this.Map = Map;
        this.players = players;
    }
    public Cell[][] getMap() {
        return Map;
    }
    public List<Character> getPlayers() {
        return players;
    }
}
