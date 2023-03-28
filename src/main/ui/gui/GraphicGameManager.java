package ui.gui;

import model.Game;
import model.GameManager;

import javax.swing.*;
import java.awt.*;

import static model.Game.Genre.*;
import static model.Game.Genre.SPORT;


// Represents a GUI
public class GraphicGameManager extends JFrame {

    private GameManager gm;

    public GraphicGameManager() {
        super("Game Manager");
        this.gm = new GameManager();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setLayout(new BorderLayout());
        MainPanel mainPanel = new MainPanel(this.gm);
        add(new MenuPanel(this.gm, mainPanel), BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(new ColumnTitlePanel(), BorderLayout.NORTH);
        setVisible(true);

    }

}

