package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static model.Game.Genre.*;

public class GameListTest {
    private Game actionGame;
    private Game actionGame2;
    private Game rpgGame;
    private Game openWorldGame;
    private Game shootingGame;
    private Game platformGame;
    private Game sportGame;
    private Game sportGame2;
    private Game sportGame3;
    private Game sportGame4;

    private GameList empty;
    private GameList allGames;
    private GameList notByName;


    @BeforeEach
    public void runBefore() {
        actionGame = new Game("Uncharted 4", 1, 3,
                2, ACTADV, 1, true);
        actionGame2 = new Game("Uncharted 3", 1, 3,
                2, ACTADV, 1, true);

        rpgGame = new Game("God Of War", 100, 9,
                1, RPG, 90, false);

        openWorldGame = new Game("Elden Ring", 95, 10,
                3, OPENWORLD, 50.1, false);

        shootingGame = new Game("Call Of Duty", 250, 3,
                4, SHOOTER, 0, true);

        platformGame = new Game("Rachet and Clank", 1, 1,
                5, PLATFORMER, 1.01, false);

        sportGame = new Game("FIFA 22", 0, 2,
                6, SPORT, 49.99, true);
        sportGame2 = new Game("FIFA 21", 48, 1,
                6, SPORT, 40, true);
        sportGame3 = new Game("FIFA 23", 48, 0,
                7, SPORT, 40, true);
        sportGame4 = new Game("FFA 23", 48, 0,
                8, SPORT, 40, true);

        empty = new GameList(0);

        allGames = new GameList(100);
        allGames.addGame(actionGame);
        allGames.addGame(rpgGame);
        allGames.addGame(openWorldGame);
        allGames.addGame(shootingGame);
        allGames.addGame(platformGame);
        allGames.addGame(sportGame);

        notByName = new GameList(1000);
        notByName.addGame(rpgGame);
        notByName.addGame(sportGame);
        notByName.addGame(sportGame3);
        notByName.addGame(sportGame2);
        notByName.addGame(sportGame4);
    }

