package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.logic.BFS;
import com.assignment.nl22w.game.impl.models.Coordinate;
import com.assignment.nl22w.game.impl.models.GameMap;
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
		GameMap gameMap = fileReader.readMap();
		BFS solver = new BFS();

		List<Coordinate> path = solver.solve(gameMap);

		return path.size() - 1;
	}
}
