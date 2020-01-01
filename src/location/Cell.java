package location;


import character.Character;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Cell {
    private List<Integer> characters;
     /**
      * hero get a location bonus based of its type.
      * accept method of a concrete element
      */
    public abstract void sendBonus(Character character);
    public Cell() {
        characters = new ArrayList<>();
    }
    public final void addCharacter(final int playerID) {
        characters.add(playerID);
    }
    public final void deleteCharacter(final int playerID) {
        characters.remove(Integer.valueOf(playerID));
    }
    public final List<Integer> getCharacters() {
        return characters;
    }
    public final List<Integer> getAliveCharacters(final List<Character> players) {
        List<Integer> aliveCharacters = new ArrayList<>();
        for (Integer characterId : characters) {
            if (!players.get(characterId).isDead()) {
                aliveCharacters.add(characterId);
            }
        }
        return  aliveCharacters;
    }
    public final boolean isInConflict(final List<Character> players, final Character player) {
        for (Integer characterId : characters) {
            if (!players.get(characterId).isDead()
                    && player.getId() < players.get(characterId).getId()) {
                return true;
            }
        }
        return false;
    }
    public final void sortPlayers() {
        Collections.sort(characters);
    }

}
