package model;

import org.junit.jupiter.api.*;

import static model.Game.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game actionGame;
    private Game rpgGame;


    @BeforeEach
    public void runBefore() {
        actionGame = new Game("Uncharted 4", 1, 3,
                2, ACTADV, 1, true);
        rpgGame = new Game("God Of War", 100, 9,
                1, RPG, 90, false);
    }

    @Test
    void testToString() {
        assertEquals("Action/Adventure Game", ACTADV.toString());
        assertEquals("Open-World Game", OPENWORLD.toString());
        assertEquals("Platforming Game", PLATFORMER.toString());
        assertEquals("1st/3rd Person Shooter", SHOOTER.toString());
        assertEquals("Sports Game", SPORT.toString());
        assertEquals("Role-playing Game", RPG.toString());
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
    void testEditName() {
        assertEquals("Uncharted 4", actionGame.getName());
        actionGame.editName("Legend of Zelda");
        assertEquals("Legend of Zelda", actionGame.getName());
    }

    @Test
    void testEditGenre() {
        assertEquals(RPG, rpgGame.getGenre());
        rpgGame.editGenre(SPORT);
        assertEquals(SPORT, rpgGame.getGenre());

    }

    @Test
    void testEditHoursPlayed() {
        assertEquals(1, actionGame.getHoursPlayed());
        actionGame.editHoursPlayed(10.5);
        assertEquals(10.5, actionGame.getHoursPlayed());
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
        assertEquals(1, actionGame.getPrice());
        actionGame.editPrice(10.01);
        assertEquals(10.01, actionGame.getPrice());
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