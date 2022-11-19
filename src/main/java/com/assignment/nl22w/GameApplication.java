package com.assignment.nl22w;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class GameApplication implements CommandLineRunner {

	Game game = new GameImpl();

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		game.escapeFromTheWoods(new ClassPathResource("map_100x100.txt"));
	}
}