    @Test
    void testGameList() {
        GameList constructorTester = new GameList(100);
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.getBudget());
        assertEquals(0, constructorTester.getSize());
        assertEquals(100, constructorTester.getBudget());
    }

    @Test
    void testAddGame() {
        empty.addGame(actionGame);
        assertEquals(actionGame, empty.getGame(0));
        assertEquals(1, empty.getSize());
    }

    @Test
    void testRemoveGame() {
        assertTrue(allGames.containGame(actionGame));
        assertEquals(6, allGames.getSize());
        allGames.removeGame(0);
        assertFalse(allGames.containGame(actionGame));
        assertEquals(5, allGames.getSize());
    }

    @Test
    void testAverageDifficulty(){
        assertEquals(6, allGames.getSize());
        assertEquals(4.66 , allGames.averageDifficulty());
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.averageDifficulty());


    }

    @Test
    void testAverageHours(){
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.averageHours());
        assertEquals(6, allGames.getSize());
        assertEquals(74.5, allGames.averageHours());


    }

    @Test
    void testAveragePrice() {
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.averagePrice());
        assertEquals(6, allGames.getSize());
        assertEquals(32.01, allGames.averagePrice());

    }
    @Test
    void testSortByPlayed() {
        assertEquals(6, allGames.getSize());
        allGames.sortByPlayed();
        assertEquals(actionGame, allGames.getGame(0));
        assertEquals(shootingGame, allGames.getGame(1));
        assertEquals(sportGame, allGames.getGame(2));
        assertEquals(rpgGame, allGames.getGame(3));
        assertEquals(openWorldGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(5));

        empty.sortByPlayed();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByPlayedReverse() {
        assertEquals(6, allGames.getSize());
        allGames.sortByOwnedReverse();
        assertEquals(actionGame, allGames.getGame(5));
        assertEquals(shootingGame, allGames.getGame(4));
        assertEquals(sportGame, allGames.getGame(3));
        assertEquals(rpgGame, allGames.getGame(2));
        assertEquals(openWorldGame, allGames.getGame(1));
        assertEquals(platformGame, allGames.getGame(0));

        empty.sortByPlayed();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByPrice() {
        assertEquals(6, allGames.getSize());
        allGames.sortByPrice();
        assertEquals(shootingGame, allGames.getGame(0));
        assertEquals(actionGame, allGames.getGame(1));
        assertEquals(platformGame, allGames.getGame(2));
        assertEquals(sportGame, allGames.getGame(3));
        assertEquals(openWorldGame, allGames.getGame(4));
        assertEquals(rpgGame, allGames.getGame(5));

        empty.sortByPrice();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByPriceReverse() {
        assertEquals(6, allGames.getSize());
        allGames.sortByPriceReverse();
        assertEquals(shootingGame, allGames.getGame(5));
        assertEquals(actionGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(3));
        assertEquals(sportGame, allGames.getGame(2));
        assertEquals(openWorldGame, allGames.getGame(1));
        assertEquals(rpgGame, allGames.getGame(0));

        empty.sortByPrice();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByGenre() {
        allGames.addGame(sportGame4);
        allGames.addGame(actionGame2);
        assertEquals(8, allGames.getSize());
        assertEquals(actionGame, allGames.getGame(0));
        allGames.sortByGenre();
        assertEquals(sportGame, allGames.getGame(0));
        assertEquals(sportGame4, allGames.getGame(1));
        assertEquals(shootingGame, allGames.getGame(2));
        assertEquals(rpgGame, allGames.getGame(3));
        assertEquals(platformGame, allGames.getGame(4));
        assertEquals(actionGame, allGames.getGame(5));
        assertEquals(actionGame2, allGames.getGame(6));
        assertEquals(openWorldGame, allGames.getGame(7));

        empty.sortByGenre();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByGenreReverse() {
        allGames.addGame(sportGame4);
        allGames.addGame(actionGame2);
        assertEquals(8, allGames.getSize());
        assertEquals(actionGame, allGames.getGame(0));
        allGames.sortByGenreReverse();
        assertEquals(sportGame, allGames.getGame(7));
        assertEquals(sportGame4, allGames.getGame(6));
        assertEquals(shootingGame, allGames.getGame(5));
        assertEquals(rpgGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(3));
        assertEquals(actionGame, allGames.getGame(2));
        assertEquals(actionGame2, allGames.getGame(1));
        assertEquals(openWorldGame, allGames.getGame(0));
    }

    @Test
    void testSortByName() {
        assertEquals(5, notByName.getSize());
        assertEquals(rpgGame, notByName.getGame(0));
        notByName.sortByName();
        assertEquals(5, notByName.getSize());
        assertEquals(sportGame4, notByName.getGame(0));
        assertEquals(sportGame2, notByName.getGame(1));
        assertEquals(sportGame, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(3));
        assertEquals(rpgGame, notByName.getGame(4));

        empty.sortByName();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByNameReverse() {
        assertEquals(5, notByName.getSize());
        assertEquals(rpgGame, notByName.getGame(0));
        notByName.sortByNameReverse();
        assertEquals(5, notByName.getSize());
        assertEquals(sportGame4, notByName.getGame(4));
        assertEquals(sportGame2, notByName.getGame(3));
        assertEquals(sportGame, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(1));
        assertEquals(rpgGame, notByName.getGame(0));

        empty.sortByNameReverse();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByHoursPlayed() {
        assertEquals(6, allGames.getSize());
        assertEquals(actionGame, allGames.getGame(0));
        allGames.sortByHoursPlayed();
        assertEquals(sportGame, allGames.getGame(0));
        assertEquals(actionGame, allGames.getGame(1));
        assertEquals(platformGame, allGames.getGame(2));
        assertEquals(openWorldGame, allGames.getGame(3));
        assertEquals(rpgGame, allGames.getGame(4));
        assertEquals(shootingGame, allGames.getGame(5));
        assertEquals(6, allGames.getSize());

        empty.sortByHoursPlayed();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByHoursPlayedReverse() {
        assertEquals(6, allGames.getSize());
        assertEquals(actionGame, allGames.getGame(0));
        allGames.sortByHoursPlayedReverse();
        assertEquals(sportGame, allGames.getGame(5));
        assertEquals(actionGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(3));
        assertEquals(openWorldGame, allGames.getGame(2));
        assertEquals(rpgGame, allGames.getGame(1));
        assertEquals(shootingGame, allGames.getGame(0));
        assertEquals(6, allGames.getSize());
    }

    @Test
    void testSortByRanking() {
        assertEquals(5, notByName.getSize());
        notByName.sortByRanking();
        assertEquals(rpgGame, notByName.getGame(0));
        assertEquals(sportGame, notByName.getGame(1));
        assertEquals(sportGame2, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(3));
        assertEquals(sportGame4, notByName.getGame(4));
        assertEquals(5, notByName.getSize());


    }

    @Test
    void testSortByRankingReverse() {
        assertEquals(5, notByName.getSize());
        notByName.sortByRankingReverse();
        assertEquals(rpgGame, notByName.getGame(4));
        assertEquals(sportGame, notByName.getGame(3));
        assertEquals(sportGame2, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(1));
        assertEquals(sportGame4, notByName.getGame(0));
        assertEquals(5, notByName.getSize());

    }

    @Test
    void testSortByDifficulty() {
        assertEquals(5, notByName.getSize());
        notByName.sortByDifficulty();
        assertEquals(rpgGame, notByName.getGame(0));
        assertEquals(sportGame, notByName.getGame(1));
        assertEquals(sportGame2, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(3));
        assertEquals(sportGame4, notByName.getGame(4));
        assertEquals(5, notByName.getSize());

    }

    @Test
    void testSortByDifficultyReverse() {
        assertEquals(5, notByName.getSize());
        notByName.sortByDifficultyReverse();
        assertEquals(rpgGame, notByName.getGame(4));
        assertEquals(sportGame, notByName.getGame(3));
        assertEquals(sportGame2, notByName.getGame(2));
        assertEquals(sportGame3, notByName.getGame(1));
        assertEquals(sportGame4, notByName.getGame(0));
        assertEquals(5, notByName.getSize());

    }

    @Test
    public void testCanBuy() {
        assertEquals(5, notByName.getSize());
        assertEquals(1, notByName.canBuy().size());
        assertTrue(notByName.canBuy().contains(rpgGame));
        assertEquals(5, notByName.getSize());
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.canBuy().size());
    }

    @Test
    void testChangeBudget() {
        assertEquals(1000, notByName.getBudget());
        notByName.changeBudget(10.5);
        assertEquals(10.5, notByName.getBudget());
    }

    @Test
    void testProduceGames() {

    }
}
