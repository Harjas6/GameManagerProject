package ui.gui;

import javax.swing.*;
import java.awt.*;

// Represents that main area where all the contents of Game Manager will be displayed
public class MainPanel extends JPanel {

    private JFrame frame;
    // EFFECTS: Makes the main Panel with the contents of GameManager
    public MainPanel(JFrame frame) {
        this.frame = frame;
        setBackground(Color.lightGray);
        setVisible(true);
    }
}
