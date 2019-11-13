package com.character;


public class CharacterFactory {
    CharacterFactory factory = null;
    CharacterFactory getInstance() {
        if (factory == null) {
            factory = new CharacterFactory();
        }
        return factory;
    }
    private CharacterFactory() { }
    Character createCharacter(CharacterType type) {
        Character character = null;
        return  character;

    }
}
