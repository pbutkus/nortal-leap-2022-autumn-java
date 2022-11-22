package com.assignment.nl22w.game.impl.logic;

import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;

import java.util.ArrayList;
import java.util.List;

public class ExitFinder {

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private final GameMap map;
    private int steps;
    private boolean exitFound;

    public ExitFinder(GameMap map) {
        this.map = map;
        this.steps = 0;
        this.exitFound = false;
    }

    public int findExit() {
        Coordinate start = map.getStartCoordinates();
        map.setVisited(start.y(), start.x());

        List<Coordinate> openSquares = getChildren(start);

        while (!openSquares.isEmpty()) {
            List<Coordinate> squares = new ArrayList<>();

            if (exitFound) {
                steps++;
                return steps;
            }

            steps++;

            for (Coordinate openSquare : openSquares) {
                List<Coordinate> children = getChildren(openSquare);

                squares.addAll(children);
            }

            openSquares = squares;

        }

        return 0;
    }

    private Coordinate getChildCoordinate(int row, int col, int i, int j) {
        return new Coordinate(col + j, row + i);
    }

    private List<Coordinate> getChildren(Coordinate node) {
        List<Coordinate> childrenList = new ArrayList<>();

        for (int[] direction : DIRECTIONS) {
            Coordinate child = getChildCoordinate(node.y(), node.x(), direction[1], direction[0]);

            if (map.isExit(child.y(), child.x())) {
                exitFound = true;
            }

            if (map.isValidLocation(child.y(), child.x())
                    && !map.isTree(child.y(), child.x())) {
                if (!map.isVisited(child.y(), child.x())) {
                    map.setVisited(child.y(), child.x());
                    childrenList.add(child);
                }
            }
        }

        return childrenList;
    }

}
