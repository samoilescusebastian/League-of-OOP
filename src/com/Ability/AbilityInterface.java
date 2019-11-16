package com.Ability;

import com.character.Character;

public interface AbilityInterface {
    void computeLvlDamage(int level,  final int takenDamage);
    void addBonuses();
    void strike(Character player);
}
