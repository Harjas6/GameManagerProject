package ui.gui;

import model.GameManager;

import javax.swing.*;
import java.awt.*;


// Represents a GUI
public class GraphicGameManager extends JFrame {

    private GameManager gm;

    // EFFECTS: Constructs JFrame with components
    public GraphicGameManager() {
        super("Game Manager");
        this.gm = new GameManager();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setLayout(new BorderLayout());
        MainPanel mainPanel = new MainPanel(this.gm);
        add(new MenuPanel(this.gm, mainPanel), BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(new ColumnTitleAndSortButtons(this.gm, mainPanel), BorderLayout.NORTH);
        setVisible(true);

    }

}

