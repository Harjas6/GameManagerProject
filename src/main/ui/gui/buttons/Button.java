package ui.gui.buttons;

import model.GameManager;
import ui.gui.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstracts class that represents a button
public abstract class Button extends JButton implements ActionListener {

    protected GameManager gm;
    protected  MainPanel mainPanel;

    // EFFECTS: creates a button
    public Button(String text, GameManager gm, MainPanel mainPanel) {
        super(text);
        this.gm = gm;
        this.mainPanel = mainPanel;
        this.addActionListener(this);
        this.setFocusable(false);
    }

    // MODIFIES: mainPanel
    // EFFECTS: Prints games to panels
    protected void reprintGames() {
        mainPanel.removeAll();
        mainPanel.showGames();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    protected abstract void performButtonAction();


    // REQUIRES: action event source is from a button
    // MODIFES: gm
    // EFFECTS: performs action specified by button
    @Override
    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        b.performButtonAction();
    }


}
