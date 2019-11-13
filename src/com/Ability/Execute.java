package com.Ability;
import static com.Utils.Constants.*;

public class Execute extends Ability {
    private float HP;
    private float HP_PER_LVL;
    private float HP_LIMIT;
    public Execute() {
        super(EX_DAMAGE, EX_DMG_PER_LVL, AbilityType.Execute, false, false);
        HP = EX_PROC_HP;
        HP_PER_LVL = EX_PROC_HP_PER_LVL;
        HP_LIMIT = EX_PROC_HP_LIMIT;
    }
}
