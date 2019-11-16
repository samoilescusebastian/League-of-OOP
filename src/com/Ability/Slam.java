package com.Ability;
import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;
public class Slam extends SpecialAbility {

    public Slam() {
        super(SL_BASE_DAMAGE, SL_BASE_PER_LVL, AbilityType.Slam, ZERO, ZERO, ZERO, ONE);
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }
}
