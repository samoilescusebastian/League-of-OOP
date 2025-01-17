package ability;

import character.Character;

import static utils.Constants.DF_LIMIT;
import static utils.Constants.DF_PROC;
import static utils.Constants.DF_PROC_PER_LVL;
import static utils.Constants.FULL_DMG;
public final class Deflect extends Ability {
    private float limit;
    private int takenDamage;;
    public Deflect() {
        super(DF_PROC, DF_PROC_PER_LVL, AbilityType.Deflect);
        limit = DF_LIMIT;
    }
    public void computeLvlDamage(final int level, final int takenDmg) {
        super.computeLvlDamage(level, takenDmg);
        if (levelDmg > DF_LIMIT) {
            levelDmg = DF_LIMIT;
        }
        takenDamage = takenDmg;
    }
    public void addBonuses() {
        effectiveBaseDmg = ((levelDmg) * (FULL_DMG + locationBonus)) * (FULL_DMG + racialBonus);
    }
    public int getTakenDmg() {
        return takenDamage;
    }
    public void strike(final Character player) {
        player.acceptAbility(this);
    }

}
