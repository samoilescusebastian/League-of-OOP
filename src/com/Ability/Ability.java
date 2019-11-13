package com.Ability;


abstract public class Ability {
    protected float baseDamage;
    protected float bonusBaseDmgPerLvl;
    protected boolean stunning;
    protected boolean futureEffect;
    protected int effectiveDamage;

    private AbilityType type;
    public Ability(final float damage, final float damagePerLevel, final AbilityType abilityType,
                   boolean stunningAbility, boolean futureEffectAbility){
        baseDamage = damage;
        bonusBaseDmgPerLvl = damagePerLevel;
        type = abilityType;
        stunning = stunningAbility;
        futureEffect = futureEffectAbility;
    }

}
