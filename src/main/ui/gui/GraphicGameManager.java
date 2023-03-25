package ui.gui;

import javax.swing.*;
import java.awt.*;


// Represents a GUI
public class GraphicGameManager extends JFrame {
    public GraphicGameManager() {
        super("Game Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setLayout(new BorderLayout());
        add(new MenuPanel(this), BorderLayout.SOUTH);
        add(new MainPanel(this), BorderLayout.CENTER);
        add(new ColumnTitlePanel(this), BorderLayout.NORTH);
        setVisible(true);

    }

    // EFFECTS: Create a new GraphicsGameManager
    public static void main(String[] args) {
        new GraphicGameManager();

    }
}

