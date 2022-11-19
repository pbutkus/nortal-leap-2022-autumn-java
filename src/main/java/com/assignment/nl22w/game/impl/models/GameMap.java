package com.assignment.nl22w.game.impl.models;

public class GameMap {

    private final int[][] gameMap;
    private final Coordinate startCoordinate;
    private final boolean exitPresent;

    public GameMap(int[][] map, Coordinate startCoordinate, boolean exitPresent) {
        this.gameMap = map;
        this.startCoordinate = startCoordinate;
        this.exitPresent = exitPresent;
    }

    public boolean isValidLocation(int row, int col) {
        return row > -1 && row < gameMap.length && col > -1 && col < gameMap[row].length;
    }

    public boolean isWall(int row, int col) {
        return gameMap[row][col] == 1;
    }

    public boolean isExplored(int row, int col) {
        return gameMap[row][col] == 4;
    }

    public boolean isExit(int row, int col) {
        return gameMap[row][col] == 3;
    }

    public void setVisited(int row, int col) {
        gameMap[row][col] = 4;
    }

    public int[][] getGameMap() {
        return gameMap;
    }

    public Coordinate getStartCoordinates() {
        return startCoordinate;
    }

    public int getXAxisSize() {
        return gameMap[0].length;
    }

    public int getYAxisSize() {
        return gameMap.length;
    }

    public boolean isExitPresent() {
        return exitPresent;
    }

}
