package model;


import model.comparators.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// gameList is a List of the games a user can input alongside a budget that is >= 0.
// Based off the individual facets of inputted games
// user can sort, get averages from the list, and see what games are purchasable according to the budget

public class GameList {

    private List<Game> gameList;
    private double budget;

    public GameList(double budget) {
        this.gameList = new ArrayList<>();
        this.budget = budget;
    }


    // EFFECTS: Produces a list of games that can be bought according to budget
    public List<Game> canBuy() {
        double spendingMoney = this.budget;
        List<Game> underBudget = new ArrayList<>();
        for (Game game : gameList) {
            if (!game.isOwned() && (spendingMoney >= game.getPrice())) {
                underBudget.add(game);
            }
        }
        return underBudget;
    }

    // EFFECTS: Produces average hours in gameList to two decimal places
    public double averageHours() {
        double total = 0;
        for (Game game : gameList) {
            total += game.getHoursPlayed();
        }
        total = (total / gameList.size());
        total = (int) (total * 100);
        return total / 100;
    }

    // EFFECTS: Produces average difficulty in gameList to two decimal places
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

    // EFFECTS: Produces average price in gameList to two decimal places
    public double averagePrice() {
        double total = 0;
        for (Game game : gameList) {
            total += game.getPrice();
        }
        total = (total / gameList.size());
        total = (int) (total * 100);
        return total / 100;
    }

    // EFFECTS: Sorts list with the cheapest game at the first index
    public void sortByPrice() {
        gameList.sort(new PriceComparator());
    }


    // EFFECTS: Sorts list with the cheapest game at the last index
    public void sortByPriceReverse() {
        sortByPrice();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList according to the order
    // the genre enumeration was decalred with the first one declared at the top
    public void sortByGenre() {
        gameList.sort(new GenreComparator());
    }

    // EFFECTS: Sorts gameList in reverse order of the genre declaration in enumeration
    public void sortByGenreReverse() {
        sortByGenre();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList in lexicographical order
    public void sortByName() {
        gameList.sort(new NameComparator());
    }

    // EFFECTS: Sorts gameList in reverse lexicographical order
    public void sortByNameReverse() {
        sortByName();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList with least hours played at first index
    public void sortByHoursPlayed() {
        gameList.sort(new HoursComparator());
    }

    // EFFECTS: Sorts gameList with least hours played at last index
    public void sortByHoursPlayedReverse() {
        sortByHoursPlayed();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList with lowest ranking at first index
    public void sortByRanking() {
        gameList.sort(new RankingComparator());
    }

    // EFFECTS: Sorts ganmelist with the lowest ranking at the highest index
    public void sortByRankingReverse() {
        sortByRanking();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList with higest difficulty at first index
    public void sortByDifficulty() {
        gameList.sort(new DifficultyComparator());
    }

    // EFFECTS: Sorts gameList with higest difficulty at last index
    public void sortByDifficultyReverse() {
        sortByDifficulty();
        Collections.reverse(gameList);
    }


    // EFFECTS: Sorts gameList with owned games at first index
    public void sortByOwned() {
        gameList.sort(new OwnedComparator());
    }

    // EFFECTS: Sorts gameList with owned games at last index
    public void sortByOwnedReverse() {
        gameList.sort(new OwnedComparator());
        Collections.reverse(gameList);
    }

    // MODIFIES: this
    // EFFECTS: sets gameList to empty
    public void clearList() {
        gameList.clear();
    }

    // MODIFIES: this
    // EFFECTS: removes game at index i from gameList
    public void removeGame(int i) {
        gameList.remove(i);
    }

    // EFFECTS: produces game at index i
    public Game getGame(int i) {
        return gameList.get(i);
    }

    // EFFECTS: produces size of gameList
    public int getSize() {
        return gameList.size();
    }

    // EFFECTS: adds game to end of gameList
    public void addGame(Game game) {
        gameList.add(game);
    }

    // EFFECTS: returns true if game is withing gameList, false otherwise
    public boolean containGame(Game game) {
        return gameList.contains(game);
    }


    // EFFECTS: produces string of all the games with each
    // of the games fields being listed out
    public String produceGames() {
        String games = "";
        for (Game game : gameList) {
            games += "Name: " + game.getName() + ", Price: $" + game.getPrice() + ", Owned? " + game.isOwned()
                    + "\n" + "Genre: " + game.getGenre() + ", Hours Played: " + game.getHoursPlayed()
                    + ", Difficulty Level: " + game.getDifficulty() + "\n" + "Personal Ranking: " + game.getRanking()
                    + "\n\n";
        }
        return games;
    }

    // EFFECTS: returns budget of gameList
    public double getBudget() {
        return budget;
    }

    // REQUIRES: budget >= 0
    // MODIFIES: this
    // EFFECTS: changes budget to new budget
    public void changeBudget(double newBudget) {
        this.budget = newBudget;

    }
}
