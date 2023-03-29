package ui.gui.buttons;


import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.popupwindows.PopUpAddWindow;

import javax.swing.*;

//  Class representing a button that adds game
public class AddButton extends Button {

    private static final ImageIcon ADD = new ImageIcon("./data/images/addButton.png");

    // EFFECTS: Creates button using superclass and sets Icon to ADD
    public AddButton(GameManager gm, MainPanel mainPanel) {
        super("", gm, mainPanel);
        setIcon(ADD);
    }

    // MODIFIES: gm, main panel
    // EFFECTS: adds game to GameManager and displays it
    @Override
    protected void performButtonAction() {
        addGame();
        reprintGames();

    }

    // MODIFES: gm
    // EFFECTS: Creates a new window to add game
    private void addGame() {
        new PopUpAddWindow(this.gm);


    }
}
