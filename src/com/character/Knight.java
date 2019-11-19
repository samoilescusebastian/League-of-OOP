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
import com.Location.Land;
import com.Location.Point;

import static com.Utils.Constants.KG_HP_PER_LVL;
import static com.Utils.Constants.KG_INIT_HP;
import static com.Utils.Constants.LAND_BONUS;
import static com.Utils.Constants.BS_KNIGHT_BONUS;
import static com.Utils.Constants.PL_KNIGHT_BONUS;
import static com.Utils.Constants.DF_KNIGHT_BONUS;
import static com.Utils.Constants.DR_KNIGHT_BONUS;
import static com.Utils.Constants.EX_KNIGHT_BONUS;
import static com.Utils.Constants.SL_KNIGHT_BONUS;
import static com.Utils.Constants.FB_KNIGHT_BONUS;
import static com.Utils.Constants.IG_KNIGHT_BONUS;
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
}
