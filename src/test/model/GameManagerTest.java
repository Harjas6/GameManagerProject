package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static model.Game.Genre.*;

public class GameManagerTest {
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

    private GameManager empty;
    private GameManager allGames;
    private GameManager notByName;
    private Game expensive;
    private Game expensive2;


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
                7, SPORT, 40, false);
        sportGame4 = new Game("FFA 23", 48, 0,
                8, SPORT, 40, false);
        expensive = new Game("Rachet and Clank", 1, 1,
                5, PLATFORMER, 100000, false);
        expensive2 = new Game("Rachet and Clank", 1, 1,
                5, PLATFORMER, 10000, false);

        empty = new GameManager();

        allGames = new GameManager();
        allGames.addGame(actionGame);
        allGames.addGame(rpgGame);
        allGames.addGame(openWorldGame);
        allGames.addGame(shootingGame);
        allGames.addGame(platformGame);
        allGames.addGame(sportGame);

        notByName = new GameManager();
        notByName.addGame(rpgGame);
        notByName.addGame(sportGame);
        notByName.addGame(sportGame3);
        notByName.addGame(sportGame2);
        notByName.addGame(sportGame4);
    }

    @Test
    void testGameList() {
        GameManager constructorTester = new GameManager();
        assertEquals(0, empty.getSize());
        assertEquals(0, constructorTester.getSize());
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
    void testAverageUnownedPrice() {
        assertEquals(0, empty.averageUnownedPrice());
        assertEquals(0, empty.getSize());
        assertEquals(47.03, allGames.averageUnownedPrice());
        assertEquals(6, allGames.getSize());

        GameManager allOwned = new GameManager();
        allOwned.addGame(actionGame);
        allOwned.addGame(sportGame);
        allOwned.addGame(shootingGame);
        assertEquals(0, allOwned.averageUnownedPrice());

    }
    @Test
    void testAveragePrice() {
        assertEquals(0, empty.averagePriceAll());
        assertEquals(0, empty.getSize());
        assertEquals(32.01, allGames.averagePriceAll());
        assertEquals(6, allGames.getSize());

        GameManager allOwned = new GameManager();
        allOwned.addGame(actionGame);
        allOwned.addGame(sportGame);
        allOwned.addGame(shootingGame);
        assertEquals(16.99, allOwned.averagePriceAll());

    }
    @Test
    void testSortByOwned() {
        assertEquals(6, allGames.getSize());
        allGames.sortByOwned();
        assertEquals(actionGame, allGames.getGame(0));
        assertEquals(shootingGame, allGames.getGame(1));
        assertEquals(sportGame, allGames.getGame(2));
        assertEquals(rpgGame, allGames.getGame(3));
        assertEquals(openWorldGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(5));

        empty.sortByOwned();
        assertEquals(0, empty.getSize());
    }

    @Test
    void testSortByOwnedReverse() {
        assertEquals(6, allGames.getSize());
        allGames.sortByOwnedReverse();
        assertEquals(actionGame, allGames.getGame(5));
        assertEquals(shootingGame, allGames.getGame(4));
        assertEquals(sportGame, allGames.getGame(3));
        assertEquals(rpgGame, allGames.getGame(2));
        assertEquals(openWorldGame, allGames.getGame(1));
        assertEquals(platformGame, allGames.getGame(0));

        empty.sortByOwned();
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
        assertEquals(sportGame, allGames.getGame(6));
        assertEquals(sportGame4, allGames.getGame(7));
        assertEquals(shootingGame, allGames.getGame(5));
        assertEquals(rpgGame, allGames.getGame(4));
        assertEquals(platformGame, allGames.getGame(3));
        assertEquals(actionGame, allGames.getGame(0));
        assertEquals(actionGame2, allGames.getGame(1));
        assertEquals(openWorldGame, allGames.getGame(2));

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
        assertEquals(sportGame, allGames.getGame(1));
        assertEquals(sportGame4, allGames.getGame(0));
        assertEquals(shootingGame, allGames.getGame(2));
        assertEquals(rpgGame, allGames.getGame(3));
        assertEquals(platformGame, allGames.getGame(4));
        assertEquals(actionGame, allGames.getGame(7));
        assertEquals(actionGame2, allGames.getGame(6));
        assertEquals(openWorldGame, allGames.getGame(5));

        empty.sortByGenreReverse();
        assertEquals(0, empty.getSize());
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
    void testClearList() {
        assertEquals(6, allGames.getSize());
        allGames.clearList();
        assertEquals(0, allGames.getSize());
    }

    @Test
    public void testCanBuy() {
        assertEquals(5, notByName.getSize());
        assertEquals(3, notByName.canBuy(1000).size());
        assertTrue(notByName.canBuy(1000).contains(rpgGame));
        assertEquals(5, notByName.getSize());
        assertEquals(0, empty.getSize());
        assertEquals(0, empty.canBuy(0).size());
        empty.addGame(sportGame4);
        empty.addGame(sportGame3);
        assertEquals(0, empty.canBuy(1).size());
        assertEquals(2, empty.getSize());
        empty.clearList();
        empty.addGame(expensive);
        empty.addGame(expensive2);
        assertEquals(0, empty.canBuy(100).size());
        assertEquals(2, empty.getSize());

    }

    @Test
    void testProduceGames() {
        assertEquals("", empty.produceGames());
        empty.addGame(actionGame2);
        empty.addGame(rpgGame);
        assertEquals("\n\nGame# 1 " + ", Name: Uncharted 3, Price: $1.0, Owned? true\n" +
                "Genre: Action/Adventure Game, Hours Played: 1.0, Difficulty Level: 3.0\n" +
                "Personal Ranking: 2"
                + "\n\nGame# 2 " + ", Name: God Of War, Price: $90.0, Owned? false\n" +
                "Genre: Role-playing Game, Hours Played: 100.0, Difficulty Level: 9.0\n" +
                "Personal Ranking: 1", empty.produceGames());
        empty.removeGame(1);
        assertEquals("\n\nGame# 1 " + ", Name: Uncharted 3, Price: $1.0, Owned? true\n" +
                "Genre: Action/Adventure Game, Hours Played: 1.0, Difficulty Level: 3.0\n" +
                "Personal Ranking: 2", empty.produceGames());

    }
}
