package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;


// Class representing a button that sorts by difficulty

public class SortByDifficultyButton extends Button {

    private boolean sorted;

    // EFFECTS:creates a new SortByDifficultyButton using superclasses constructor and setting fields
    public SortByDifficultyButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }


    // MODIFES: gm, mainPanel
    // EFFECTS: Sorts gm by difficulty and displays games
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIFIES :gm
    // EFFECTS: Sorts gm by difficulty
    private void sortGames() {
        if (sorted) {
            this.gm.sortByDifficultyReverse();
        } else {
            this.gm.sortByDifficulty();
        }
        this.sorted = !this.sorted;
    }
}

