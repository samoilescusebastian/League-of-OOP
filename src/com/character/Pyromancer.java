package com.character;
import com.Ability.Backstab;
import com.Ability.AbilityType;
import com.Ability.Paralysis;
import com.Ability.Execute;
import com.Ability.Ignite;
import com.Ability.Drain;
import com.Ability.Deflect;
import com.Ability.Slam;
import com.Ability.Fireblast;
import com.Location.Point;
import com.Location.Volcanic;

import static com.Utils.Constants.PYRO_HP_PER_LVL;
import static com.Utils.Constants.PYRO_INIT_HP;
import static com.Utils.Constants.VOLCANIC_BONUS;
import static com.Utils.Constants.BS_PYRO_BONUS;
import static com.Utils.Constants.PL_PYRO_BONUS;
import static com.Utils.Constants.DF_PYRO_BONUS;
import static com.Utils.Constants.DR_PYRO_BONUS;
import static com.Utils.Constants.EX_PYRO_BONUS;
import static com.Utils.Constants.SL_PYRO_BONUS;
import static com.Utils.Constants.FB_PYRO_BONUS;
import static com.Utils.Constants.IG_PYRO_BONUS;
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
}
