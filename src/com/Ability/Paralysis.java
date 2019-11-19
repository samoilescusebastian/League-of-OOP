package com.Ability;

import com.character.Character;

import static com.Utils.Constants.PL_DAMAGE;
import static com.Utils.Constants.THREE;
import static com.Utils.Constants.PL_PER_LVL;
import static com.Utils.Constants.FULL_DMG;
import static com.Utils.Constants.OVERTIME_BONUS;

public final class Paralysis extends SpecialAbility {
    public Paralysis() {
        super(PL_DAMAGE, PL_PER_LVL, AbilityType.Paralysis, PL_DAMAGE, PL_PER_LVL, THREE, THREE);
        damageLife = THREE;
        paralysisLife = THREE;
    }
    public void computeLvlDamage(final int level,  final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        roundLevelDmg = roundDamage + bonusRoundDmgPerLvl * level;
    }

    @Override
    public void addBonuses() {
        super.addBonuses();
        effectiveRoundDmg = Math.round(Math.round(roundLevelDmg  * (FULL_DMG + locationBonus))
                            * (FULL_DMG  + racialBonus));

    }

    public void addOvertimeBonus() {
        damageLife += OVERTIME_BONUS;
        paralysisLife += OVERTIME_BONUS;
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }

    @Override
    public void resetAbility() {
        super.resetAbility();
        super.resetAbility();
        damageLife = THREE;
        paralysisLife = THREE;
    }
}
