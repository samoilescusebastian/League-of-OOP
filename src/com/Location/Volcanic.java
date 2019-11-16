package com.Location;


import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

public class Volcanic extends Cell{
    public void sendBonus(Character character) {
        character.setLocationBonus(this);
    }
}
