package ui.gui.popupwindows;

import model.Game;
import model.GameManager;

import javax.swing.*;

// A class that makes a pop up remove window

public class PopUpRemoveWindow extends JOptionPane {
    private final GameManager gm;
    private JTextField removalField;
    private Object[] message;

    // EFFECTS: Creates a Option Pane window for users to create a game
    public PopUpRemoveWindow(GameManager gm) {
        this.gm = gm;
        removalField = new JTextField();
        message = new Object[]{"Type in name of game to remove", removalField};
        this.setVisible(true);
        runWindow();

    }


    // EFFECTS: shows dialog box to take in user input
    private void runWindow() {
        Game game;
        ImageIcon error = new ImageIcon("./data/images/errorSign.png");
        ImageIcon trash = new ImageIcon("./data/images/trashCan.png");
        ImageIcon check = new ImageIcon("./data/images/checkmark.png");
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
