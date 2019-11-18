package com.character;

import com.Ability.*;
import com.Location.Cell;
import com.Location.Desert;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Wizard extends Character {
    public Wizard(Point location) {
        super(WIZ_INIT_HP, WIZ_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Drain),
                abilityFactory.createAbility(AbilityType.Deflect), location, 'W');
    }
    public void setLocationBonus(Desert cell) {
        baseAbility.setLocationBonus(DESERT_BONUS);
        specialAbility.setLocationBonus(DESERT_BONUS);
    }
    public void acceptAbility(Backstab ability) {
        ability.setRacialBonus(BS_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Paralysis ability) {
        ability.setRacialBonus(PL_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Deflect ability){ }

    public void acceptAbility(Drain ability){
        ability.setRacialBonus(DR_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Execute ability) {
        ability.setRacialBonus(EX_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Slam ability) {
        ability.setRacialBonus(SL_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Fireblast ability) {
        ability.setRacialBonus(FB_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Ignite ability) {
        ability.setRacialBonus(IG_WIZARD_BONUS);
        super.acceptAbility(ability);
    }
}
