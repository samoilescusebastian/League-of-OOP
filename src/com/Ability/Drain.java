package com.Ability;

import com.character.Character;

import static com.Utils.Constants.DR_PROC_PER_LEVEL;
import static com.Utils.Constants.DR_HP_PROC;
import static com.Utils.Constants.FULL_DMG;
public final class Drain extends Ability {
    public Drain() {
        super(DR_HP_PROC, DR_PROC_PER_LEVEL, AbilityType.Drain);

    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }
    public void addBonuses() {
        effectiveBaseDmg = ((levelDmg) * (FULL_DMG + locationBonus)) * (FULL_DMG  + racialBonus);
    }
}
