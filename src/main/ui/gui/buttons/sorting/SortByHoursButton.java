package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;

// Class representing a button that sorts by hours played

public class SortByHoursButton extends Button {

    boolean sorted;

    // EFFECTS creates a new SortByHoursPlayedButton using superclasses constructor and setting fields
    public SortByHoursButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;

    }

    // MODIFES: gm, mainPanel
    // EFFECTS: sorts by gm hours played and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIFIES gm
    // EFFECTS: sorts by gm hours played
    private void sortGames() {
        if (sorted) {
            this.gm.sortByHoursPlayedReverse();
        } else {
            this.gm.sortByHoursPlayed();
        }
        this.sorted = !this.sorted;
    }
}
