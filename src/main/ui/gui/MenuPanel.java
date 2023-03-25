package ui.gui;

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
    private JFrame frame;

    // EFFECTS: Creates a new menu panel with associated buttons attached
    public MenuPanel(JFrame frame) {
        initializeButtons();
        initializeMenuPanel();
        this.frame = frame;
    }

    // EFFECTS: sets sizes of panel and color
    private void initializeMenuPanel() {
        setPreferredSize(new Dimension(50, 50));
        setVisible(true);
        setBackground(Color.BLACK);
    }

    // EFFECTS: creates and adds all buttons
    private void initializeButtons() {
        addButton = new AddButton(frame);
        this.add(addButton);
        removeButton = new RemoveButton(frame);
        this.add(removeButton);
        saveButton = new SaveButton(frame);
        this.add(saveButton);
        loadButton = new LoadButton(frame);
        this.add(loadButton);
    }

}
