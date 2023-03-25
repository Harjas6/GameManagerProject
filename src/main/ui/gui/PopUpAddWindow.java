package ui.gui;

import model.Game;
import model.GameManager;

import javax.swing.*;
import java.awt.*;


// A pop up window used to take in inputs to make a new game
public class PopUpAddWindow extends JOptionPane {


    public PopUpAddWindow() {
        super("Create Game");
        JPanel panel = new JPanel();
        JPanel titles = titlePanel();
        panel.setLayout(new BorderLayout());
        panel.add(titles, BorderLayout.WEST);
        panel.add(new AddGameInfoPanel());
        runWindow();
        this.setVisible(true);
    }

    private void runWindow() {
    }




    private JPanel titlePanel() {
        JPanel panel = new JPanel();
        panel.setSize(75,1000);
        panel.setBackground(Color.GRAY);
        panel.add(new JLabel("Name"));
        panel.add(new JLabel("Price"));
        panel.add(new JLabel("Difficulty"));
        panel.add(new JLabel("Rank"));
        panel.add(new JLabel("Genre"));
        panel.add(new JLabel("Hours"));
        panel.add(new JLabel("Owned"));
        panel.setLayout(new GridLayout(7,1));
        return panel;
    }
}
