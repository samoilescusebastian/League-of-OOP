package game;

import javafx.util.Pair;
import location.Point;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private String moves;
    private List<Pair<String, Point>> angels;

    public Round() {
        angels = new ArrayList<>();
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public List<Pair<String, Point>> getAngels() {
        return angels;
    }

    public void setAngels(List<Pair<String, Point>> angels) {
        this.angels = angels;
    }
    public void addAngel(Pair<String, Point> angel) {
        angels.add(angel);
    }
}
