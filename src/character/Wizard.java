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
import location.Desert;
import location.Point;
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
import strategy.DamageStrategy;
import strategy.HpStrategy;

import java.io.IOException;

import static utils.Constants.*;

public final class Wizard extends Character {
    public Wizard(final Point location) {
        super(WIZ_INIT_HP, WIZ_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Drain),
                abilityFactory.createAbility(AbilityType.Deflect), location, 'W');
    }
    public void setLocationBonus(final Desert cell) {
        baseAbility.setLocationBonus(DESERT_BONUS);
        specialAbility.setLocationBonus(DESERT_BONUS);
    }
    public void acceptAbility(final Backstab ability) {
        ability.setRacialBonus(BS_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Paralysis ability) {
        ability.setRacialBonus(PL_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Deflect ability) { }

    public void acceptAbility(final Drain ability) {
        ability.setRacialBonus(DR_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Execute ability) {
        ability.setRacialBonus(EX_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Slam ability) {
        ability.setRacialBonus(SL_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Fireblast ability) {
        ability.setRacialBonus(FB_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Ignite ability) {
        ability.setRacialBonus(IG_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public final void chooseStrategy() {
        super.getBestStrategy(WIZARD_INF_HP, WIZARD_SUP_HP, WIZARD_HP_STRIP, WIZARD_ABILITIES_STRIP,
                WIZARD_HP_SUPPLY, WIZARD_ABILITIES_SUPPLY);
    }
    public void acceptVisit(final DamageAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += WIZARD_DMG_ANGEL_MODIFIER;

    }
    public void acceptVisit(final DarkAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += WIZARD_DARK_ANGEL_MODIFIER;
    }
    public void acceptVisit(final Dracula angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += WIZARD_DMG_DRACULA_MODIFIER;
        addHp(WIZARD_HP_DRACULA_MODIFIER);
    }
    public void acceptVisit(final GoodBoy angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += WIZARD_DMG_GOODBOY_MODIFIER;
        addHp(WIZARD_HP_GOODBOY_MODIFIER);
    }
    public void acceptVisit(final LevelUpAngel angel) throws IOException {
        angel.setHelpState(this);
        int experience = computeNeededHP();
        addExperience(experience);
        updateLevel();
        angelFactor += WIZARD_DMG_LU_ANGEL_MODIFIER;
    }
    public void acceptVisit(final LifeGiver angel) throws IOException {
        angel.setHelpState(this);
        addHp(WIZARD_LIFE_GIVER_ANGEL_MODIFIER);
    }
    public void acceptVisit(final SmallAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += WIZARD_DMG_S_ANGEL_MODIFIER;
        addHp(WIZARD_HP_S_ANGEL_MODIFIER);
    }
    public void acceptVisit(final Spawner angel) throws IOException {
        if (!alive) {
            angel.setHelpState(this);
            setRespawnState();
            alive = true;
            currentHp = WIZARD_HP_SPAWNER_MODIFIER;
        }
    }
    public void acceptVisit(final TheDoomer angel) throws IOException {
        angel.setHelpState(this);
        markAsDead();
    }
    public void acceptVisit(final XPAngel angel) throws IOException {
        angel.setHelpState(this);
        addExperience(WIZARD_XP_ANGEL_MODIFIER);
        updateLevel();
    }
}
