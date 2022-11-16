package com.assignment.nl22w.game.impl.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameMapValidator {

    private boolean isRowSizeValid(int size) {
        return size >= 5 && size <= 11000;
    }

    public boolean isLineValid(String line) {
        Pattern pattern = Pattern.compile("[^1X\\s]");
        Matcher matcher = pattern.matcher(line);

        return !matcher.find() && line.length() >= 5 && line.length() <= 11000;
    }

}
