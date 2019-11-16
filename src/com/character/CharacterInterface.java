package com.character;

import com.Ability.Ability;
import com.Ability.Backstab;
import com.Location.Desert;
import com.Location.Land;
import com.Location.Volcanic;
import com.Location.Woods;

public interface CharacterInterface {
    void setLocationBonus(Land cell);
    void setLocationBonus(Desert cell);
    void setLocationBonus(Woods cell);
    void setLocationBonus(Volcanic cell);
    void acceptAbility(Backstab ability);
}
