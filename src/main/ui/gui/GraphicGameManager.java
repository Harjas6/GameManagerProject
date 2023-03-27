package ui.gui;

import model.Game;
import model.GameManager;

import javax.swing.*;
import java.awt.*;


// Represents a GUI
public class GraphicGameManager extends JFrame {

    private GameManager gm;

    public GraphicGameManager() {
        super("Game Manager");
        this.gm = new GameManager();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setLayout(new BorderLayout());
        add(new MenuPanel(this.gm), BorderLayout.SOUTH);
        add(new MainPanel(this.gm), BorderLayout.CENTER);
        add(new ColumnTitlePanel(), BorderLayout.NORTH);
        setVisible(true);

    }

}

