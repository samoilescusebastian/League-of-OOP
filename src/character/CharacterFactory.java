package character;

import location.Point;

public final class CharacterFactory {
    private static CharacterFactory factory = null;
    public static CharacterFactory getInstance() {
        if (factory == null) {
            factory = new CharacterFactory();
        }
        return factory;
    }
    private CharacterFactory() { }
    public Character createCharacter(final char type, final Point location) {
        Character newCharacter = null;
        switch (type) {
            case 'P':
                newCharacter = new Pyromancer(location);
                break;
            case 'K':
                newCharacter = new Knight(location);
                break;
            case 'W':
                newCharacter = new Wizard(location);
                break;
            case 'R':
                newCharacter = new Rogue(location);
                break;
            default:
                newCharacter = null;
        }
        return newCharacter;
    }
}
