package location;


import character.Character;

public final class Woods extends Cell {
    public void sendBonus(final Character character) {
        character.setLocationBonus(this);
    }
}
