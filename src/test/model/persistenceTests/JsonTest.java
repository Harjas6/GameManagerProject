package model.persistenceTests;

import model.Game;
import model.Game.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkGame(Game game, String name, double hours, double difficulty, int ranking, Genre genre, double price, boolean owned) {
        assertEquals(name, game.getName());
        assertEquals(difficulty, game.getDifficulty());
        assertEquals(hours, game.getHoursPlayed());
        assertEquals(genre, game.getGenre());
        assertEquals(ranking, game.getRanking());
        assertEquals(price, game.getPrice());
        assertEquals(owned, game.isOwned());



    }
}
