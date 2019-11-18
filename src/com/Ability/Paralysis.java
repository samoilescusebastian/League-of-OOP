package com.Ability;

import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;
public class Paralysis extends SpecialAbility{
    private int roundOvertime;
    public Paralysis() {
        super(PL_DAMAGE, PL_PER_LVL, AbilityType.Paralysis, PL_DAMAGE, PL_PER_LVL, THREE, THREE);
        roundOvertime = THREE;
    }
    public void computeLvlDamage(int level,  final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        roundLevelDmg = roundDamage + bonusRoundDmgPerLvl * level;
    }

    @Override
    public void addBonuses() {
        super.addBonuses();
        effectiveRoundDmg = Math.round(Math.round(roundLevelDmg  * (1 + locationBonus)) * (1  + racialBonus));

    }

    public void addOvertimeBonus() {
        roundOvertime += OVERTIME_BONUS;
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }

    @Override
    public void resetAbility() {
        super.resetAbility();
        roundOvertime = THREE;
    }
}
