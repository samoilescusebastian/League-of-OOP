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
import strategy.DamageStrategy;
import strategy.HpStrategy;

import static utils.Constants.*;

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
    public final void chooseStrategy() {
        super.getBestStrategy(ROGUE_INF_HP, ROGUE_SUP_HP, ROGUE_HP_STRIP, ROGUE_ABILITIES_STRIP,
                ROGUE_HP_SUPPLY, ROGUE_ABILITIES_SUPPLY);
    }
}
