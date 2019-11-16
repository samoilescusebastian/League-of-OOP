package com.character;

import com.Ability.*;
import com.Location.*;

import static com.Utils.Constants.*;

public class Character implements CharacterInterface{
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    protected Point location;
    protected float DoTDamage;
    protected float DoTLife;
    protected int maxHP;
    protected int XP;
    protected int HP;
    protected int HPPerLvl;
    protected int LVL;
    protected int paralysisLife;
    protected boolean alive;
    protected int takenDamage;
    protected Ability baseAbility;
    protected Ability specialAbility;
    protected CharacterType type;
    Character(final int HP, final int HPPerLvl, Ability baseAbility, Ability specialAbility,
              Point location, CharacterType type) {
        XP = ZERO;
        LVL = ZERO;
        paralysisLife = ZERO;
        alive = true;
        maxHP = HP;
        this.HP = HP;
        this.HPPerLvl = HPPerLvl;
        this.baseAbility = baseAbility;
        this.specialAbility = specialAbility;
        this.location = location;
        this.type = type;

    }

    public void setLocationBonus(Land cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    public void setLocationBonus(Volcanic cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    public void setLocationBonus(Desert cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    public void setLocationBonus(Woods cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }

    public void acceptAbility(Backstab ability) {
        loadBaseDamage(ability, NEUTRAL);

    }
    public void acceptAbility(Paralysis ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }
    public void acceptAbility(Deflect ability) {
        int takenDmg = ability.getTakenDmg();
        loadBaseDamage(ability, takenDmg);

    }
    public void acceptAbility(Drain ability) {
        float minHp = Math.min(DR_HP_DEP * maxHP, HP);
        loadBaseDamage(ability, minHp);

    }
    public void acceptAbility(Execute ability) {

        if (ability.getEffectiveHPPercentage() >= getHPPercentage()) {
            alive = false;
        } else {
            loadBaseDamage(ability, NEUTRAL);
        }

    }
    public void acceptAbility(Slam ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }
    public void acceptAbility(Fireblast ability) {
       loadBaseDamage(ability, NEUTRAL);

    }
    public void acceptAbility(Ignite ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }
    private void acceptDamage(final float effectiveDmg) {
        HP -= effectiveDmg;
        if (HP < ZERO) {
            alive = false;
        }

    }
    public float getHPPercentage() {
        return (HP * FULL_PERCENTAGE) / maxHP;
    }

    void loadBaseDamage(Ability ability, final float factor) {
        System.out.println(ability.getLevelDamage() * factor);
        takenDamage += Math.round((ability.getLevelDamage())) * factor;
        ability.addBonuses();
        System.out.println(ability.getEffectiveBaseDmg() * factor);
        acceptDamage(Math.round(ability.getEffectiveBaseDmg() * factor));
    }
    void loadSpecialDamage(SpecialAbility ability) {
        System.out.println(ability.getLocationBonus());
        System.out.println(ability.getRacialBonus());
        System.out.println(ability.getEffectiveRoundDmg());
        DoTDamage = ability.getEffectiveRoundDmg();
        DoTLife = ability.getDamageLife();
        paralysisLife = ability.getParalysisLife();
    }
    public Ability getBaseAbility() {
        return baseAbility;
    }
    public Ability getSpecialAbility() {
        return specialAbility;
    }
    public CharacterType getType() {
        return type;
    }

}
