package ui.gui;

import model.GameManager;
import ui.gui.buttons.AddButton;
import ui.gui.buttons.LoadButton;
import ui.gui.buttons.RemoveButton;
import ui.gui.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;


// Represents a panel with all menu related options (buttons)
public class MenuPanel extends JPanel {

    private GameManager gm;
    private MainPanel mainPanel;

    // EFFECTS: Creates a new menu panel with associated buttons attached
    public MenuPanel(GameManager gm, MainPanel mainPanel) {
        this.gm = gm;
        this.mainPanel = mainPanel;
        initializeButtons();
        initializeMenuPanel();

    }

    // MODIFIES: this
    // EFFECTS: sets sizes of panel and color
    private void initializeMenuPanel() {
        setPreferredSize(new Dimension(50, 80));
        setVisible(true);
        setBackground(Color.WHITE);
    }

    // MODIFIES: this
    // EFFECTS: creates and adds all buttons
    private void initializeButtons() {
        this.add(new AddButton(gm, mainPanel));
        this.add(new RemoveButton(gm, mainPanel));
        this.add(new SaveButton(gm, mainPanel));
        this.add(new LoadButton(gm, mainPanel));
    }

}
