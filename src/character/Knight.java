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
import location.Land;
import location.Point;
import strategy.DamageStrategy;
import strategy.HpStrategy;

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
    public final void chooseStrategy() {
       super.getBestStrategy(KNIGHT_INF_HP, KNIGHT_SUP_HP, KNIGHT_HP_STRIP, KNIGHT_ABILITIES_STRIP,
                            KNIGHT_HP_SUPPLY, KNIGHT_ABILITIES_SUPPLY);
    }
}
