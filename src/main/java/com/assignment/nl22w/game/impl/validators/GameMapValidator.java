package com.assignment.nl22w.game.impl.validators;

import com.assignment.nl22w.game.impl.enums.Square;
import com.assignment.nl22w.game.impl.models.Coordinate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMapValidator {

    public GameMapValidator() {}

    public boolean isLineValid(String line) {
        Pattern pattern = Pattern.compile("[^1X\\s]");
        Matcher matcher = pattern.matcher(line);

        return !matcher.find() && line.length() >= 5 && line.length() <= 11000;
    }

    public boolean isSquareMapValid(Square[][] squareMap) {
        return squareMap.length >= 5 && squareMap[0].length >= 5;
    }

    public boolean isStartValid(Coordinate start) {
        return start.x() >= 0 && start.y() >= 0;
    }

    public boolean isMapSquare(int prevLineLength, int curLineLength) {
        return prevLineLength == curLineLength;
    }

}
