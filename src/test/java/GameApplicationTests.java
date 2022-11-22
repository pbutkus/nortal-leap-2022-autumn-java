import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import com.assignment.nl22w.game.impl.validators.GameMapValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameApplicationTests {

    Game game = new GameImpl();
    GameMapValidator validator = new GameMapValidator();

    @Test
    @DisplayName("Validate line \"x1XILLEGALX1x\" which contains illegal characters, should be false")
    void testInvalidLineCharacters() {
        assertFalse(validator.isLineValid("x1XILLEGALX1x"));
    }

    @Test
    @DisplayName("Validate line \"111\" which is too short, should return false")
    void testInvalidLineSize() {
        assertFalse(validator.isLineValid("111"));
    }

    @Test
    @DisplayName("Validate line \"111 111X11\", should return true")
    void testValidLine() {
        assertTrue(validator.isLineValid("111 111X11"));
    }

    @Test
    @DisplayName("Test steps count of map1, should return 4")
    void testMap1() throws IOException {
        assertEquals(4, game.escapeFromTheWoods(new ClassPathResource("map1.txt")));
    }

    @Test
    @DisplayName("Test steps count of map2, should return 13")
    void testMap2() throws IOException {
        assertEquals(13, game.escapeFromTheWoods(new ClassPathResource("map2.txt")));
    }

    @Test
    @DisplayName("Test a map which does not contain any exits, should return 0")
    void testMapWithoutExits() throws IOException {
        assertEquals(0, game.escapeFromTheWoods(new ClassPathResource("map_no_exits.txt")));
    }

    @Test
    @DisplayName("Test a map which contains multiple exits, should return 1")
    void testMapWithMultipleExits() throws IOException {
        assertEquals(1, game.escapeFromTheWoods(new ClassPathResource("map_multiple_exits.txt")));
    }

    @Test
    @DisplayName("Test a map which contains starting point as exit, should return 0")
    void testMapWithStartAsExit() throws IOException {
        assertEquals(0, game.escapeFromTheWoods(new ClassPathResource("map_starting_point_as_exit.txt")));
    }

    @Test
    @DisplayName("Test a map which is not square, should return 0")
    void testMapNotSquare() throws IOException {
        assertEquals(0, game.escapeFromTheWoods(new ClassPathResource("map_not_square.txt")));
    }

    @Test
    @DisplayName("Test a map which contains illegal characters, should return 0")
    void testMapIllegalCharacter() throws IOException {
        assertEquals(0, game.escapeFromTheWoods(new ClassPathResource("map_illegal_characters.txt")));
    }

    @Test
    @DisplayName("Test a map which is too small, should return 0")
    void testMapSmall() throws IOException {
        assertEquals(0, game.escapeFromTheWoods(new ClassPathResource("map_small.txt")));
    }

    @Test
    @DisplayName("Test steps count of 100 by 100 map, should return 195")
    void testMap100by100() throws IOException {
        assertEquals(195, game.escapeFromTheWoods(new ClassPathResource("map_100x100.txt")));
    }

    @Test
    @DisplayName("Test steps count of 1000 by 1000 map, should return 1995")
    void testMap1000by1000() throws IOException {
        assertEquals(1995, game.escapeFromTheWoods(new ClassPathResource("map_1000x1000.txt")));
    }

    @Test
    @DisplayName("Test steps count of 5000 by 5000 map, should return 9995")
    void testMap5000by5000() throws IOException {
        assertEquals(9995, game.escapeFromTheWoods(new ClassPathResource("map_5000x5000.txt")));
    }

}
