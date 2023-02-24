package model;

import org.junit.jupiter.api.*;

import static model.Game.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game actionGame;
    private Game rpgGame;
    private Game openWorldGame;
    private Game shootingGame;
    private Game platformGame;
    private Game sportGame;


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
        platformGame = new Game("Rachet and Clank", 10, 1,
                5, PLATFORMER, 15, false);
        sportGame = new Game("FIFA 22", 48, 0,
                6, SPORT, 40, true);
    }

    @Test
    public void testChangeHoursPlayed() {
        assertTrue(actionGame.changeHoursPlayed(1));
        assertEquals(2, actionGame.getHoursPlayed());
        assertTrue(actionGame.changeHoursPlayed(0.5));
        assertEquals(2.5, actionGame.getHoursPlayed());
        assertTrue(actionGame.changeHoursPlayed(-2));
        assertEquals(0.5, actionGame.getHoursPlayed());
        assertTrue(actionGame.changeHoursPlayed(-0.5));
        assertEquals(0, actionGame.getHoursPlayed());
        assertFalse(actionGame.changeHoursPlayed(-0.1));
        assertEquals(0, actionGame.getHoursPlayed());
    }

    @Test
    public void testChangePrice() {
        assertTrue(actionGame.changePrice(1));
        assertEquals(2, actionGame.getPrice());
        assertTrue(actionGame.changePrice(0.5));
        assertEquals(2.5, actionGame.getPrice());
        assertTrue(actionGame.changePrice(-2));
        assertEquals(0.5, actionGame.getPrice());
        assertTrue(actionGame.changePrice(-0.5));
        assertEquals(0, actionGame.getPrice());
        assertFalse(actionGame.changePrice(-0.1));
        assertEquals(0, actionGame.getPrice());

    }

    @Test
    void testEditRanking() {
        assertEquals(2, actionGame.getRanking());
        actionGame.editRanking(3);
        assertEquals(3, actionGame.getRanking());
    }
    @Test
    void testEditDifficulty() {
        assertEquals(3, actionGame.getDifficulty());
        actionGame.editDifficulty(5);
        assertEquals(5, actionGame.getDifficulty());
    }

    @Test
    void testEditPrice() {
        assertEquals(1,actionGame.getPrice());
        actionGame.editPrice(10.01);
        assertEquals(10.01,actionGame.getPrice());
    }

    @Test
    void testChangeOwned() {
        assertTrue(actionGame.isOwned());
        actionGame.changeOwned();
        assertFalse(actionGame.isOwned());
        actionGame.changeOwned();
        assertTrue(actionGame.isOwned());
    }


}