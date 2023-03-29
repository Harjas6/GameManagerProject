package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;


// Class representing a button that sorts by genre
public class SortByGenreButton extends Button {

    private boolean sorted;


    //EFFECTS creates a new SortByGenreButton using superclasses constructor and setting fields
    public SortByGenreButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }

    // MODIFIES: gm MainPanel
    // EFFECTS: Sorts gm  by genre and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIFIES: gm
    // EFFECTS Sorts gm by genre
    private void sortGames() {
        if (sorted) {
            this.gm.sortByGenreReverse();
        } else {
            this.gm.sortByGenre();
        }
        this.sorted = !this.sorted;
    }
}
