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
import location.Point;
import location.Woods;
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

import java.io.IOException;

import static utils.Constants.ROG_INIT_HP;
import static utils.Constants.ROG_HP_PER_LVL;
import static utils.Constants.WOODS_BONUS;
import static utils.Constants.BS_ROGUE_BONUS;
import static utils.Constants.PL_ROGUE_BONUS;
import static utils.Constants.DF_ROGUE_BONUS;
import static utils.Constants.DR_ROGUE_BONUS;
import static utils.Constants.EX_ROGUE_BONUS;
import static utils.Constants.SL_ROGUE_BONUS;
import static utils.Constants.FB_ROGUE_BONUS;
import static utils.Constants.IG_ROGUE_BONUS;
import static utils.Constants.ROGUE_DMG_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_DARK_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_HP_DRACULA_MODIFIER;
import static utils.Constants.ROGUE_DMG_LU_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_HP_S_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_DMG_GOODBOY_MODIFIER;
import static utils.Constants.ROGUE_LIFE_GIVER_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_DMG_S_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_HP_SPAWNER_MODIFIER;
import static utils.Constants.ROGUE_DMG_DRACULA_MODIFIER;
import static utils.Constants.ROGUE_ABILITIES_SUPPLY;
import static utils.Constants.ROGUE_ABILITIES_STRIP;
import static utils.Constants.ROGUE_HP_GOODBOY_MODIFIER;
import static utils.Constants.ROGUE_XP_ANGEL_MODIFIER;
import static utils.Constants.ROGUE_HP_STRIP;
import static utils.Constants.ROGUE_INF_HP;
import static utils.Constants.ROGUE_SUP_HP;
import static utils.Constants.ROGUE_HP_SUPPLY;

public final class Rogue extends Character {
    public Rogue(final Point location) {
        super(ROG_INIT_HP, ROG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Backstab),
                abilityFactory.createAbility(AbilityType.Paralysis), location, 'R');
    }
    public void setLocationBonus(final Woods cell) {
        baseAbility.setLocationBonus(WOODS_BONUS);
        specialAbility.setLocationBonus(WOODS_BONUS);
        ((Backstab) baseAbility).setCritical(true);
        ((Paralysis) specialAbility).addOvertimeBonus();
    }
    public void acceptAbility(final Backstab ability) {
        ability.setRacialBonus(BS_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Paralysis ability) {
        ability.setRacialBonus(PL_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Deflect ability) {
        ability.setRacialBonus(DF_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Drain ability) {
        ability.setRacialBonus(DR_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Execute ability) {
        ability.setRacialBonus(EX_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Slam ability) {
        ability.setRacialBonus(SL_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Fireblast ability) {
        ability.setRacialBonus(FB_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(final Ignite ability) {
        ability.setRacialBonus(IG_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void chooseStrategy() {
        super.getBestStrategy(ROGUE_INF_HP, ROGUE_SUP_HP, ROGUE_HP_STRIP, ROGUE_ABILITIES_STRIP,
                ROGUE_HP_SUPPLY, ROGUE_ABILITIES_SUPPLY);
    }

    public void acceptVisit(final DamageAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += ROGUE_DMG_ANGEL_MODIFIER;

    }
    public void acceptVisit(final DarkAngel angel) throws IOException {
        angel.setHelpState(this);
        addHp(ROGUE_DARK_ANGEL_MODIFIER);
    }
    public void acceptVisit(final Dracula angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += ROGUE_DMG_DRACULA_MODIFIER;
       addHp(ROGUE_HP_DRACULA_MODIFIER);
    }
    public void acceptVisit(final GoodBoy angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += ROGUE_DMG_GOODBOY_MODIFIER;
        addHp(ROGUE_HP_GOODBOY_MODIFIER);
    }
    public void acceptVisit(final LevelUpAngel angel) throws IOException {
        angel.setHelpState(this);
        int experience = computeNeededHP();
        addExperience(experience);
        updateLevel();
        angelFactor += ROGUE_DMG_LU_ANGEL_MODIFIER;
    }
    public void acceptVisit(final LifeGiver angel) throws IOException {
        angel.setHelpState(this);
        addHp(ROGUE_LIFE_GIVER_ANGEL_MODIFIER);
    }
    public void acceptVisit(final SmallAngel angel) throws IOException {
        angel.setHelpState(this);
        angelFactor += ROGUE_DMG_S_ANGEL_MODIFIER;
        addHp(ROGUE_HP_S_ANGEL_MODIFIER);
    }
    public void acceptVisit(final Spawner angel) throws IOException {
        if (!alive) {
            angel.setHelpState(this);
            setRespawnState();
            alive = true;
            angelFactor = 0;
            currentHp = ROGUE_HP_SPAWNER_MODIFIER;
        }
    }
    public void acceptVisit(final TheDoomer angel) throws IOException {
        angel.setHelpState(this);
        markAsDead();
    }
    public void acceptVisit(final XPAngel angel) throws IOException {
        angel.setHelpState(this);
        addExperience(ROGUE_XP_ANGEL_MODIFIER);
        updateLevel();
    }
}
