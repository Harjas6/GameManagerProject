package ui.gui.buttons;


import model.GameManager;
import ui.gui.PopUpAddWindow;

import javax.swing.*;

//  Class representing a button that adds game
public class AddButton extends Button {

    // EFFECTS: Creates button using superclass
    public AddButton(GameManager gm) {
        super("ADD GAME", gm);
    }

    // MODIFIES: gameManager
    // EFFECTS: adds game to GameManager
    @Override
    protected void performButtonAction() {
        System.out.println("ADDED");
        addGame();
    }

    private void addGame() {
        new PopUpAddWindow(this.gm);


    }
}
