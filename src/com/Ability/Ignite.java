package com.Ability;

import static com.Utils.Constants.*;


public class Ignite extends Ability {
    private float roundDamage;
    private float bonusRoundDmgPerLevel;
    public Ignite() {
        super(IG_BASE_DAMAGE, IG_BASE_PER_LVL, AbilityType.Ignite, false, true);
        roundDamage = IG_ROUND_DAMAGE;
        bonusRoundDmgPerLevel = IG_ROUND_PER_LVL;
    }
}
