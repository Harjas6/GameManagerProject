package model.comparators;

import model.Game;

import java.util.Comparator;

public class NameComparator implements Comparator<Game> {

    // EFFECTS: returns a positive value (number of letters to away) if game1 name  lexicographically follows
    // game2, 0 if equal, negative otherwise
    // If there is no index position at which they differ,
    // then the shorter string lexicographically precedes the longer string
    @Override
    public int compare(Game game1, Game game2) {
        return (game1.getName().toLowerCase().compareTo(game2.getName().toLowerCase()));
    }
}
