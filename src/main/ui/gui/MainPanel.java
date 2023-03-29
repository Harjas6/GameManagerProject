package ui.gui;

import model.Game;
import model.GameManager;

import javax.swing.*;
import java.awt.*;

// Represents the area where all the contents of Game Manager will be displayed
public class MainPanel extends JPanel {


    private GameManager gm;

    // EFFECTS: Makes the main Panel with the contents of GameManager
    public MainPanel(GameManager gm) {
        this.gm = gm;
        showGames();
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setLayout(new GridLayout(7,1));

    }

    // MODIFES: this
    // EFFECTS: show the games on the panel
    public void showGames() {
        for (Game g : this.gm.getGameList()) {
            JPanel panel = printGame(g);
            this.add(panel, BorderLayout.AFTER_LAST_LINE);
        }
    }

    // MODFIES: this
    // EFFECTS: makes a panel with a game on it
    private JPanel printGame(Game game) {
        JPanel gamePanel = new JPanel(new GridLayout(1, 7));
        gamePanel.setSize(10000000,60);
        gamePanel.add(generateName(game));
        gamePanel.add(generateRanking(game));
        gamePanel.add(generateDifficulty(game));
        gamePanel.add(generateHours(game));
        gamePanel.add(generatePrice(game));
        gamePanel.add(generateGenre(game));
        gamePanel.add(generateOwned(game));
        setColorOfLabel(gamePanel);
        gamePanel.setBackground(Color.LIGHT_GRAY);

        return gamePanel;
    }

    // MODFIES: this
    // EFFECTS: sets all labels to color black
    private void setColorOfLabel(JPanel panel) {
        Component[] comps = panel.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JComponent) {
                ((JComponent) comp).setForeground(Color.BLACK);
            }
        }
    }


    // EFFECTS: creates label representing games owned status
    private JLabel generateOwned(Game game) {
        String status;
        if (game.isOwned()) {
            status = "True";
        } else {
            status = "False";
        }
        JLabel label = new JLabel(status);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games Genre status
    private JLabel generateGenre(Game game) {
        JLabel label = new JLabel(game.getGenre().toString());
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games price status
    private JLabel generatePrice(Game game) {
        JLabel label = new JLabel(String.valueOf(game.getPrice()));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games hours status
    private JLabel generateHours(Game game) {
        JLabel label = new JLabel(String.valueOf(game.getHoursPlayed()));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games difficulty status
    private JLabel generateDifficulty(Game game) {
        JLabel label = new JLabel(String.valueOf(game.getDifficulty()));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games ranking status
    private JLabel generateRanking(Game game) {
        JLabel label = new JLabel(String.valueOf(game.getRanking()));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // EFFECTS: creates label representing games name status
    private JLabel generateName(Game game) {
        JLabel label = new JLabel(game.getName());
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

}
