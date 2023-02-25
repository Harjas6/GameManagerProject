package model.comparatorTests;

import model.Game;
import model.comparators.GenreComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Game.Genre.*;
import static model.Game.Genre.SPORT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreComparatorTest {

    private Game actionGame;
    private Game rpgGame;
    private Game openWorldGame;
    private Game shootingGame;
    private Game sportGame1;
    private Game sportGame2;
    private GenreComparator comp;

    @BeforeEach
    public void runBefore() {
        actionGame = new Game("Uncharted 4", 1, 3,
                2, ACTADV, 1, true);
        rpgGame = new Game("God Of War", 100, 9,
                1, RPG, 90, false);
        openWorldGame = new Game("Elden Ring", 95, 10,
                3, OPENWORLD, 50, false);
        shootingGame = new Game("Call Of Duty", 250, 3,
                4, SHOOTER, 0, true);
        sportGame1 = new Game("NHL 22", 10, 1,
                5, SPORT, 15, false);
        sportGame2 = new Game("FIFA 22", 48, 0,
                6, SPORT, 40, true);
        comp = new GenreComparator();
    }

    @Test
    void compareTest() {
        assertEquals(-3, comp.compare(actionGame,rpgGame));
        assertEquals(3, comp.compare(shootingGame,openWorldGame));
        assertEquals(0, comp.compare(sportGame2, sportGame1));
    }
}

