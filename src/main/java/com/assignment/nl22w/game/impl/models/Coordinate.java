package com.assignment.nl22w.game.impl.models;

public record Coordinate(int x, int y) {

    @Override
    public String toString() {
        return "X: " + x + "; Y:" + y;
    }

}
