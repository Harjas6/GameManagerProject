package ui.gui.buttons.sorting;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.buttons.Button;

// Class representing a button that sorts by price
public class SortByPriceButton extends Button {

    private boolean sorted;

    // EFFECTS creates a new SortByPriceButton using superclasses constructor and setting fields
    public SortByPriceButton(String text, GameManager gm, MainPanel mainPanel) {
        super(text, gm, mainPanel);
        this.sorted = false;
    }

    // MODIEFIES; gm, mainPanel
    // EFFECTS: sorts gm by price and displays it
    @Override
    protected void performButtonAction() {
        sortGames();
        reprintGames();

    }

    // MODIEFIES; gm
    // EFFECTS: sorts gm by price
    private void sortGames() {
        if (sorted) {
            this.gm.sortByPriceReverse();
        } else {
            this.gm.sortByPrice();
        }
        this.sorted = !this.sorted;
    }
}
