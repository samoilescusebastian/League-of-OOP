package com.Ability;

public class AbilityFactory {
    private static AbilityFactory  factory = null;
    private AbilityFactory() { };
    public static AbilityFactory getInstance() {
        if (factory == null) {
            factory = new AbilityFactory();
        }
        return factory;
    }
    public Ability createAbility(AbilityType type) {
        Ability newAbility = null;
        switch (type) {
            case Fireblast:
                newAbility = new Fireblast();
                break;
            case Ignite:
                newAbility = new Ignite();
                break;
            case Execute:
                newAbility = new Execute();
                break;
            case Slam:
                newAbility = new Slam();
                break;
            case Drain:
                newAbility = new Drain();
                break;
            case Deflect:
                newAbility = new Deflect();
                break;
            case Backstab:
                newAbility = new Backstab();
                break;
            case Paralysis:
                newAbility = new Paralysis();
                break;
        }
        return newAbility;
    }
}
