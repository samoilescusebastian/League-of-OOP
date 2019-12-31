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
import game.Observer;
import location.Point;
import location.Volcanic;
import strategy.DamageStrategy;
import strategy.HpStrategy;

import java.io.IOException;

import static utils.Constants.*;

public final class Pyromancer extends Character {

    public Pyromancer(final Point location) {
        super(PYRO_INIT_HP, PYRO_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Fireblast),
                abilityFactory.createAbility(AbilityType.Ignite), location, 'P');

    }
    public void setLocationBonus(final Volcanic cell) {
        baseAbility.setLocationBonus(VOLCANIC_BONUS);
        specialAbility.setLocationBonus(VOLCANIC_BONUS);
    }
    public void acceptAbility(final Backstab ability) {
        ability.setRacialBonus(BS_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Paralysis ability) {
        ability.setRacialBonus(PL_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Deflect ability) {
        ability.setRacialBonus(DF_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Drain ability) {
        ability.setRacialBonus(DR_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Execute ability) {
        ability.setRacialBonus(EX_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Slam ability) {
        ability.setRacialBonus(SL_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Fireblast ability) {
        ability.setRacialBonus(FB_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Ignite ability) {
        ability.setRacialBonus(IG_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public final void chooseStrategy() {
        super.getBestStrategy(PYRO_INF_HP, PYRO_SUP_HP, PYRO_HP_STRIP, PYRO_ABILITIES_STRIP,
                PYRO_HP_SUPPLY, PYRO_ABILITIES_SUPPLY);
    }
    public void acceptVisit(final DamageAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += PYRO_DMG_ANGEL_MODIFIER;

    }
    public void acceptVisit(final DarkAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += PYRO_DARK_ANGEL_MODIFIER;
    }
    public void acceptVisit(final Dracula angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += PYRO_DMG_DRACULA_MODIFIER;
        addHp(PYRO_HP_DRACULA_MODIFIER);
    }
    public void acceptVisit(final GoodBoy angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += PYRO_DMG_GOODBOY_MODIFIER;
        addHp(PYRO_HP_GOODBOY_MODIFIER);
    }
    public void acceptVisit(final LevelUpAngel angel) throws IOException {
        angel.setHelpState(this);
        int experience = computeNeededHP();
        addExperience(experience);
        updateLevel();
        angelFactor += PYRO_DMG_LU_ANGEL_MODIFIER;
    }
    public void acceptVisit(final LifeGiver angel) throws IOException {
        angel.setHelpState(this);
        addHp(PYRO_LIFE_GIVER_ANGEL_MODIFIER);
    }
    public void acceptVisit(final SmallAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += PYRO_DMG_S_ANGEL_MODIFIER;
        addHp(PYRO_HP_S_ANGEL_MODIFIER);
    }
    public void acceptVisit(final Spawner angel) throws IOException {
        if (!alive) {
            angel.setHelpState(this);
            setRespawnState();
            alive = true;
            currentHp = PYRO_HP_SPAWNER_MODIFIER;
        }
    }
    public void acceptVisit(final TheDoomer angel) throws IOException {
        angel.setHelpState(this);
        markAsDead();
    }
    public void acceptVisit(final XPAngel angel) throws IOException {
        angel.setHelpState(this);
        addExperience(PYRO_XP_ANGEL_MODIFIER);
        updateLevel();
    }

}
