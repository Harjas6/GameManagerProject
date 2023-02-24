package model.comparators;

import model.Game;

import java.util.Comparator;

public class PriceComparator implements Comparator<Game> {

    //EFFECTS: compares the price  of two games and returns
    // -1 in game1 price  is less than game 2, 0 if equal, and 1 otherwise
    @Override
    public int compare(Game game1, Game game2) {
        return Double.compare(game1.getPrice(), game2.getPrice());
    }
}