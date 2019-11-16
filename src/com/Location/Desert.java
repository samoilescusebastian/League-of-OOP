package com.Location;

import com.character.Character;
public class Desert extends Cell{
        public void sendBonus(Character character) {
            character.setLocationBonus(this);
        }
}
