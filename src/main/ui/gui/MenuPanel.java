package ui.gui;

import model.GameManager;
import ui.gui.buttons.*;
import ui.gui.buttons.Button;

import javax.swing.*;
import java.awt.*;


// Represents a panel with all menu related options (buttons)
public class MenuPanel extends JPanel {

    private Button addButton;
    private Button removeButton;
    private Button saveButton;
    private Button loadButton;
    private GameManager gm;

    // EFFECTS: Creates a new menu panel with associated buttons attached
    public MenuPanel(GameManager gm) {
        this.gm = gm;
        initializeButtons();
        initializeMenuPanel();

    }

    // EFFECTS: sets sizes of panel and color
    private void initializeMenuPanel() {
        setPreferredSize(new Dimension(50, 50));
        setVisible(true);
        setBackground(Color.BLACK);
    }

    // EFFECTS: creates and adds all buttons
    private void initializeButtons() {
        addButton = new AddButton(gm);
        this.add(addButton);
        removeButton = new RemoveButton(gm);
        this.add(removeButton);
        saveButton = new SaveButton(gm);
        this.add(saveButton);
        loadButton = new LoadButton(gm);
        this.add(loadButton);
    }

}
