package com.Location;


import com.character.Character;

import java.util.ArrayList;
import java.util.List;

abstract public class Cell implements CellInterface{
    List<Integer> characters;
    public Cell() {
        characters = new ArrayList<>();
    }
    public void addCharacter(final int playerID) {
        characters.add(playerID);
    }
    public void deleteCharacter(final int playerID) {
        characters.remove(Integer.valueOf(playerID));
    }
    public List<Integer> getList() {
        return characters;
    }
    public boolean isInConflict(Character player) {
        for (int i = 0; i < characters.size(); i++) {
            if (player.getID() > characters.get(i)) {
                return true;
            }
        }
        return false;
    }

}
