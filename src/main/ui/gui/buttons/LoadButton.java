package ui.gui.buttons;

import model.GameManager;

import javax.swing.*;

//  Class representing a button that loads game
public class LoadButton extends Button {

    // EFFECTS: Creates a button using the superclasses constructor
    public LoadButton(JFrame frame) {
        super("LOAD", frame);
    }

    // EFFECTS: Loads games from json file
    @Override
    protected void performButtonAction() {
        System.out.println("LOAD");
    }
}
