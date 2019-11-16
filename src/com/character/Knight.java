package com.character;

import com.Ability.*;
import com.Location.Land;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Knight extends Character{
    public Knight(Point location) {
        super(KG_INIT_HP, KG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Execute),
                abilityFactory.createAbility(AbilityType.Slam), location, CharacterType.Knight);
    }
    public void setLocationBonus(final Land cell) {
        baseAbility.setLocationBonus(LAND_BONUS);
        specialAbility.setLocationBonus(LAND_BONUS);
    }
    public void acceptAbility(Backstab ability) {
        ability.setRacialBonus(BS_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Paralysis ability) {
        ability.setRacialBonus(PL_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Deflect ability){
        ability.setRacialBonus(DF_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Drain ability){
        ability.setRacialBonus(DR_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Execute ability) {
        ability.setRacialBonus(EX_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Slam ability) {
        ability.setRacialBonus(SL_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Fireblast ability) {
        ability.setRacialBonus(FB_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Ignite ability) {
        ability.setRacialBonus(IG_KNIGHT_BONUS);
        super.acceptAbility(ability);
    }
}
