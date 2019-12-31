package game;

import java.io.IOException;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers() throws IOException;
}
