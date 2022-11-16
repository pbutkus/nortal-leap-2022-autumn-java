package com.assignment.nl22w.game.impl.models;

public class GameMap {

    private String[][] gameMap;
    private Coordinate startCoordinate;
    private int potentialExitsCounter;

    public GameMap(String[][] map) {
        this.gameMap = map;
        this.startCoordinate = new Coordinate(0, 0);
        this.potentialExitsCounter = 0;
    }

    public void increaseExitCounter() {
        potentialExitsCounter += 1;
    }

    public boolean isValidLocation(int row, int col) {
        return row > -1 && row < gameMap.length && col > -1 && col < gameMap[row].length;
    }

    public boolean isWall(int row, int col) {
        return gameMap[row][col].equals("1");
    }

    public boolean isExplored(int row, int col) {
        return gameMap[row][col].equals("4");
    }

    public boolean isExit(int row, int col) {
        return gameMap[row][col].equals("3");
    }

    public void setVisited(int row, int col) {
        if (gameMap[row][col].equals("0")) {
            gameMap[row][col] = "4";
        }
    }

    public String[][] getGameMap() {
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

    public void setGameMap(String[][] gameMap) {
        this.gameMap = gameMap;
    }

    public void setStartCoordinates(Coordinate startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

}
