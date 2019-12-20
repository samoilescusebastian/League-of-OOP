package ability;
import character.Character;

import static utils.Constants.SL_BASE_DAMAGE;
import static utils.Constants.SL_BASE_PER_LVL;
import static utils.Constants.ZERO;
import static utils.Constants.SL_PARALYSIS;
public final class Slam extends SpecialAbility {

    public Slam() {
        super(SL_BASE_DAMAGE, SL_BASE_PER_LVL, AbilityType.Slam, ZERO, ZERO, ZERO, SL_PARALYSIS);
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }
}
