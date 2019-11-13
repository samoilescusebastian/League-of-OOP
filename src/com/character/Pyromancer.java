package com.character;
import com.Ability.AbilityType;
import com.Location.Point;

import static com.Utils.Constants.*;
public class Pyromancer extends Character {

    public Pyromancer(Point Location) {
        super(PYRO_INIT_HP, PYRO_HP_PER_LVL, abilityFactory.createAbility(AbilityType.Fireblast),
                abilityFactory.createAbility(AbilityType.Ignite), Location);

    }
}
