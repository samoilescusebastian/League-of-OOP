package game;

import location.Map;
import character.Character;
import java.util.List;

public class GameInput {
    private final int roundsNumber;
    private final Map map;
    private final List<Character> players;
    private final List<Round> rounds;

    public GameInput(final Map map, final List<Character> players, final int roundsNumber, final List<Round> rounds) {
        this.map = map;
        this.players = players;
        this.roundsNumber = roundsNumber;
        this.rounds = rounds;
    }
    final Map getMap() {
        return map;
    }
    final List<Character> getPlayers() {
        return players;
    }
    final int getRoundsNumber(){
        return roundsNumber;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
