package ui.gui.popupwindows;

import model.Game;
import model.GameManager;

import javax.swing.*;

// A class that makes a pop up remove window

public class PopUpRemoveWindow extends JOptionPane {
    private GameManager gm;
    private JTextField removalField;
    private ImageIcon error = new ImageIcon("./data/images/errorSign.png");
    private ImageIcon trash = new ImageIcon("./data/images/trashCan.png");
    private ImageIcon check = new ImageIcon("./data/images/checkmark.png");

    // EFFECTS: Creates a Option Pane window for users to create a game
    public PopUpRemoveWindow(GameManager gm) {
        this.gm = gm;
        removalField = new JTextField();
        this.setVisible(true);
        runWindow();

    }

    // MODIFIES: gm
    // EFFECTS: shows dialog box to take in user input
    private void runWindow() {
        Game game;
        Object[] message = new Object[]{"Type in name of game to remove", removalField};
        int option = showConfirmDialog(null, message, "Delete Game",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,trash);
        game = this.gm.getGameByName(removalField.getText());
        if (option == JOptionPane.OK_OPTION) {
            try {
                this.gm.removeGame(game);
                JOptionPane.showMessageDialog(null, "Game has been removed", "REMOVED",
                        JOptionPane.INFORMATION_MESSAGE, check);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Game not found",
                        "ERROR", JOptionPane.ERROR_MESSAGE, error);
            }
        }
    }
}
