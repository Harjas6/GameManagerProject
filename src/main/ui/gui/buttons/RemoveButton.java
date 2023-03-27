package ui.gui.buttons;

import model.GameManager;

import javax.swing.*;

// Represents a button that removes games
public class RemoveButton extends Button {

    // EFFECTS: Uses superclass to create a button
    public RemoveButton(GameManager gm) {
        super("REMOVE GAME", gm);
    }


    // EFFECTS: Removes a game from list;
    @Override
    protected void performButtonAction() {
        System.out.println("REMOVE");
        removeGame();
    }

    private void removeGame() {

    }
}
