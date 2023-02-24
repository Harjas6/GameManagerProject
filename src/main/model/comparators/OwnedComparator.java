package model.comparators;

import model.Game;

import java.util.Comparator;

public class OwnedComparator implements Comparator<Game> {

    //EFFECTS: compares the played value of two games and returns
    // the value 0 if game1 == game2; a value less than 0 if !game1 && game2;
    // and a value greater than 0 if game1 && !game2
    @Override
    public int compare(Game game1, Game game2) {
        return Boolean.compare(game2.isOwned(), game1.isOwned());
    }
}