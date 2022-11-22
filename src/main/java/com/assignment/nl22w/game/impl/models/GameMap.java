package com.assignment.nl22w.game.impl.models;

import com.assignment.nl22w.game.impl.enums.Square;

public class GameMap {

    private final Square[][] gameMap;
    private final Coordinate startCoordinate;

    public GameMap(Square[][] map, Coordinate startCoordinate) {
        this.gameMap = map;
        this.startCoordinate = startCoordinate;
    }

    public boolean isValidLocation(int row, int col) {
        return row > -1 && row < gameMap.length && col > -1 && col < gameMap[row].length;
    }

    public boolean isTree(int row, int col) {
        return gameMap[row][col] == Square.TREE;
    }

    public boolean isVisited(int row, int col) {
        return gameMap[row][col] == Square.VISITED;
    }

    public boolean isExit(int row, int col) {
        //TODO fix
        if (isTree(row, col)) {
            return false;
        }

        if ((row == 0 || row == gameMap.length -1) || (col == 0 || col == gameMap[row].length)) {
            return true;
        }

        return false;
    }

    public void setVisited(int row, int col) {
        gameMap[row][col] = Square.VISITED;
    }

    public Coordinate getStartCoordinates() {
        return startCoordinate;
    }

}
