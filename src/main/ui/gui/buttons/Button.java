package ui.gui.buttons;

import model.GameManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstracts class that represents a button
public abstract class Button extends JButton implements ActionListener {


    protected GameManager gm;

    // EFFECTS: creates a button
    public Button(String text, GameManager gm) {
        super(text);
        this.gm = gm;
        this.addActionListener(this);
        this.setFocusable(false);
    }

    protected abstract void performButtonAction();

    // REQUIRES: action event source is from a button
    // EFFECTS: performs action specified by button
    @Override
    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        b.performButtonAction();
    }


}
