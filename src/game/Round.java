package game;

import angel.Angel;

import java.util.ArrayList;
import java.util.List;

public final class Round {
    private String moves;
    private List<Angel> angels;

    public Round() {
        angels = new ArrayList<>();
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(final String moves) {
        this.moves = moves;
    }

    public List<Angel> getAngels() {
        return angels;
    }

    public void addAngel(final Angel angel) {
        angels.add(angel);
    }
}
