package ability;

import character.Character;

import static utils.Constants.DR_PROC_PER_LEVEL;
import static utils.Constants.DR_HP_PROC;
import static utils.Constants.FULL_DMG;
public final class Drain extends Ability {
    public Drain() {
        super(DR_HP_PROC, DR_PROC_PER_LEVEL, AbilityType.Drain);

    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }
    public void addBonuses() {
        effectiveBaseDmg = ((levelDmg) * (FULL_DMG + locationBonus)) * (FULL_DMG  + racialBonus);
    }
}
