package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;

// Class representing a button that sorts by owned
public class SortByOwnedButton extends Button {

    private boolean sorted;


     // EFFECTS creates a new SortByOwnedButton using superclasses constructor and setting fields
    public SortByOwnedButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }

    // MODIEFIES; gm, mainPanel
    // EFFECTS: sorts gm by owned and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIEFIES; gm,
    // EFFECTS: sorts gm by owned
    private void sortGames() {
        if (sorted) {
            this.gm.sortByOwnedReverse();
        } else {
            this.gm.sortByOwned();
        }
        this.sorted = !this.sorted;
    }
}
