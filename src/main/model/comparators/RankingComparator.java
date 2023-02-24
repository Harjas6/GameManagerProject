package model.comparators;

import model.Game;

import java.util.Comparator;

public class RankingComparator implements Comparator<Game> {

    //EFFECTS: compares the rank of two games and returns
    // -1 in game1 rank is less than game 2, 0 if equal, and 1 if game1 rank
    // is greater than game2
    @Override
    public int compare(Game game1, Game game2) {
        return Integer.compare(game1.getRanking(), game2.getRanking());
    }
}
