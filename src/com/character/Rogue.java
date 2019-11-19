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
import com.Location.Woods;

import static com.Utils.Constants.ROG_HP_PER_LVL;
import static com.Utils.Constants.ROG_INIT_HP;
import static com.Utils.Constants.WOODS_BONUS;
import static com.Utils.Constants.BS_ROGUE_BONUS;
import static com.Utils.Constants.SL_ROGUE_BONUS;
import static com.Utils.Constants.DR_ROGUE_BONUS;
import static com.Utils.Constants.DF_ROGUE_BONUS;
import static com.Utils.Constants.IG_ROGUE_BONUS;
import static com.Utils.Constants.PL_ROGUE_BONUS;
import static com.Utils.Constants.EX_ROGUE_BONUS;
import static com.Utils.Constants.FB_ROGUE_BONUS;
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
}
