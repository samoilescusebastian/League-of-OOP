package strategy;
import character.Character;

public final class HpStrategy implements StrategyBehaviour {
    private Character player;
    private int hpFactor;
    private float abilityFactor;
    public HpStrategy(final Character player, final int hpFactor, final float abilityFactor) {
        this.player = player;
        this.hpFactor = hpFactor;
        this.abilityFactor = abilityFactor;
    }
    @Override
    public void applyStrategy() {
        player.modifyHp(hpFactor);
        player.setAbilitiesModifier(abilityFactor);

    }
}
