package com.Ability;

import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import java.util.Random;

import static com.Utils.Constants.*;
public class Deflect extends Ability {
    private float limit;
    private int takenDamage;;
    public Deflect() {
        super(DF_PROC, DF_PROC_PER_LVL, AbilityType.Deflect);
        limit = DF_LIMIT;
    }
    public void computeLvlDamage(int level, final int takenDmg) {
        super.computeLvlDamage(level, takenDmg);
        if (levelDmg > DF_LIMIT) {
            levelDmg = DF_LIMIT;
        }
        takenDamage = takenDmg;
    }
    public void addBonuses() {
        effectiveBaseDmg = Math.round(Math.round(Math.round(levelDmg * 100) * (1 + locationBonus)) * (1  + racialBonus)) /(100f);
    }
    public int getTakenDmg() {
        return takenDamage;
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }

}
