package strategy;
import character.Character;

public class DamageStrategy implements StrategyBehaviour {
    private Character player;
    private int hpFactor;
    private float abilityFactor;
    public DamageStrategy(final Character player, final int hpFactor, final float abilityFactor) {
        this.player = player;
        this.hpFactor = hpFactor;
        this.abilityFactor = abilityFactor;
    }
    @Override
    public void applyStrategy() {
        System.out.println(player.getType() + String.valueOf(player.getId()) + " applied Damage Strategy");
        player.modifyHp(hpFactor);
        player.setAbilitiesModifier(abilityFactor);

    }
}
