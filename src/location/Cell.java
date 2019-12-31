package location;


import character.Character;

import java.util.ArrayList;
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
    public final boolean isInConflict(final Character player, final List<Character> players) {
        for (int i = 0; i < characters.size(); i++) {
            if (player.getId() > characters.get(i) && !players.get(characters.get(i)).isDead()) {
                return true;
            }
        }
        return false;
    }

}
