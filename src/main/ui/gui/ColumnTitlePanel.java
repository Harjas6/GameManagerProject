package ui.gui;

import javax.swing.*;
import java.awt.*;

// A panel that has all labels corresponding ot a games fields
public class ColumnTitlePanel extends JPanel {


    // EFFECTS: creates a panel with all labels added
    public ColumnTitlePanel() {
        this.setLayout(new GridLayout(1, 7));
        intializeJLabel();
        this.setSize(100, 50);
        this.setBackground(new Color(180, 180, 180));
        this.setVisible(true);
        setColorOfLabel(this);

    }

    // EFFECTS: sets all label colors to white
    private void setColorOfLabel(JPanel panel) {
        Component[] comps = panel.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JComponent) {
                ((JComponent) comp).setForeground(Color.BLACK);
            }
        }
    }

    // EFFECTS: Creates and adds JLabels to panels
    private void intializeJLabel() {
        JLabel name = new JLabel("Name");
        add(name);
        name.setHorizontalAlignment(JLabel.CENTER);
        JLabel ranking = new JLabel("Ranking");
        add(ranking);
        ranking.setHorizontalAlignment(JLabel.CENTER);
        JLabel difficulty = new JLabel("Difficulty");
        add(difficulty);
        difficulty.setHorizontalAlignment(JLabel.CENTER);
        JLabel hoursPlayed = new JLabel("Hours Played");
        add(hoursPlayed);
        hoursPlayed.setHorizontalAlignment(JLabel.CENTER);
        JLabel price = new JLabel("Price");
        add(price);
        price.setHorizontalAlignment(JLabel.CENTER);
        JLabel genre = new JLabel("Genre");
        add(genre);
        genre.setHorizontalAlignment(JLabel.CENTER);
        JLabel owned = new JLabel("Owned?");
        add(owned);
        owned.setHorizontalAlignment(JLabel.CENTER);
    }

}
