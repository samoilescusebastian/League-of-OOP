package com.Location;

public class Point {
    private int x;
    private int y;
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void add(Point point) {
        this.x += point.getX();
        this.y = point.getY();
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
}
