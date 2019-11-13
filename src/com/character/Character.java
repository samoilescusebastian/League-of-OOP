package com.character;

import com.Ability.Ability;
import com.Ability.AbilityFactory;
import com.Location.Point;

import static com.Utils.Constants.ZERO;

abstract public class Character {
    protected static AbilityFactory abilityFactory = AbilityFactory.getInstance();
    protected int maxHP;
    protected int XP;
    protected int HP;
    protected int HPPerLvl;
    protected int LVL;
    protected Point location;
    protected int stunned;
    protected boolean alive;
    protected Ability baseAbility;
    protected Ability specialAbility;
    Character(final int HP, final int HPPerLvl, Ability baseAbility, Ability specialAbility, Point location) {
        XP = ZERO;
        LVL = ZERO;
        stunned = ZERO;
        alive = true;
        maxHP = HP;
        this.HP = HP;
        this.HPPerLvl = HPPerLvl;
        this.baseAbility = baseAbility;
        this.specialAbility = specialAbility;
        this.location = location;

    }
    void attack(Character victim) {}
    void levelUp() {}
    void loadBaseAbility() {}
    void loadSpecialAbility() {}

}
