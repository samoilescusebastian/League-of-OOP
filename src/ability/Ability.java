package ability;


import character.Character;

import static utils.Constants.FULL_DMG;
import static utils.Constants.ZERO;

public abstract class Ability {
    protected float baseDamage;
    protected float bonusBaseDmgPerLvl;
    protected float levelDmg;
    protected float effectiveBaseDmg;
    private AbilityType type;
    protected float racialBonus;
    protected float locationBonus;
    protected float strategyFactor;
    protected float angelFactor;

    /**
     * ability hits victim.
     * accept method of a concrete element
     */
    public abstract void strike(Character player);
    public Ability(final float damage, final float damagePerLevel, final AbilityType abilityType) {
        baseDamage = damage;
        bonusBaseDmgPerLvl = damagePerLevel;
        type = abilityType;
    }
    /**
     * compute ability damage based on hero's level.
     */
    public void computeLvlDamage(final int level, final int takenDamage) {
        levelDmg = baseDamage + bonusBaseDmgPerLvl * level;
    }
    public final void setStrategyFactor(final float abilityModifier) {
        strategyFactor = abilityModifier;
    }
    public final void setLocationBonus(final float cellTypeBonus) {
        locationBonus = cellTypeBonus;
    }
    public final void setRacialBonus(final float characterTypeBonus) {
        racialBonus = characterTypeBonus + strategyFactor;
    }
    public final float getLocationBonus() {
        return locationBonus;
    }
    /**
     * add location and racial bonuses to level damage.
     */
    public void addBonuses() {
        effectiveBaseDmg = Math.round(Math.round(levelDmg * (FULL_DMG + locationBonus))
                           * (FULL_DMG  + racialBonus));
    }
    public final float getLevelDamage() {
        return levelDmg;
    }
    public final float getNoRaceDamage() {
        return Math.round(levelDmg * (FULL_DMG + locationBonus));
    }
    public final float getEffectiveBaseDmg() {
        return effectiveBaseDmg;
    }
    /**
     * reset ability to general form after hero used it in battle.
     */
    public void resetAbility() {
        levelDmg = ZERO;
        racialBonus = ZERO;
        locationBonus = ZERO;
    }
}
