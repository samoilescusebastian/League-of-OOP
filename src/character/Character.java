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
import angel.XPAngel;
import angel.DarkAngel;
import angel.DamageAngel;
import angel.Dracula;
import angel.GoodBoy;
import angel.LevelUpAngel;
import angel.LifeGiver;
import angel.SmallAngel;
import angel.Spawner;
import angel.TheDoomer;
import game.Observable;
import game.Observer;
import location.Land;
import location.Point;
import location.Volcanic;
import location.Desert;
import location.Woods;
import strategy.DamageStrategy;
import strategy.HpStrategy;
import strategy.StrategyBehaviour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.ZERO;
import static utils.Constants.NO_EFFECT;
import static utils.Constants.NEUTRAL;
import static utils.Constants.DR_HP_DEP;
import static utils.Constants.UP;
import static utils.Constants.DOWN;
import static utils.Constants.RIGHT;
import static utils.Constants.LEFT;
import static utils.Constants.LVL_UP_XP_BASE;
import static utils.Constants.FULL_PERCENTAGE;
import static utils.Constants.LVL_UP_AMP;

public abstract class Character implements Observable {
    protected List<Observer> observers;
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    private static int instances = 0;
    protected int id;
    protected Point location;
    protected float dotDamage;
    protected float dotLife;
    protected int baseHp;
    protected int maxHp;
    protected int xp;
    protected int currentHp;
    protected int hpPerLevel;
    protected int level;
    protected int paralysisLife;
    protected boolean alive;
    protected int takenDamage;
    protected Ability baseAbility;
    protected Ability specialAbility;
    protected char type;
    protected StrategyBehaviour strategy;
    protected float angelFactor;
    protected String state;
    private static fileio.FileSystem fs;
    Character(final int currentHp, final int hpPerLevel, final Ability baseAbility,
              final Ability specialAbility, final Point location, final char type) {
        observers = new ArrayList<>();
        id = instances++;
        dotDamage = ZERO;
        dotLife = ZERO;
        xp = ZERO;
        level = ZERO;
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
            currentHp = 0;
        }

    }
    public abstract void acceptVisit(DamageAngel angel) throws IOException;
    public abstract void acceptVisit(DarkAngel angel) throws IOException;
    public abstract void acceptVisit(Dracula angel) throws IOException;
    public abstract void acceptVisit(GoodBoy angel) throws IOException;
    public abstract void acceptVisit(LevelUpAngel angel) throws IOException;
    public abstract void acceptVisit(LifeGiver angel) throws IOException;
    public abstract void acceptVisit(SmallAngel angel) throws IOException;
    public abstract void acceptVisit(Spawner angel) throws IOException;
    public abstract void acceptVisit(TheDoomer angel) throws IOException;
    public abstract void acceptVisit(XPAngel angel) throws IOException;

    /**
     * add strategy modifier to base modifiers.
     */
    public void setAbilitiesModifier(final float abilityModifier) {
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
    public final void attack(final Character victim) throws IOException {
        Ability customizedBaseAbility = this.getBaseAbility();
        Ability customizedSpecialAbility = this.getSpecialAbility();
        customizedBaseAbility.computeLvlDamage(level, takenDamage);
        customizedBaseAbility.setAngelFactor(angelFactor);
        customizedSpecialAbility.computeLvlDamage(level, takenDamage);
        customizedSpecialAbility.setAngelFactor(angelFactor);
        customizedBaseAbility.strike(victim);
        customizedSpecialAbility.strike(victim);
        if (victim.getCurrentHp() <= ZERO) {
            victim.setKilledInFightState(this);
            victim.markAsDead();
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
    public final void decreaseParalysisLife() {
        paralysisLife--;
    }
    public final float getCurrentHp() {
        return currentHp;
    }
    public final void modifyHp(final int factor) {
        currentHp += (currentHp / factor);
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }
    public final void addHp(final int hpToAdd) {
        currentHp += hpToAdd;
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }
    public final float getHPPercentage() {
        return (currentHp * FULL_PERCENTAGE) / maxHp;
    }
    public final int getLevel() {
        return level;
    }
    public final boolean isDead() {
        return !alive;
    }
    public final boolean isParalysed() {
        return paralysisLife > NO_EFFECT;
    }
    public final boolean takeDoT() {
        if (dotLife > ZERO) {
            currentHp -= dotDamage;
            dotLife--;
        }
        return currentHp <= ZERO;
    }
    public final void markAsDead() {
//        Cell cell = map.getCell(location.getX(), location.getY());
//        cell.deleteCharacter(id);
        alive = false;
        currentHp = ZERO;
//        dotDamage = ZERO;
//        dotLife = ZERO;
//        paralysisLife = ZERO;
    }
    public final void updateLevel() throws IOException {
        if (xp >= LVL_UP_XP_BASE) {
            final int newLVL = ((xp - LVL_UP_XP_BASE) / LVL_UP_AMP) + 1;
            if (newLVL > level) {
                currentHp = baseHp + hpPerLevel * newLVL;
                maxHp = baseHp + hpPerLevel * newLVL;
                setLevelUpState(newLVL);
                level = newLVL;
            }
        }
    }
    public final int computeNeededHP() {
        return LVL_UP_XP_BASE + level * LVL_UP_AMP - xp;
    }
    public final void addExperience(final int experience) {
        xp += experience;
    }
    public abstract void chooseStrategy();

    /**
     * change strategy based on hp percentage.
     */
    protected void getBestStrategy(final int infHp, final int supHp, final int hpStrip,
                                   final float abilitiesStrip, final int hpSupply,
                                   final float abilitiesSupply) {
        if (maxHp / infHp < currentHp && currentHp < maxHp / supHp) {
            strategy = new DamageStrategy(this, hpStrip, abilitiesSupply);
        } else if (currentHp < maxHp / infHp) {
            strategy = new HpStrategy(this, hpSupply, abilitiesStrip);
        } else {
            strategy = null;
        }
    }
    public final void applyStrategy() {
        if (strategy != null) {
            strategy.applyStrategy();
        }
    }
    /**
     * add a new observer.
     */
    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }
    /**
     * remove an observer.
     */
    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }
    /**
     * notify all observers when state of observable object is changed.
     */
    public void notifyObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(fs, state);
        }
    }
    public final void setRespawnState() throws IOException {
        state = "Player " + CharacterType.convertCharToType(type) + " " + id
                          + " was brought to life by an angel";
        notifyObservers();
    }
    public final void setKilledInFightState(final Character player) throws IOException {
        state = "Player " + CharacterType.convertCharToType(type) + " " + id + " was killed by "
                          + CharacterType.convertCharToType(player.getType()) + " "
                          + player.getId();
        notifyObservers();

    }
    public final void setLevelUpState(final int newLevel) throws IOException {
        for (int lvl = level + 1; lvl <= newLevel; lvl++) {
            state = CharacterType.convertCharToType(type) + " " + id + " reached level " + lvl;
            notifyObservers();
        }
    }
    public final void setKilledByAngelState() throws IOException {
        state = "Player " + CharacterType.convertCharToType(type) + " " + id
                          + " was killed by an angel";
        notifyObservers();
    }
    @Override
    public final String toString() {
        if (alive) {
            return type + " " + level + " " + xp + " " + currentHp + " " + location;
        }
        return type + " dead";
    }
    public static void setFileSystem(final fileio.FileSystem fileSystem) {
        fs = fileSystem;
    }
}
