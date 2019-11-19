package com.Ability;

import com.character.Character;;

import static com.Utils.Constants.FB_DAMAGE;
import static com.Utils.Constants.FB_DMG_PER_LVL;

public final class Fireblast extends Ability {
    public Fireblast() {
        super(FB_DAMAGE, FB_DMG_PER_LVL, AbilityType.Fireblast);
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }

}
