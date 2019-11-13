package com.Ability;

import static com.Utils.Constants.*;
public class Backstab extends Ability {
    private int used;
    public Backstab() {
        super(BS_DAMAGE, BS_DMG_PER_LVL, AbilityType.Backstab, false, false);
        used = ZERO;
    }
}
