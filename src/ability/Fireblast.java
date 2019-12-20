package ability;

import character.Character;;

import static utils.Constants.FB_DAMAGE;
import static utils.Constants.FB_DMG_PER_LVL;

public final class Fireblast extends Ability {
    public Fireblast() {
        super(FB_DAMAGE, FB_DMG_PER_LVL, AbilityType.Fireblast);
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }

}
