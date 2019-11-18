package com.Ability;

import static com.Utils.Constants.ZERO;

abstract public class SpecialAbility extends Ability {
    protected float roundDamage;
    protected float bonusRoundDmgPerLvl;
    protected int damageLife;
    protected int paralysisLife;
    protected float roundLevelDmg;
    protected float effectiveRoundDmg;
    SpecialAbility(final float damage, final float damagePerLevel, final AbilityType abilityType,
                   final float roundDamage, final float roundDmgPerLvl, final int dmgDurability,
                   final int paralysisDurability) {
        super(damage, damagePerLevel, abilityType);
        this.roundDamage = roundDamage;
        this.bonusRoundDmgPerLvl = roundDmgPerLvl;
        this.damageLife = dmgDurability;
        this.paralysisLife = paralysisDurability;
    }
    public float getEffectiveRoundDmg() {
        return effectiveRoundDmg;
    }
    public int getDamageLife() {
        return damageLife;
    }
    public int getParalysisLife() {
        return paralysisLife;
    }
    public void resetAbility() {
        super.resetAbility();
        effectiveRoundDmg = ZERO;
    }
}
