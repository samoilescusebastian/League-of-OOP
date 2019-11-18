package com.Ability;


import static com.Utils.Constants.ZERO;

abstract public class Ability implements AbilityInterface{
    protected float baseDamage;
    protected float bonusBaseDmgPerLvl;
    protected float levelDmg;
    protected float effectiveBaseDmg;
    private AbilityType type;
    protected float racialBonus;
    protected float locationBonus;
    public Ability(final float damage, final float damagePerLevel, final AbilityType abilityType){
        baseDamage = damage;
        bonusBaseDmgPerLvl = damagePerLevel;
        type = abilityType;
    }
    public void computeLvlDamage(int level, final int takenDamage) {
        levelDmg = baseDamage + bonusBaseDmgPerLvl * level;
    }
    public void setLocationBonus(final float cellTypeBonus) {
        locationBonus = cellTypeBonus;
    }
    public void setRacialBonus(final float characterTypeBonus) {
        racialBonus = characterTypeBonus;
    }
    //debugging
    public float getLocationBonus() {
        return locationBonus;
    }
    //debugging
    public float getRacialBonus() {
        return racialBonus;
    }
    public void addBonuses() {
        effectiveBaseDmg = Math.round(Math.round(levelDmg * (1 + locationBonus)) * (1  + racialBonus));
    }
    public float getLevelDamage() {
        return levelDmg;
    }
    public float getEffectiveBaseDmg() {
        return effectiveBaseDmg;
    }
    public void resetAbility() {
        levelDmg = ZERO;
        racialBonus = ZERO;
        locationBonus = ZERO;
    }
}
