package ui.gui.buttons;

import model.GameManager;
import ui.gui.MainPanel;
import ui.gui.popupwindows.PopUpRemoveWindow;

import javax.swing.*;

// Represents a button that removes games
public class RemoveButton extends Button {

    private static final ImageIcon TRASH = new ImageIcon("./data/images/trashCan.png");


    // EFFECTS: Uses superclass to create a button
    public RemoveButton(GameManager gm, MainPanel mainPanel) {
        super("", gm, mainPanel);
        setIcon(TRASH);
    }

    // MODIFES: gm
    // EFFECTS: Removes a game from list;
    @Override
    protected void performButtonAction() {
        removeGame();
        mainPanel.removeAll();
        mainPanel.showGames();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // MODIFES: gm
    // EFFECTS: creates a pop up window to remove game
    private void removeGame() {
        new PopUpRemoveWindow(this.gm);
    }
}
