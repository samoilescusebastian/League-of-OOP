package strategy;
import character.Character;

public class HpStrategy implements StrategyBehaviour {
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
        System.out.println(player.getType() + String.valueOf(player.getId()) +" applied HP Strategy");
        player.modifyHp(hpFactor);
        player.setAbilitiesModifier(abilityFactor);

    }
}
