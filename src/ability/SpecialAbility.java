package ability;

import static utils.Constants.FULL_DMG;
import static utils.Constants.ZERO;

public abstract class SpecialAbility extends Ability {
    protected float roundDamage;
    protected float bonusRoundDmgPerLvl;
    protected int damageLife;
    protected int paralysisLife;
    protected float roundLevelDmg;
    protected float effectiveRoundDmg;

    SpecialAbility(final float damage, final float damagePerLevel, final AbilityType abilityType,
                   final float roundDamage, final float roundDmgPerLvl, final int dmgDurability,
                   final int paralysisDurability) {
        super(damage, damagePerLevel, abilityType);
        this.roundDamage = roundDamage;
        this.bonusRoundDmgPerLvl = roundDmgPerLvl;
        this.damageLife = dmgDurability;
        this.paralysisLife = paralysisDurability;
    }

    /**
     * add racial and location bonuses to base damage.
     */
    @Override
    public void addBonuses() {
        super.addBonuses();
        effectiveRoundDmg = Math.round(Math.round(roundDamage * (FULL_DMG + locationBonus))
                            * (FULL_DMG  + racialBonus));
    }

    public final float getEffectiveRoundDmg() {
        return effectiveRoundDmg;
    }
    public final int getDamageLife() {
        return damageLife;
    }
    public final int getParalysisLife() {
        return paralysisLife;
    }
    /**
     * reset ability to general form after hero used it in battle.
     */
    public void resetAbility() {
        super.resetAbility();
        effectiveRoundDmg = ZERO;
    }
}
