package character;

import ability.Backstab;
import ability.AbilityFactory;
import ability.Ability;
import ability.SpecialAbility;
import ability.Paralysis;
import ability.Execute;
import ability.Ignite;
import ability.Drain;
import ability.Deflect;
import ability.Slam;
import ability.Fireblast;
import location.Cell;
import location.Land;
import location.Point;
import location.Volcanic;
import location.Desert;
import location.Woods;
import location.Map;
import strategy.DamageStrategy;
import strategy.HpStrategy;
import strategy.StrategyBehaviour;

import static utils.Constants.*;

public abstract class Character {
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    private static int instances = 0;
    protected int id;
    protected Point location;
    protected float dotDamage;
    protected float dotLife;
    protected float baseHp;
    protected float maxHp;
    protected int xp;
    protected float currentHp;
    protected float hpPerLevel;
    protected int lvl;
    protected int paralysisLife;
    protected boolean alive;
    protected int takenDamage;
    protected Ability baseAbility;
    protected Ability specialAbility;
    protected char type;
    protected StrategyBehaviour strategy;
    private float angelFactor;
    Character(final float currentHp, final float hpPerLevel, final Ability baseAbility,
              final Ability specialAbility, final Point location, final char type) {
        id = instances++;
        dotDamage = ZERO;
        dotLife = ZERO;
        xp = ZERO;
        lvl = ZERO;
        paralysisLife = NO_EFFECT;
        alive = true;
        baseHp = currentHp;
        maxHp = currentHp;
        this.currentHp = currentHp;
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
        float minHp = Math.min(DR_HP_DEP * maxHp, currentHp);
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
        currentHp -= effectiveDmg;
        if (currentHp < ZERO) {
            alive = false;
        }

    }
//    public abstract void acceptVisit() {

//    }
    public void setAbilitiesModifier(float abilityModifier) {
        baseAbility.setStrategyFactor(abilityModifier);
        specialAbility.setStrategyFactor(abilityModifier);

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
    public final void attack(final Character victim) {
        Ability customizedBaseAbility = this.getBaseAbility();
        Ability customizedSpecialAbility = this.getSpecialAbility();
        customizedBaseAbility.computeLvlDamage(lvl, takenDamage);
        customizedSpecialAbility.computeLvlDamage(lvl, takenDamage);
        customizedBaseAbility.strike(victim);
        customizedSpecialAbility.strike(victim);
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
    public final void decreaseParalysisLife() {
        paralysisLife--;
    }
    public final float getCurrentHp() {
        return currentHp;
    }
    public final void modifyHp(final int factor) {
        currentHp += (currentHp / factor);
    }
    public final float getHPPercentage() {
        return (currentHp * FULL_PERCENTAGE) / maxHp;
    }
    public final int getLvl() {
        return lvl;
    }
    public final boolean isDead() {
        return !alive;
    }
    public final boolean takeDoT() {
        if (dotLife > 0) {
            currentHp -= dotDamage;
            dotLife--;
        }
        return currentHp <= 0;
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
                currentHp = baseHp + hpPerLevel * newLVL;
                maxHp = baseHp + hpPerLevel * newLVL;
                lvl = newLVL;
            }
        }
    }
    public final void addExperience(final int experience) {
        xp += experience;
    }
    public abstract void chooseStrategy();
    protected void getBestStrategy(int infHp, int supHp, int hpStrip, float abilitiesStrip,
                               int hpSupply, float abilitiesSupply) {
        if (maxHp / infHp < currentHp && currentHp < maxHp / supHp) {
            strategy = new DamageStrategy(this, hpStrip, abilitiesSupply);
        } else if (currentHp < maxHp / infHp){
            strategy = new HpStrategy(this, hpSupply, abilitiesStrip);
        }
    }
    public final void applyStrategy() {
        if (strategy != null) {
            strategy.applyStrategy();
        }
    }
    @Override
    public final String toString() {
        if (alive) {
            return type + " " + lvl + " " + xp + " " + currentHp + " " + location;
        }
        return type + " dead";
    }
}
