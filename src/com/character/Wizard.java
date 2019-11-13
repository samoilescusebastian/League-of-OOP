package com.character;

import com.Ability.AbilityFactory;
import com.Ability.AbilityType;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Wizard extends Character {
    public Wizard(Point location) {
        super(WIZ_INIT_HP, WIZ_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Drain),
                abilityFactory.createAbility(AbilityType.Deflect), location);
    }
}
