package com.Ability;

import static com.Utils.Constants.*;
public class Deflect extends Ability {
    private float limit;
    public Deflect() {
        super(DF_PROC, DF_PROC_PER_LVL, AbilityType.Deflect, false, false);
        limit = DF_LIMIT;
    }
}
