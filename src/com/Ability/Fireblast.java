package com.Ability;

import com.character.Character;
import com.character.Knight;
import com.character.Pyromancer;
import com.character.Rogue;
import com.character.Wizard;

import static com.Utils.Constants.*;

public class Fireblast extends Ability {
    public Fireblast() {
        super(FB_DAMAGE,FB_DMG_PER_LVL, AbilityType.Fireblast);
    }
    public void strike(Character player) {
        player.acceptAbility(this);
    }

}
