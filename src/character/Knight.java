package character;

import ability.Backstab;
import ability.AbilityType;
import ability.Paralysis;
import ability.Execute;
import ability.Ignite;
import ability.Drain;
import ability.Deflect;
import ability.Slam;
import ability.Fireblast;
import angel.*;
import location.Land;
import location.Point;
import strategy.DamageStrategy;
import strategy.HpStrategy;

import java.io.IOException;

import static utils.Constants.*;

public final class Knight extends Character {
    public Knight(final Point location) {
        super(KG_INIT_HP, KG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Execute),
                abilityFactory.createAbility(AbilityType.Slam), location, 'K');
    }
    public void setLocationBonus(final Land cell) {
        baseAbility.setLocationBonus(LAND_BONUS);
        specialAbility.setLocationBonus(LAND_BONUS);
    }
    public void acceptAbility(final Backstab ability) {
        ability.setRacialBonus(BS_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Paralysis ability) {
        ability.setRacialBonus(PL_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Deflect ability) {
        ability.setRacialBonus(DF_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Drain ability) {
        ability.setRacialBonus(DR_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Execute ability) {
        ability.setRacialBonus(EX_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Slam ability) {
        ability.setRacialBonus(SL_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Fireblast ability) {
        ability.setRacialBonus(FB_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Ignite ability) {
        ability.setRacialBonus(IG_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptVisit(final DamageAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += KNIGHT_DMG_ANGEL_MODIFIER;

    }
    public void acceptVisit(final DarkAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += KNIGHT_DARK_ANGEL_MODIFIER;
    }
    public void acceptVisit(final Dracula angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += KNIGHT_DMG_DRACULA_MODIFIER;
        addHp(KNIGHT_HP_DRACULA_MODIFIER);
    }
    public void acceptVisit(final GoodBoy angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += KNIGHT_DMG_GOODBOY_MODIFIER;
        addHp(KNIGHT_HP_GOODBOY_MODIFIER);
    }
    public void acceptVisit(final LevelUpAngel angel) throws IOException {
        angel.setHelpState(this);
        int experience = computeNeededHP();
        addExperience(experience);
        updateLevel();
        angelFactor += KNIGHT_DMG_LU_ANGEL_MODIFIER;
    }
    public void acceptVisit(final LifeGiver angel) throws IOException {
        angel.setHelpState(this);
        addHp(KNIGHT_LIFE_GIVER_ANGEL_MODIFIER);
    }
    public void acceptVisit(final SmallAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += KNIGHT_DMG_S_ANGEL_MODIFIER;
        addHp(KNIGHT_HP_S_ANGEL_MODIFIER);
    }
    public void acceptVisit(final Spawner angel) throws IOException {
        if (!alive) {
            angel.setHelpState(this);
            setRespawnState();
            alive = true;
            currentHp = KNIGHT_HP_SPAWNER_MODIFIER;
        }
    }
    public void acceptVisit(final TheDoomer angel) throws IOException {
        angel.setHelpState(this);
        markAsDead();
    }
    public void acceptVisit(final XPAngel angel) throws IOException {
        angel.setHelpState(this);
        addExperience(KNIGHT_XP_ANGEL_MODIFIER);
        updateLevel();
    }
    public final void chooseStrategy() {
       super.getBestStrategy(KNIGHT_INF_HP, KNIGHT_SUP_HP, KNIGHT_HP_STRIP, KNIGHT_ABILITIES_STRIP,
                            KNIGHT_HP_SUPPLY, KNIGHT_ABILITIES_SUPPLY);
    }
}
