package com.character;

import com.Ability.AbilityType;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Knight extends Character{
    public Knight(Point location) {
        super(KG_INIT_HP, KG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Execute),
                abilityFactory.createAbility(AbilityType.Slam), location);
    }
}
