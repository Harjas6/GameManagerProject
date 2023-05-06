package model;


import persistence.Writable;
import model.comparators.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// gameList is a List of the games a user can input alongside a budget that is >= 0.
// Based off the individual facets of inputted games
// user can sort, get averages from the list, and see what games are purchasable according to the budget

public class GameManager implements Writable {

    private List<Game> gameList;

    public GameManager() {
        this.gameList = new ArrayList<>();
    }


    // REQUIRES: budget to be > 0
    // EFFECTS: Produces a list of games that can be bought according to budget
    public List<Game> canBuy(double budget) {
        List<Game> underBudget = new ArrayList<>();
        for (Game game : gameList) {
            if (!game.isOwned() && (budget >= game.getPrice())) {
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

    // EFFECTS: Produces average price of unowned games in gameList to two decimal places
    public double averageUnownedPrice() {
        double total = 0;
        int counter = 0;
        for (Game game : gameList) {
            if (!game.isOwned()) {
                total += game.getPrice();
                counter += 1;
            }
        }
        total = (total / counter);
        total = (int) (total * 100);
        return total / 100;
    }

    // EFFECTS: returns average price of all games in list
    public double averagePriceAll() {
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
        EventLog.getInstance().logEvent(new Event("Sorted by price"));
    }


    // EFFECTS: Sorts list with the cheapest game at the last index
    public void sortByPriceReverse() {
        sortByPrice();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by price in reverse"));
    }


    // EFFECTS: Sorts gameList according to the order
    // the genre enumeration was declared with the first one declared at the top
    // Also is the genres alphabetical order
    public void sortByGenre() {
        gameList.sort(new GenreComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by Genre"));
    }

    // EFFECTS: Sorts gameList in reverse order of the genre declaration in enumeration
    // also the reverse alphabetical order for the genre
    public void sortByGenreReverse() {
        sortByGenre();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by Genre reverse"));
    }


    // EFFECTS: Sorts gameList in lexicographical order
    public void sortByName() {
        gameList.sort(new NameComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by Name"));
    }

    // EFFECTS: Sorts gameList in reverse lexicographical order
    public void sortByNameReverse() {
        sortByName();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by Name reverse"));
    }


    // EFFECTS: Sorts gameList with least hours played at first index
    public void sortByHoursPlayed() {
        gameList.sort(new HoursComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by Hours"));
    }

    // EFFECTS: Sorts gameList with least hours played at last index
    public void sortByHoursPlayedReverse() {
        sortByHoursPlayed();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by Hours reverse "));
    }


    // EFFECTS: Sorts gameList with lowest ranking at first index
    public void sortByRanking() {
        gameList.sort(new RankingComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by ranking "));
    }

    // EFFECTS: Sorts ganmelist with the lowest ranking at the highest index
    public void sortByRankingReverse() {
        sortByRanking();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by ranking reverse"));
    }


    // EFFECTS: Sorts gameList with highest difficulty at first index
    public void sortByDifficulty() {
        gameList.sort(new DifficultyComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by difficulty"));
    }

    // EFFECTS: Sorts gameList with higest difficulty at last index
    public void sortByDifficultyReverse() {
        sortByDifficulty();
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by difficulty reverse"));
    }


    // EFFECTS: Sorts gameList with owned games at first index
    public void sortByOwned() {
        gameList.sort(new OwnedComparator());
        EventLog.getInstance().logEvent(new Event("Sorted by owned"));
    }

    // EFFECTS: Sorts gameList with owned games at last index
    public void sortByOwnedReverse() {
        gameList.sort(new OwnedComparator());
        Collections.reverse(gameList);
        EventLog.getInstance().logEvent(new Event("Sorted by owned reverse"));
    }

    // MODIFIES: this
    // EFFECTS: sets gameList to empty
    public void clearList() {
        gameList.clear();
        EventLog.getInstance().logEvent(new Event("Clears all games in game list"));
    }

    // REQUIRES: list must not be empty, i must be within index range
    // MODIFIES: this
    // EFFECTS: removes game at index i from gameList
    public void removeGameByPosition(int i) {
        gameList.remove(i);
        EventLog.getInstance().logEvent(new Event("Removed game in position " + i));
    }

    public void removeGame(Game game) throws Exception {
        if (game == null || !gameList.contains(game)) {
            throw new Exception();
        }
        this.gameList.remove(game);
        EventLog.getInstance().logEvent(new Event("Removed game named " + game.getName()));
    }

    // EFFECTS: returns name whose name matches name;
    public Game getGameByName(String name) {
        Game result = null;
        for (Game g : gameList) {
            if (g.getName().equals(name)) {
                result = g;
                break;
            }
        }
        return result;
    }

    // REQUIRES: i is within list's index
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
        EventLog.getInstance().logEvent(new Event("Added game " + game.getName()));
    }

    // EFFECTS: returns true if game is withing gameList, false otherwise
    public boolean containGame(Game game) {
        return gameList.contains(game);
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void addAll(GameManager list) {
        gameList.addAll(list.getGameList());
        EventLog.getInstance().logEvent(new Event("Added all games into this list"));
    }

    // EFFECTS: produces string of all the games with each
    // of the games fields being listed out
    public String produceGames() {
        String games = "";
        int i = 1;
        for (Game game : gameList) {
            games += "\n\nGame# " + i + " "
                    + ", Name: " + game.getName() + ", Price: $" + game.getPrice() + ", Owned? " + game.isOwned()
                    + "\n" + "Genre: " + game.getGenre() + ", Hours Played: " + game.getHoursPlayed()
                    + ", Difficulty Level: " + game.getDifficulty() + "\n" + "Personal Ranking: " + game.getRanking();
            i++;
        }
        return games;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("games", gamesToJson());
        return json;
    }

    // EFFECTS: returns games in this game manager as a JSON array
    private JSONArray gamesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Game g : gameList) {
            jsonArray.put(g.toJson());
        }
        return jsonArray;
    }
}
