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
import strategy.DamageStrategy;
import strategy.HpStrategy;

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
}
