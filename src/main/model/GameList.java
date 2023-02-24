package model;


import model.comparators.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameList {

    private List<Game> gameList;
    private double budget;

    public GameList(double budget) {
        this.gameList = new ArrayList<Game>();
        this.budget = budget;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public List<Game> canBuy() {
        double spendingMoney = this.budget;
        List<Game> underBudget = new ArrayList<Game>();
        for (Game game : gameList) {
            if (!game.isOwned() && (spendingMoney >= game.getPrice())) {
                underBudget.add(game);
            }
        }
        return underBudget;
    }


    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Produces average hours in gamelist to two decimal places
    public double averageHours() {
        double total = 0;
        for (Game game : gameList) {
            total += game.getHoursPlayed();
        }
        total = (total / gameList.size());
        total = (int) (total * 100);
        return total / 100;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Produces average difficulty in gamelist to two decimal places
    public double averageDifficulty() {
        double total = 0;
        for (Game game : gameList) {
            total += game.getDifficulty();
        }
        double size = gameList.size();
        total = total / size;
        total = (int) (total * 100);
        return total / 100;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Produces average price in gamelist to two decimal places
    public double averagePrice() {
        double total = 0;
        for (Game game : gameList) {
            total += game.getPrice();
        }
        total = (total / gameList.size());
        total = (int) (total * 100);
        return total / 100;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByPrice() {
        gameList.sort(new PriceComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByPriceReverse() {
        sortByPrice();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByGenre() {
        gameList.sort(new GenreComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByGenreReverse() {
        sortByGenre();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByName() {
        gameList.sort(new NameComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByNameReverse() {
        sortByName();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByHoursPlayed() {
        gameList.sort(new HoursComparator());
    }

    public void sortByHoursPlayedReverse() {
        sortByHoursPlayed();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByRanking() {
        gameList.sort(new RankingComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByRankingReverse() {
        sortByRanking();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByDifficulty() {
        gameList.sort(new DifficultyComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByDifficultyReverse() {
        sortByDifficulty();
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByPlayed() {
        gameList.sort(new OwnedComparator());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void sortByOwnedReverse() {
        gameList.sort(new OwnedComparator());
        Collections.reverse(gameList);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void removeGame(int i) {
        gameList.remove(i);
    }

    public Game getGame(int i) {
        return gameList.get(i);
    }

    public int getSize() {
        return gameList.size();
    }

    public void addGame(Game game) {
        gameList.add(game);
    }

    public boolean containGame(Game game) {
        return gameList.contains(game);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public String produceGames() {
        String games = " ";
        for (Game game: gameList) {
            games += "Name: " + game.getName() + " Price: " + game.getPrice() +  " Owned? " + game.isOwned()
                    + "\n" +  "Genre: " + game.getGenre() + " Hours Played: " + game.getHoursPlayed()
                    + "Difficulty Level: " + game.getDifficulty() +  "\n" +  "Personal Ranking: " + game.getRanking()
                    + "\n\n";
        }
        return games;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public double getBudget() {
        return budget;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void changeBudget(double budget) {
        this.budget = budget;

    }
}
