package model.comparators;

import model.Game;

import java.util.Comparator;

public class GenreComparator implements Comparator<Game> {
    // EFFECTS: Returns a negative integer if genre of game1 is less than game2
    // genre(in enum declaration order, 0 if equal, 1 otherwise
    @Override
    public int compare(Game game1, Game game2) {
        return (game1.getGenre().compareTo(game2.getGenre()));
    }
}
