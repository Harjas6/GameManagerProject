package ui.gui.buttons;

import model.GameManager;
import persistence.JsonWriter;
import ui.gui.MainPanel;

import javax.swing.*;


// Represents a button that saves games
public class SaveButton extends Button {

    private static final ImageIcon SAVE = new ImageIcon("./data/images/saveButton.png");
    private static final String JSON_STORE = "./data/gameManager.json";
    private JsonWriter jsonWriter;

    // EFFECTS: creates a button using superclass to save games
    public SaveButton(GameManager gm, MainPanel mainPanel) {
        super("", gm, mainPanel);
        this.jsonWriter = new JsonWriter(JSON_STORE);
        setIcon(SAVE);
    }

    // MODIFES: gm
    // EFFECTS: executes save buttons
    @Override
    protected void performButtonAction() {
        saveGames();
    }

    // MODIFES: gm
    // EFFECTS: saves games to file
    private void saveGames() {
        try {
            ImageIcon save = new ImageIcon("./data/images/saveButton.png");
            jsonWriter.open();
            jsonWriter.write(gm);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Games have been saved",
                    "SAVE",JOptionPane.INFORMATION_MESSAGE,save);
        } catch (Exception e) {
            ImageIcon icon = new ImageIcon("./data/images/errorSign.png");
            JOptionPane.showMessageDialog(null, "Could not save to " + JSON_STORE,
                    "ERROR", JOptionPane.ERROR_MESSAGE, icon);
        }
    }
}
