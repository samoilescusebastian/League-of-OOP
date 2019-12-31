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
    List<Observer> observers;
    private AngelType type;
    private Point location;
    protected String state;
    protected String helpType;
    private static fileio.FileSystem fs;
    Angel(AngelType type, Point location) {
        this.type = type;
        this.location = location;
        observers = new ArrayList<>();
    }
    public abstract void visitPlayer(Character player) throws IOException;
    public Point getLocation() {
        return location;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(fs, state);
        }
    }
    public void setSummonState() throws IOException {
        state = "Angel " + type + " was spawned at " + location.getX() + " " + location.getY();
        notifyObservers();
    }
    public abstract void setHelpState(Character player) throws IOException;
    protected void setFullHelpState(Character player) throws IOException {
        state = type + " " + helpType + " " + CharacterType.convertCharToType(player.getType()) + " " + player.getId();
        notifyObservers();
    }
    public static void setFileSystem(final fileio.FileSystem fileSystem) {
        fs = fileSystem;
    }
}