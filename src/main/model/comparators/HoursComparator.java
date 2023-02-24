package model.comparators;

import model.Game;

import java.util.Comparator;

public class HoursComparator implements Comparator<Game> {

    //EFFECTS: compares the hours played of two games and returns
    // -1 in game1 hours played is less than game 2, 0 if equal, and 1 if game1 hours played
    // is greater than game2
    @Override
    public int compare(Game game1, Game game2) {
        return Double.compare(game1.getHoursPlayed(), game2.getHoursPlayed());
    }
}