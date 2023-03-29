package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;

// Class representing a button that sorts by name
public class SortByNameButton extends Button {

    private boolean sorted;


    // EFFECTS creates a new SortByNameButton using superclasses constructor and setting fields
    public SortByNameButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }


    // MODIFES: gm, mainPanel
    // EFFECTS: sorts  gm by name and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIFES: gm
    // EFFECTS: sorts gm by name
    private void sortGames() {
        if (sorted) {
            this.gm.sortByNameReverse();
        } else {
            this.gm.sortByName();
        }
        this.sorted = !this.sorted;
    }
}
