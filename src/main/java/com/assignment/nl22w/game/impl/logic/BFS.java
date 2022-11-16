package com.assignment.nl22w.game.impl.logic;

import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Coordinate> solve(GameMap gameMap) {
        LinkedList<Coordinate> nextToVisit = new LinkedList<>();
        Coordinate start = gameMap.getStartCoordinates();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            Coordinate cur = nextToVisit.remove();

            if (!gameMap.isValidLocation(cur.getX(), cur.getY()) || gameMap.isExplored(cur.getX(), cur.getY())) {
                continue;
            }

            if (gameMap.isWall(cur.getX(), cur.getY())) {
                gameMap.setVisited(cur.getX(), cur.getY());
                continue;
            }

            if (gameMap.isExit(cur.getX(), cur.getY())) {
                return backtrackPath(cur);
            }

            for (int[] direction : DIRECTIONS) {
                Coordinate coordinate = new Coordinate(cur.getX() + direction[0], cur.getY() + direction[1], cur);
                nextToVisit.add(coordinate);
                gameMap.setVisited(cur.getX(), cur.getY());
            }
        }
        return Collections.emptyList();
    }

    private List<Coordinate> backtrackPath(Coordinate cur) {
        List<Coordinate> path = new ArrayList<>();
        Coordinate iter = cur;

        while (iter != null) {
            path.add(iter);
            iter = iter.getParent();
        }

        return path;
    }
}
