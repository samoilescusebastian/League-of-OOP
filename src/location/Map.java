package location;

import java.util.List;
import character.Character;
public final class Map {
    private static Map mapInstance = null;
    private Cell[][] map;
    private static int rows;
    private static int columns;
    private Map() {
        map = new Cell[rows][columns];
    }
    public static Map getInstance(final int n, final int m) {
        if (mapInstance == null) {
            rows = n;
            columns = m;
            mapInstance = new Map();
        }
        return mapInstance;
    }
    public void setCell(final Cell typeCell, final int rowIndex, final int columnIndex) {
        map[rowIndex][columnIndex] = typeCell;
    }
    public Cell getCell(final int rowIndex, final int columnIndex) {
        if (rowIndex >= 0 && columnIndex >= 0) {
            return map[rowIndex][columnIndex];
        }
        return null;
    }
    public void setPlayers(final List<Character> players) {
        for (int i = 0; i < players.size(); i++) {
            Point location = players.get(i).getLocation();
            map[location.getX()][location.getY()].addCharacter(players.get(i).getId());
        }
    }
    public void addPlayer(final Character player) {
        Point location = player.getLocation();
        if (location.getX() >= 0 && location.getY() >= 0) {
            map[location.getX()][location.getY()].addCharacter(player.getId());
        }
    }
    public void deletePlayer(final Character player) {
        Point location = player.getLocation();
        if (location.getX() >= 0 && location.getY() >= 0) {
            map[location.getX()][location.getY()].deleteCharacter(player.getId());
        }
    }

}
