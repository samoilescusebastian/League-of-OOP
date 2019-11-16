package com.Ability;
import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;

public class Execute extends Ability {
    private float effectiveHPPercentage;
    private float HPPercentage;
    private float HPPercentageBonusPerLvl;
    private float HPLimit;
    public Execute() {
        super(EX_DAMAGE, EX_DMG_PER_LVL, AbilityType.Execute);
        HPPercentage = EX_PROC_HP;
        HPPercentageBonusPerLvl = EX_PROC_HP_PER_LVL;
        HPLimit = EX_PROC_HP_LIMIT;
    }
    public void computeLvlDamage(int level, final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        effectiveHPPercentage = HPPercentage + HPPercentageBonusPerLvl * level;
        if (effectiveHPPercentage > HPLimit) {
            effectiveHPPercentage = HPLimit;
        }
    }
    public float getEffectiveHPPercentage() {
        return effectiveHPPercentage;
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }

}
