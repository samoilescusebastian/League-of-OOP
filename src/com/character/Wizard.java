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
import com.Location.Desert;
import com.Location.Point;

import static com.Utils.Constants.WIZ_HP_PER_LVL;
import static com.Utils.Constants.WIZ_INIT_HP;
import static com.Utils.Constants.DESERT_BONUS;
import static com.Utils.Constants.BS_WIZARD_BONUS;
import static com.Utils.Constants.PL_WIZARD_BONUS;
import static com.Utils.Constants.SL_WIZARD_BONUS;
import static com.Utils.Constants.IG_WIZARD_BONUS;
import static com.Utils.Constants.FB_WIZARD_BONUS;
import static com.Utils.Constants.EX_WIZARD_BONUS;
import static com.Utils.Constants.DR_WIZARD_BONUS;
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
}
