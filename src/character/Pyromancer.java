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
import location.Volcanic;
import strategy.DamageStrategy;
import strategy.HpStrategy;

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
}
