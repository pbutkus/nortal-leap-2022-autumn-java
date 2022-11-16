package com.assignment.nl22w.game.impl.models;

public class Coordinate {
    private final int x;
    private final int y;
    private final Coordinate parent;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public Coordinate(int x, int y, Coordinate parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "X: " + x + "; Y:" + y;
    }

}
