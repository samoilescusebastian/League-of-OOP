package angel;

import character.Character;
import character.CharacterType;
import game.Observable;
import game.Observer;
import location.Point;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Angel implements Observable {
    private List<Observer> observers;
    private AngelType type;
    private Point location;
    protected String state;
    protected String helpType;
    private static fileio.FileSystem fs;
    Angel(final AngelType type, final Point location) {
        this.type = type;
        this.location = location;
        observers = new ArrayList<>();
    }
    /**
     * get angel type.
     */
    public AngelType getType() {
        return type;
    }
    public abstract void visitPlayer(Character player) throws IOException;
    /**
     * get angel location.
     */
    public Point getLocation() {
        return location;
    }
    /**
     * add a new observer.
     */
    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }
    /**
     * remove an observer.
     */
    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }
    /**
     * notify all observers when state of observable object is changed.
     */
    @Override
    public void notifyObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(fs, state);
        }
    }

    public final void setSummonState() throws IOException {
        state = "Angel " + type + " was spawned at " + location.getX() + " " + location.getY();
        notifyObservers();
    }

    public abstract void setHelpState(Character player) throws IOException;
    protected final void setFullHelpState(final Character player) throws IOException {
        state = type + " " + helpType + " " + CharacterType.convertCharToType(player.getType())
                     + " " + player.getId();
        notifyObservers();
    }
    public static void setFileSystem(final fileio.FileSystem fileSystem) {
        fs = fileSystem;
    }
}
