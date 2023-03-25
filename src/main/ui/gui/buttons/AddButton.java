package ui.gui.buttons;


import model.GameManager;
import ui.gui.AddGameInfoPanel;
import ui.gui.PopUpAddWindow;

import javax.swing.*;
import java.awt.*;

//  Class representing a button that adds game
public class AddButton extends Button {

    // EFFECTS: Creates button using superclass
    public AddButton(JFrame frame) {
        super("ADD GAME", frame);
    }

    // MODIFIES: gameManager
    // EFFECTS: adds game to GameManager
    @Override
    protected void performButtonAction() {
        System.out.println("ADDED");
        addGame();
    }

    private void addGame() {
        new PopUpAddWindow();


    }
}
