package com.assignment.nl22w.game.impl.services;

import com.assignment.nl22w.game.impl.enums.Square;
import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.validators.GameMapValidator;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMapReader {

    private static final GameMapValidator validator = new GameMapValidator();

    private final Resource resource;
    private Square[][] squareMap;
    private Coordinate start;

    public GameMapReader(Resource resource) {
        this.resource = resource;
        this.squareMap = new Square[1][];
        this.start = new Coordinate(-1, -1);
    }

    public void readMap() {
        try (Scanner input = new Scanner(resource.getFile())) {
            List<Square[]> tempSquareList = new ArrayList<>();
            int row = 0;
            int prevLineLength = Integer.MIN_VALUE;

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (prevLineLength == Integer.MIN_VALUE) {
                    prevLineLength = line.length();
                } else if (!validator.isMapRectangular(prevLineLength, line.length())) {
                    return;
                }

                if (validator.isLineValid(line)) {
                    tempSquareList.add(convertLine(line, row));
                } else {
                    return;
                }

                row++;
            }

            squareMap = tempSquareList.toArray(new Square[tempSquareList.size()][]);
        } catch (IOException e) {
            squareMap = new Square[1][];
        }
    }

    public Square[] convertLine(String line, int row) {
        Square[] convertedLine = new Square[line.length()];
        String[] splitLine = line.split("");

        for (int i = 0; i < convertedLine.length; i++) {
            switch (splitLine[i]) {
                case "1" -> convertedLine[i] = Square.TREE;
                case " " -> convertedLine[i] = Square.EMPTY;
                case "X" -> {
                    convertedLine[i] = Square.START;

                    if (start.y() == -1 && start.x() == -1) {
                        start = new Coordinate(i, row);
                    } else {
                        //Make start invalid in case of multiple starting points in map file
                        start = new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE);
                    }
                }
            }
        }

        return convertedLine;
    }

    public Square[][] getSquareMap() {
        return squareMap;
    }

    public Coordinate getStart() {
        return start;
    }

}
