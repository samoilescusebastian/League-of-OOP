package com.character;
import com.Ability.*;
import com.Location.Cell;
import com.Location.Point;
import com.Location.Volcanic;

import static com.Utils.Constants.*;
public class Pyromancer extends Character {

    public Pyromancer(Point Location) {
        super(PYRO_INIT_HP, PYRO_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Fireblast),
                abilityFactory.createAbility(AbilityType.Ignite), Location, CharacterType.Pyromancer);

    }
    public void setLocationBonus(Volcanic cell) {
        baseAbility.setLocationBonus(VOLCANIC_BONUS);
        specialAbility.setLocationBonus(VOLCANIC_BONUS);
    }
    public void acceptAbility(Backstab ability) {
        ability.setRacialBonus(BS_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Paralysis ability) {
        ability.setRacialBonus(PL_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Deflect ability){
        ability.setRacialBonus(DF_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Drain ability){
        ability.setRacialBonus(DR_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Execute ability) {
        ability.setRacialBonus(EX_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Slam ability) {
        ability.setRacialBonus(SL_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Fireblast ability) {
        ability.setRacialBonus(FB_PYRO_BONUS);
        super.acceptAbility(ability);
    }
    public void acceptAbility(Ignite ability) {
        ability.setRacialBonus(IG_PYRO_BONUS);
        super.acceptAbility(ability);
    }
}
