package com.assignment.nl22w.game.impl.services;

import com.assignment.nl22w.game.impl.validators.GameMapValidator;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameMapReader {

    private static final GameMapValidator validator = new GameMapValidator();

    private final Resource resource;

    public GameMapReader(Resource resource) {
        this.resource = resource;
    }

    public List<String> readMap() {
        try (Scanner input = new Scanner(resource.getFile())) {
            List<String> lines = new ArrayList<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (validator.isLineValid(line)) {
                    lines.add(line);
                } else {
                    return Collections.emptyList();
                }
            }
            return lines;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

}
