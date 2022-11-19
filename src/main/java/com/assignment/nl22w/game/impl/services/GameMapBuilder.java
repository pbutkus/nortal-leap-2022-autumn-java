package com.assignment.nl22w.game.impl.services;

import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;

import java.util.List;

public class GameMapBuilder {

    private static final String EMPTY = "0";
    private static final String START_POSITION = "2";
    private static final String EXIT = "3";

    private Coordinate startPosition;
    private boolean exitPresent;

    public GameMapBuilder() {
        this.startPosition = new Coordinate(-1, -1);
        this.exitPresent = false;
    }

    private int[][] convertGameMapTo2dIntArray(List<String> gameMapListOfStrings) {
        int[][] gameMap = new int[gameMapListOfStrings.size()][];

        for (int i = 0; i < gameMapListOfStrings.size(); i++) {
            String line;
            int[] lineAsIntArray;

            if (i == 0 || i == gameMapListOfStrings.size() - 1) {
                line = formatLine(gameMapListOfStrings.get(i), true);
                lineAsIntArray = convertLineToIntArray(line, true, i);
            } else {
                line = formatLine(gameMapListOfStrings.get(i), false);
                lineAsIntArray = convertLineToIntArray(line, false, i);
            }

            gameMap[i] = lineAsIntArray;
        }

        return gameMap;
    }

    private String formatLine(String line, boolean firstOrLast) {
        if (firstOrLast) {
            return line.replace(" ", EXIT)
                    .replace("X", START_POSITION);
        }

        return line.replace(" ", EMPTY)
                .replace("X", START_POSITION);
    }

    private int[] convertLineToIntArray(String line, boolean firstOrLast, int row) {
        String[] splitLine = line.split("");
        int[] convertedLine = new int[splitLine.length];

        for (int i = 0; i < splitLine.length; i++) {
            int converted = Integer.parseInt(splitLine[i]);

            if (!firstOrLast && (i == 0 || i == splitLine.length - 1) && converted == 0) {
                converted = 3;
            }

            if (converted == 2) {
                startPosition = new Coordinate(i, row);
            }

            if (converted == 3) {
                exitPresent = true;
            }

            convertedLine[i] = converted;
        }

        return convertedLine;
    }

    public GameMap build(List<String> map) {
        return new GameMap(convertGameMapTo2dIntArray(map), startPosition, exitPresent);
    }

}
