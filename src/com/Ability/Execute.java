package com.Ability;
import com.character.Character;

import static com.Utils.Constants.EX_DAMAGE;
import static com.Utils.Constants.EX_DMG_PER_LVL;
import static com.Utils.Constants.EX_PROC_HP;
import static com.Utils.Constants.EX_PROC_HP_PER_LVL;
import static com.Utils.Constants.EX_PROC_HP_LIMIT;
public class Execute extends Ability {
    private float effectiveHpPercentage;
    private float hpPercentage;
    private float hpPercentageBonusPerLvl;
    private float hpLimit;
    public Execute() {
        super(EX_DAMAGE, EX_DMG_PER_LVL, AbilityType.Execute);
        hpPercentage = EX_PROC_HP;
        hpPercentageBonusPerLvl = EX_PROC_HP_PER_LVL;
        hpLimit = EX_PROC_HP_LIMIT;
    }
    public final void computeLvlDamage(final int level, final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        effectiveHpPercentage = hpPercentage + hpPercentageBonusPerLvl * level;
        if (effectiveHpPercentage > hpLimit) {
            effectiveHpPercentage = hpLimit;
        }
    }
    public final float getEffectiveHpPercentage() {
        return effectiveHpPercentage;
    }
    public final void strike(final Character player) {
        player.acceptAbility(this);
    }

}
