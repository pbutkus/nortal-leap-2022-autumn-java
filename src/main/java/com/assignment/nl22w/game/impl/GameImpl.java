package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.logic.ExitFinder;
import com.assignment.nl22w.game.impl.models.GameMap;
import com.assignment.nl22w.game.impl.services.GameMapBuilder;
import com.assignment.nl22w.game.impl.services.GameMapReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class GameImpl implements Game {

	@Override
	public int escapeFromTheWoods(Resource resource) throws IOException {
		//		TODO start your journey here
		GameMapReader fileReader = new GameMapReader(resource);
		GameMapBuilder gameMapBuilder = new GameMapBuilder();

		List<String> gameMapAsListOfStrings = fileReader.readMap();

		if (gameMapAsListOfStrings.isEmpty()) {
			return 0;
		}

		GameMap gameMap = gameMapBuilder.build(gameMapAsListOfStrings);

		if (!gameMap.isExitPresent()) {
			return 0;
		}

		ExitFinder exitFinder = new ExitFinder(gameMap);

		return exitFinder.findExit();
	}
}
