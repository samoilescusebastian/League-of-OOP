package com.character;

import com.Ability.*;
import com.Location.Point;
import com.Location.Woods;

import static com.Utils.Constants.*;
public class Rogue extends Character {
    public Rogue(Point location) {
        super(ROG_INIT_HP, ROG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Backstab),
                abilityFactory.createAbility(AbilityType.Paralysis), location, 'R');
    }
    public void setLocationBonus(Woods cell) {
        baseAbility.setLocationBonus(WOODS_BONUS);
        specialAbility.setLocationBonus(WOODS_BONUS);
        ((Backstab)baseAbility).setCritical(true);
        ((Paralysis)specialAbility).addOvertimeBonus();
    }
    public void acceptAbility(Backstab ability) {
        ability.setRacialBonus(BS_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Paralysis ability) {
        ability.setRacialBonus(PL_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Deflect ability){
        ability.setRacialBonus(DF_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Drain ability){
        ability.setRacialBonus(DR_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Execute ability) {
        ability.setRacialBonus(EX_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Slam ability) {
        ability.setRacialBonus(SL_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Fireblast ability) {
        ability.setRacialBonus(FB_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Ignite ability) {
        ability.setRacialBonus(IG_ROGUE_BONUS);
        super.acceptAbility(ability);
    }
}
