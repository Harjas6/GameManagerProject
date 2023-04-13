package ui.gui;

import model.GameManager;
import ui.gui.buttons.sorting.*;

import javax.swing.*;
import java.awt.*;

// A panel that has all labels corresponding ot a games fields
public class ColumnTitleAndSortButtons extends JPanel {

    private final MainPanel mp;
    private GameManager gm;

    // MODIFIES: this
    // EFFECTS: creates a panel with all labels added
    public ColumnTitleAndSortButtons(GameManager gm, MainPanel mp) {
        this.mp = mp;
        this.gm = gm;
        this.setLayout(new GridLayout(1, 7));
        initializeSortButtons();
        this.setSize(100, 50);
        this.setBackground(new Color(180, 180, 180));
        this.setVisible(true);
        setColorOfLabel(this);

    }

    // MODIFIES: this
    // EFFECTS: sets all label colors to Black
    private void setColorOfLabel(JPanel panel) {
        Component[] comps = panel.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JComponent) {
                ((JComponent) comp).setForeground(Color.BLACK);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates and adds sort buttons to panels
    private void initializeSortButtons() {
        add(new SortByNameButton("Name", this.gm, this.mp));
        add(new SortByRankButton("Rank", this.gm, this.mp));
        add(new SortByDifficultyButton("Difficulty", this.gm, this.mp));
        add(new SortByHoursButton("Hours Played", this.gm, this.mp));
        add(new SortByPriceButton("Price", this.gm, this.mp));
        add(new SortByGenreButton("Genre", this.gm, this.mp));
        add(new SortByOwnedButton("Owned?", this.gm, this.mp));
    }

}
