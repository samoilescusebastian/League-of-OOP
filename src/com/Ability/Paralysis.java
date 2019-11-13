package com.Ability;

import static com.Utils.Constants.*;
public class Paralysis extends Ability {
    private int roundOvertime;
    public Paralysis() {
        super(PL_DAMAGE, PL_PER_LVL, AbilityType.Paralysis, false, true);
        roundOvertime = TIMES;
    }
}
