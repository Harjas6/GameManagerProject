package ui.gui;

import model.Game;
import model.GameManager;

import javax.swing.*;
import java.awt.*;

// Represents that main area where all the contents of Game Manager will be displayed
public class MainPanel extends JPanel {


private GameManager gm;

    // EFFECTS: Makes the main Panel with the contents of GameManager
    public MainPanel(GameManager gm) {
        this.gm = gm;
        showGames();
        setBackground(Color.lightGray);
        setVisible(true);
        showGames();
    }

    // EFFECTS: show the games on the panel
    private void showGames() {
        for (Game g : this.gm.getGameList()) {
            JPanel panel = printGame();
            add(panel);
        }
    }

    // EFFECTS: prints out the game on the screen
    private JPanel printGame() {
        return null;
    }
}
