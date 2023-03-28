package model.persistence;



import model.Game;
import model.Game.Genre;
import model.GameManager;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/garbageFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyGameManager() {
        JsonReader reader = new JsonReader("./data/emptyTest.json");
        try {
            GameManager gm = reader.read();
            assertEquals(0, gm.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGameManager() {
        JsonReader reader = new JsonReader("./data/multipleTest.json");
        try {
            GameManager gm = reader.read();
            List<Game> game = gm.getGameList();
            assertEquals(3, game.size());
            checkGame(game.get(0), "Harj", 345, 1, 1, Genre.PLATFORMER, 2, true);
            checkGame(game.get(1), "NOD", 456, 23, 87, Genre.ACTADV, 12, false);
            checkGame(game.get(2), "GOD", 23, 5435, 23, Genre.SPORT, 334, true);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}