package ability;

import character.Character;

import static utils.Constants.BS_DAMAGE;
import static utils.Constants.BS_DMG_PER_LVL;
import static utils.Constants.BS_CRITICAL_LOAD_FACTOR;
import static utils.Constants.AMPLIFIER;
import static utils.Constants.ZERO;

public final class Backstab extends Ability {
    private int used;
    private boolean critical;
    public Backstab() {
        super(BS_DAMAGE, BS_DMG_PER_LVL, AbilityType.Backstab);
        used = ZERO;
        critical = false;
    }
    public void setCritical(final boolean criticalHit) {
        critical = criticalHit;
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }
    @Override
    public void computeLvlDamage(final int level, final int takenDamage) {
        super.computeLvlDamage(level, takenDamage);
        if (used % BS_CRITICAL_LOAD_FACTOR == 0) {
            if (critical) {
                levelDmg = Math.round(levelDmg * AMPLIFIER);
            }
        }
        used++;
    }
    @Override
    public void resetAbility() {
        super.resetAbility();
        critical = false;
    }
}
