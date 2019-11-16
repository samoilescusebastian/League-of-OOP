package com.Ability;

import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;


public class Ignite extends SpecialAbility {

    public Ignite() {
        super(IG_BASE_DAMAGE, IG_BASE_PER_LVL, AbilityType.Ignite, IG_ROUND_DAMAGE,
                IG_ROUND_PER_LVL, IG_DMG_LIFE, ZERO);
    }
    public void computeLvlDamage(int level, final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        roundLevelDmg = roundDamage  + bonusRoundDmgPerLvl * level;
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }

}
