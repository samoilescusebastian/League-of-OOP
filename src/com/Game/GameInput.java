package com.Game;

import com.Location.Cell;
import com.Location.Map;
import com.character.Character;
import java.util.List;

public class GameInput {
    Map map;
    List<Character> players;

    public GameInput() {
        map = null;
        players = null;
    }
    public GameInput(Map map, List<Character> players) {
        this.map = map;
        this.players = players;
    }
    public Map getMap() {
        return map;
    }
    public List<Character> getPlayers() {
        return players;
    }
}
