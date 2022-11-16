package com.assignment.nl22w.game.impl.services;

import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMapReader {

    private static final String EMPTY = "0";
    private static final String START_POSITION = "2";
    private static final String EXIT = "3";

    private final Resource resource;

    public GameMapReader(Resource resource) {
        this.resource = resource;
    }

    public GameMap readMap() {
        try (Scanner input = new Scanner(resource.getFile())) {
            List<String[]> lines = new ArrayList<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = formatLine(line);
                String[] split = line.split("");
                lines.add(split);
            }

            String[][] map = new String[lines.size()][];

            for (int i = 0; i < map.length; i++) map[i] = lines.get(i);

            GameMap gameMap = new GameMap(map);

            return formatMap(gameMap);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    private String formatLine(String line) {
        return line.replace(" ", EMPTY)
                .replace("X", START_POSITION);
    }

    private GameMap formatMap(GameMap gameMap) {
        String[][] map = gameMap.getGameMap();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1) {
                    if (map[i][j].equals(EMPTY)) {
                        map[i][j] = EXIT;
                        gameMap.increaseExitCounter();
                    }
                }

                if (j == 0 || j == map[i].length - 1) {
                    if (map[i][j].equals(EMPTY)) {
                        map[i][j] = EXIT;
                        gameMap.increaseExitCounter();
                    }
                }

                if (map[i][j].equals(START_POSITION)) {
                    gameMap.setStartCoordinates(new Coordinate(i, j));
                }
            }
        }

        gameMap.setGameMap(map);

        return gameMap;
    }

}
