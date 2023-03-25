package ui.gui.buttons;

import javax.swing.*;

// Represents a button that saves games
public class SaveButton extends Button {

    // EFFECTS: creates a button using superclass to save games
    public SaveButton(JFrame frame) {
        super("SAVE", frame);
    }

    // EFFECTS: Saves games in list
    @Override
    protected void performButtonAction() {
        System.out.println("SAVE");
    }
}
