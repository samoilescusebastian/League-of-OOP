package com.character;

import com.Ability.Backstab;
import com.Ability.AbilityFactory;
import com.Ability.Ability;
import com.Ability.SpecialAbility;
import com.Ability.Paralysis;
import com.Ability.Execute;
import com.Ability.Ignite;
import com.Ability.Drain;
import com.Ability.Deflect;
import com.Ability.Slam;
import com.Ability.Fireblast;
import com.Location.Cell;
import com.Location.Land;
import com.Location.Point;
import com.Location.Volcanic;
import com.Location.Desert;
import com.Location.Woods;
import com.Location.Map;



import static com.Utils.Constants.ZERO;
import static com.Utils.Constants.NO_EFFECT;
import static com.Utils.Constants.NEUTRAL;
import static com.Utils.Constants.DR_HP_DEP;
import static com.Utils.Constants.FULL_PERCENTAGE;
import static com.Utils.Constants.UP;
import static com.Utils.Constants.DOWN;
import static com.Utils.Constants.LEFT;
import static com.Utils.Constants.RIGHT;
import static com.Utils.Constants.LVL_UP_XP_BASE;
import static com.Utils.Constants.LVL_UP_AMP;
import static com.Utils.Constants.XP_AMP;
import static com.Utils.Constants.XP_REF;

public class Character {
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    private static int instances = 0;
    protected int id;
    protected Point location;
    protected float dotDamage;
    protected float dotLife;
    protected int baseHp;
    protected int maxHp;
    protected int xp;
    protected int hp;
    protected int hpPerLevel;
    protected int lvl;
    protected int paralysisLife;
    protected boolean alive;
    protected int takenDamage;
    protected Ability baseAbility;
    protected Ability specialAbility;
    protected char type;
    Character(final int hp, final int hpPerLevel, final Ability baseAbility,
              final Ability specialAbility, final Point location, final char type) {
        id = instances++;
        dotDamage = ZERO;
        dotLife = ZERO;
        xp = ZERO;
        lvl = ZERO;
        paralysisLife = NO_EFFECT;
        alive = true;
        baseHp = hp;
        maxHp = hp;
        this.hp = hp;
        this.hpPerLevel = hpPerLevel;
        this.baseAbility = baseAbility;
        this.specialAbility = specialAbility;
        this.location = location;
        this.type = type;

    }
    /**
     * set bonuses based on cell type.
     * visit method
     */
    public void setLocationBonus(final Land cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    /**
     * set bonuses based on cell type.
     * visit method
     */
    public void setLocationBonus(final Volcanic cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    /**
     * set bonuses based on cell type.
     * visit method
     */
    public void setLocationBonus(final Desert cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    /**
     * set bonuses based on cell type.
     * visit method
     */
    public void setLocationBonus(final Woods cell) {
        baseAbility.setLocationBonus(ZERO);
        specialAbility.setLocationBonus(ZERO);
    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Backstab ability) {
        loadBaseDamage(ability, NEUTRAL);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Paralysis ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Deflect ability) {
        int takenDmg = ability.getTakenDmg();
        loadBaseDamage(ability, takenDmg);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Drain ability) {
        float minHp = Math.min(DR_HP_DEP * maxHp, hp);
        loadBaseDamage(ability, minHp);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Execute ability) {

        if (ability.getEffectiveHpPercentage() >= getHPPercentage()) {
            alive = false;
        } else {
            loadBaseDamage(ability, NEUTRAL);
        }

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Slam ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Fireblast ability) {
       loadBaseDamage(ability, NEUTRAL);

    }
    /**
     * take ability damage.
     * visit method
     */
    public void acceptAbility(final Ignite ability) {
        loadBaseDamage(ability, NEUTRAL);
        loadSpecialDamage(ability);

    }

    private void acceptDamage(final float effectiveDmg) {
        hp -= effectiveDmg;
        if (hp < ZERO) {
            alive = false;
        }

    }
    public final float getHPPercentage() {
        return (hp * FULL_PERCENTAGE) / maxHp;
    }

    private void loadBaseDamage(final Ability ability, final float factor) {
        takenDamage += Math.round(Math.round(ability.getLevelDamage()
                                   * (1 + ability.getLocationBonus())) * factor);
        ability.addBonuses();
        acceptDamage(Math.round(ability.getEffectiveBaseDmg() * factor));
    }
    private void loadSpecialDamage(final SpecialAbility ability) {
        ability.addBonuses();
        dotDamage = ability.getEffectiveRoundDmg();
        dotLife = ability.getDamageLife();
        paralysisLife = ability.getParalysisLife();
    }
    public final void move(final char direction) {
        if (paralysisLife >= ZERO) {
            return;
        }
        switch (direction) {
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
    public final void attack(final Character victim, final Map map) {
        Ability customizedBaseAbility = this.getBaseAbility();
        Ability customizedSpecialAbility = this.getSpecialAbility();
        customizedBaseAbility.computeLvlDamage(lvl, takenDamage);
        customizedSpecialAbility.computeLvlDamage(lvl, takenDamage);
        customizedBaseAbility.strike(victim);
        customizedSpecialAbility.strike(victim);
        if (victim.getHp() <= ZERO) {
            victim.markAsDead(map);
            xp += Math.max(ZERO, XP_REF - (this.lvl - victim.getLvl() * XP_AMP));
        }
    }
    public final void resetAbilities() {
        baseAbility.resetAbility();
        specialAbility.resetAbility();
    }
    public final void resetTakenDamage() {
        takenDamage = ZERO;
    }
    public final Ability getBaseAbility() {
        return baseAbility;
    }
    public final Ability getSpecialAbility() {
        return specialAbility;
    }
    public final char getType() {
        return type;
    }
    public final Point getLocation() {
        return location;
    }
    public final int getId() {
        return id;
    }
    public final int getParalysisLife() {
        return paralysisLife;
    }
    public final int getHp() {
        return hp;
    }
    public final int getLvl() {
        return lvl;
    }
    public final void decreaseParalysisLife() {
        paralysisLife--;
    }
    public final boolean isDead() {
        return !alive;
    }
    public final boolean takeDoT() {
        if (dotLife > 0) {
            hp -= dotDamage;
            dotLife--;
        }
        return hp <= 0;
    }
    public final void markAsDead(final Map map) {
        Cell cell = map.getCell(location.getX(), location.getY());
        cell.deleteCharacter(id);
        alive = false;
        dotDamage = ZERO;
        dotLife = ZERO;
        paralysisLife = ZERO;
    }
    public final void updateLevel() {
        if (xp >= LVL_UP_XP_BASE) {
            final int newLVL = ((xp - LVL_UP_XP_BASE) / LVL_UP_AMP) + 1;
            if (newLVL > lvl) {
                hp = baseHp + hpPerLevel * newLVL;
                maxHp = baseHp + hpPerLevel * newLVL;
                lvl = newLVL;
            }
        }

    }

    @Override
    public final String toString() {
        if (alive) {
            return type + " " + lvl + " " + xp + " " + hp + " " + location;
        }
        return type + " dead";
    }
}
