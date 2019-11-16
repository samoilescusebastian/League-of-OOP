package com.Ability;

import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;
public class Drain extends Ability{
    public Drain() {
        super(DR_HP_PROC, DR_PROC_PER_LEVEL, AbilityType.Drain);

    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }
    public void addBonuses() {
        effectiveBaseDmg = Math.round(Math.round(Math.round(levelDmg * 100) * (1 + locationBonus)) * (1  + racialBonus)) /(100f);
    }
}
