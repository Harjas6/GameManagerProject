package ui.gui;

import model.GameManager;

import javax.swing.*;
import java.awt.*;

// Represents that main area where all the contents of Game Manager will be displayed
public class MainPanel extends JPanel {


private GameManager gm;

    // EFFECTS: Makes the main Panel with the contents of GameManager
    public MainPanel(GameManager gm) {
        this.gm = gm;
        setBackground(Color.lightGray);
        setVisible(true);
        showGames();
    }

    private void showGames() {
    }
}
