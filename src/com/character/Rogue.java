package com.character;

import com.Ability.AbilityType;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Rogue extends Character {
    public Rogue(Point location) {
        super(ROG_INIT_HP, ROG_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Backstab),
                abilityFactory.createAbility(AbilityType.Paralysis), location);
    }
}
