package com.Ability;

import com.character.Character;

import static com.Utils.Constants.*;
public class Backstab extends Ability {
    private int used;
    private boolean critical;
    public Backstab() {
        super(BS_DAMAGE, BS_DMG_PER_LVL, AbilityType.Backstab);
        used = ZERO;
        critical = false;
    }
    public void setCritical(final boolean criticalHit) {
        critical = criticalHit;
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }
    public void addBonuses() {
        if (used % THREE == 0) {
            if (critical == true) {
                effectiveBaseDmg = Math.round(Math.round(Math.round(levelDmg * AMPLIFIER)* (1 + locationBonus)) * (1  + racialBonus));
            } else {
                super.addBonuses();
            }
        }
        used++;
    }
}
