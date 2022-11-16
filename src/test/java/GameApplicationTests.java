import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import com.assignment.nl22w.game.impl.validators.GameMapValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class GameApplicationTests {

    Game game = new GameImpl();
    GameMapValidator validator = new GameMapValidator();

    @Test
    @DisplayName("Validate line \"x1XILLEGALX1x\" which contains illegal characters, should be false")
    void testInvalidLineCharacters() {
        assertFalse(validator.isLineValid("x1XILLEGALX1x"));
    }

    @Test
    @DisplayName("Validate line \"111\" which is too short, should be false")
    void testInvalidLineSize() {
        assertFalse(validator.isLineValid("111"));
    }

    @Test
    @DisplayName("Validate line \"111 111X11\", should be true")
    void testValidLine() {
        assertTrue(validator.isLineValid("111 111X11"));
    }

    @Test
    @DisplayName("Test steps count of map1, should be 4")
    void testMap1() throws IOException {
        assertEquals(4, game.escapeFromTheWoods(new ClassPathResource("map1.txt")));
    }

    @Test
    @DisplayName("Test steps count of map2, should be 13")
    void testMap2() throws IOException {
        assertEquals(13, game.escapeFromTheWoods(new ClassPathResource("map2.txt")));
    }

}
