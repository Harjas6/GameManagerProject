package model.comparators;

import model.Game;

import java.util.Comparator;

public class DifficultyComparator implements Comparator<Game> {

    //EFFECTS: compares the difficulty of two games and returns
    // -1 in game2 difficulty is less than game 1, 0 if equal, and 1 if game2 difficulty
    // is greater than game1
    @Override
    public int compare(Game game1, Game game2) {
        return Double.compare(game2.getDifficulty(), game1.getDifficulty());
    }
}

