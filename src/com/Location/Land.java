package com.Location;

import com.character.Character;

public final class Land extends Cell {
    public void sendBonus(final Character character) {
        character.setLocationBonus(this);
    }
}
