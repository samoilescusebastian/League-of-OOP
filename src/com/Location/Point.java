package com.Location;

public final class Point {
    private int x;
    private int y;
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    public Point(final Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void add(final Point point) {
        this.x += point.getX();
        this.y += point.getY();
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
}
