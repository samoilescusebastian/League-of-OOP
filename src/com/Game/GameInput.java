package com.Game;

import com.Location.Map;
import com.character.Character;
import java.util.List;

public class GameInput {
    private final Map map;
    private final List<Character> players;

    public GameInput() {
        map = null;
        players = null;
    }
    public GameInput(final Map map, final List<Character> players) {
        this.map = map;
        this.players = players;
    }
    final Map getMap() {
        return map;
    }
    final List<Character> getPlayers() {
        return players;
    }
}
