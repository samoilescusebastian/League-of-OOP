package com.Ability;

import static com.Utils.Constants.*;
public class Drain extends Ability{
    public Drain() {
        super(DR_HP_PROC, DR_PROC_PER_LEVEL, AbilityType.Drain, false, false);
    }
}
