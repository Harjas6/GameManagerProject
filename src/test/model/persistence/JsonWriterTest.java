package model.persistence;


import model.Game;
import model.GameManager;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static model.Game.Genre.ACTADV;
import static model.Game.Genre.RPG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.
    @Test
    void testWriterInvalidFile() {
        try {
            GameManager gm = new GameManager();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterGeneralGameManager() {
        try {
            GameManager wr = new GameManager();
            wr.addGame(new Game("God Of War", 100, 9,
                    1, RPG, 90, false));
            wr.addGame(new Game("Uncharted 4", 1, 3,
                    2, ACTADV, 1, true));
            JsonWriter writer = new JsonWriter("./data/writerUsedGameManager.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/writerUsedGameManager.json");
            wr = reader.read();
            List<Game> game = wr.getGameList();
            assertEquals(2, game.size());
            checkGame(game.get(0),"God Of War", 100, 9,
                    1, RPG, 90, false);
            checkGame(game.get(1),"Uncharted 4", 1, 3,
                    2, ACTADV, 1, true);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyGameManager() {
        try {
            GameManager gm = new GameManager();
            JsonWriter writer = new JsonWriter("./data/writerEmptyGameManager.json");
            writer.open();
            writer.write(gm);
            writer.close();

            JsonReader reader = new JsonReader("./data/writerEmptyGameManager.json");
            gm = reader.read();
            assertEquals(0, gm.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}