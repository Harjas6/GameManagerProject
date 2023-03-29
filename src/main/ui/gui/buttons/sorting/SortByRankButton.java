package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;

//Class representing a button that sorts by rank

public class SortByRankButton extends Button {

    private boolean sorted;

    // EFFECTS: creates a new SortByRankButton using superclasses constructor and setting fields
    public SortByRankButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }

    // MODIEFIES; gm, mainPanel
    // EFFECTS: sorts gm by rank and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIEFIES; gm
    // EFFECTS: sorts gm by rank
    private void sortGames() {
        if (sorted) {
            this.gm.sortByRankingReverse();
        } else {
            this.gm.sortByRanking();
        }
        this.sorted = !this.sorted;
    }
}
