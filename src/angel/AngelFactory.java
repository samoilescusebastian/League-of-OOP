package angel;

import location.Point;
public final class AngelFactory {
    private static AngelFactory factory = null;
    public static AngelFactory getInstance() {
        if (factory == null) {
            factory = new AngelFactory();
        }
        return factory;
    }
    private AngelFactory() { }
    public Angel createAngel(final String type, final Point location) {
        Angel angel = null;
        switch (type) {
            case  "DamageAngel":
                angel = new DamageAngel(location);
                break;
            case "DarkAngel":
                angel = new DarkAngel(location);
                break;
            case "Dracula":
                angel = new Dracula(location);
                break;
            case "GoodBoy":
                angel = new GoodBoy(location);
                break;
            case "LevelUpAngel":
                angel = new LevelUpAngel(location);
                break;
            case "LifeGiver":
                angel = new LifeGiver(location);
                break;
            case "SmallAngel":
                angel = new SmallAngel(location);
                break;
            case "TheDoomer":
                angel = new TheDoomer(location);
                break;
            case "XPAngel":
                angel = new XPAngel(location);
                break;
            case "Spawner":
                angel = new Spawner(location);
                break;
            default:
                System.out.println("No recognized type of angel!");

        }
        return angel;
    }
}
