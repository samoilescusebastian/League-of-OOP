package com.character;

import com.Ability.*;
import com.Location.*;

import static com.Utils.Constants.*;

public class Character implements CharacterInterface{
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    private static int instances = 0;
    protected int ID;
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
    protected char type;
    Character(final int HP, final int HPPerLvl, Ability baseAbility, Ability specialAbility,
              Point location, char type) {
        ID = instances++;
        DoTDamage = ZERO;
        DoTLife = ZERO;
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
//        System.out.println(Math.round(ability.getLevelDamage() * factor));
        takenDamage += Math.round((ability.getLevelDamage())) * factor;
        ability.addBonuses();
//        System.out.println(Math.round(ability.getEffectiveBaseDmg() * factor));
        acceptDamage(Math.round(ability.getEffectiveBaseDmg() * factor));
    }
    void loadSpecialDamage(SpecialAbility ability) {
//        System.out.println(ability.getLocationBonus());
//        System.out.println(ability.getRacialBonus());
//        System.out.println(ability.getEffectiveRoundDmg());
        DoTDamage = ability.getEffectiveRoundDmg();
        DoTLife = ability.getDamageLife();
        paralysisLife = ability.getParalysisLife();
//        System.out.println("-----------");
    }
    public void move(char direction) {
        if (paralysisLife >= 0) {
            return;
        }
        switch(direction){
            case 'U':
                location.add(UP);
                break;
            case 'D':
                location.add(DOWN);
                break;
            case 'L':
                location.add(LEFT);
                break;
            case 'R':
                location.add(RIGHT);
                break;
            default:
                break;

        }
    }
    public void attack(Character victim, Map map) {
        Ability baseAbility = this.getBaseAbility();
        Ability specialAbility = this.getSpecialAbility();
        baseAbility.computeLvlDamage(LVL, takenDamage);
        specialAbility.computeLvlDamage(LVL, takenDamage);
        baseAbility.strike(victim);
        specialAbility.strike(victim);
        if (victim.getHP() <= ZERO) {
            victim.markAsDead(map);
            XP += Math.max(ZERO, XP_REF - (this.LVL - victim.getLVL() * XP_AMP));
            updateLevel();
        }
    }
    public void resetAbilities() {
        baseAbility.resetAbility();
        specialAbility.resetAbility();
    }
    public void resetTakenDamage() {
        takenDamage = ZERO;
    }
    public Ability getBaseAbility() {
        return baseAbility;
    }
    public Ability getSpecialAbility() {
        return specialAbility;
    }
    public char getType() {
        return type;
    }
    public Point getLocation() {
        return location;
    }
    public int getID() {
        return ID;
    }
    public int getParalysisLife() {
        return paralysisLife;
    }
    public int getHP() {
        return HP;
    }
    public int getLVL() {
        return LVL;
    }
    public void decreaseParalysisLife() {
        paralysisLife--;
    }

    public boolean takeDoT() {
        if (DoTLife > 0) {
            HP -= DoTDamage;
            DoTLife--;
        }
        return HP <= 0;
    }
    public void markAsDead(Map map) {
        Cell cell = map.getCell(location.getX(), location.getY());
        cell.deleteCharacter(ID);
        alive = false;
    }
    public void updateLevel() {
        if (XP >= LVL_UP_XP_BASE) {
            LVL = ((XP - LVL_UP_XP_BASE) / LVL_UP_AMP) + 1;
        }
    }

    @Override
    public String toString() {
        if (alive) {
            return type + " " + LVL + " " + XP + " " + HP + " " + location;
        }
        return type + " dead";
    }
}
