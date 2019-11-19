package com.Location;

import java.util.List;
import com.character.Character;
public final class Map {
    private Cell[][] map;
    private int rows;
    private int columns;
    public Map(final int n, final int m) {
        rows = n;
        columns = m;
        map = new Cell[rows][columns];
    }
    public void setCell(final Cell typeCell, final int rowIndex, final int columnIndex) {
        map[rowIndex][columnIndex] = typeCell;
    }
    public int  getRowsNumber() {
        return rows;
    }
    public int getColumnsNumber() {
        return columns;
    }
    public Cell getCell(final int rowIndex, final int columnIndex) {
        return map[rowIndex][columnIndex];
    }
    public void setPlayers(final List<Character> players) {
        for (int i = 0; i < players.size(); i++) {
            Point location = players.get(i).getLocation();
            map[location.getX()][location.getY()].addCharacter(players.get(i).getId());
        }
    }
    public void addPlayer(final Character player) {
        Point location = player.getLocation();
        map[location.getX()][location.getY()].addCharacter(player.getId());
    }
    public void deletePlayer(final Character player) {
        Point location = player.getLocation();
        map[location.getX()][location.getY()].deleteCharacter(player.getId());
    }

}
