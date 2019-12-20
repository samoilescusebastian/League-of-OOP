package ability;

import character.Character;

import static utils.Constants.IG_BASE_DAMAGE;
import static utils.Constants.IG_BASE_PER_LVL;
import static utils.Constants.IG_ROUND_DAMAGE;
import static utils.Constants.IG_ROUND_PER_LVL;
import static utils.Constants.IG_DMG_LIFE;
import static utils.Constants.NO_EFFECT;




public final class Ignite extends SpecialAbility {

    public Ignite() {
        super(IG_BASE_DAMAGE, IG_BASE_PER_LVL, AbilityType.Ignite, IG_ROUND_DAMAGE,
                IG_ROUND_PER_LVL, IG_DMG_LIFE, NO_EFFECT);
    }
    public void computeLvlDamage(final int level, final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        roundLevelDmg = roundDamage  + bonusRoundDmgPerLvl * level;
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }

}
