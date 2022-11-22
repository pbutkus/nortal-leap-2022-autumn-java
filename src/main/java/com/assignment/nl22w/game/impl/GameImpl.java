package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.enums.Square;
import com.assignment.nl22w.game.impl.logic.ExitFinder;
import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;
import com.assignment.nl22w.game.impl.services.GameMapReader;
import com.assignment.nl22w.game.impl.validators.GameMapValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class GameImpl implements Game {

	@Override
	public int escapeFromTheWoods(Resource resource) throws IOException {
		GameMapReader mapReader = new GameMapReader(resource);
		GameMapValidator validator = new GameMapValidator();

		mapReader.readMap();

		Square[][] squareMap = mapReader.getSquareMap();
		Coordinate start = mapReader.getStart();

		if (!validator.isSquareMapValid(squareMap) || !validator.isStartValid(start)) {
			return 0;
		}

		GameMap gameMap = new GameMap(squareMap, start);

		if (gameMap.isExit(start.y(), start.x())) {
			return 0;
		}

		ExitFinder exitFinder = new ExitFinder(gameMap);

		return exitFinder.findExit();
	}
}
