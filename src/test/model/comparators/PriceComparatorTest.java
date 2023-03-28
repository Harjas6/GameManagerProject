package model.comparators;

import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Game.Genre.*;
import static model.Game.Genre.SPORT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceComparatorTest {
    private Game actionGame;
    private Game rpgGame;
    private Game openWorldGame;
    private Game shootingGame;
    private Game platformGame;
    private Game sportGame;
    private PriceComparator comp;

    @BeforeEach
    public void runBefore() {
        actionGame = new Game("Uncharted 4", 1, 3,
                2, ACTADV, 90, true);
        rpgGame = new Game("God Of War", 100, 9,
                1, RPG, 90, false);
        openWorldGame = new Game("Elden Ring", 95, 10,
                3, OPENWORLD, 40.9, false);
        shootingGame = new Game("Call Of Duty", 250, 3,
                4, SHOOTER, 50, true);
        platformGame = new Game("Rachet and Clank", 10, 1,
                5, PLATFORMER, 15, false);
        sportGame = new Game("FIFA 22", 48, 0,
                6, SPORT, 40, true);
        comp = new PriceComparator();
    }

    @Test
    void compareTest() {
        assertEquals(0, comp.compare(actionGame,rpgGame));
        assertEquals(-1, comp.compare(openWorldGame,shootingGame));
        assertEquals(1, comp.compare(sportGame,platformGame));
    }

}
