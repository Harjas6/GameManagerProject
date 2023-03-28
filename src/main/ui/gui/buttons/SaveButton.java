package ui.gui.buttons;

import model.GameManager;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;


// Represents a button that saves games
public class SaveButton extends Button {

    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/gameManager.json";

    // EFFECTS: creates a button using superclass to save games
    public SaveButton(GameManager gm) {
        super("SAVE", gm);
        this.jsonWriter = new JsonWriter(JSON_STORE);
    }

    // MODIFES: gm
    // EFFECTS: executes save buttons
    @Override
    protected void performButtonAction() {
        System.out.println("SAVE");
        saveGames();
    }

    // MODIFES: gm
    // EFFECTS: saves games to file
    private void saveGames() {
        try {
            jsonWriter.open();
            jsonWriter.write(gm);
            jsonWriter.close();
        } catch (Exception e) {
            ImageIcon icon = new ImageIcon("./data/errorSign.png");
            JOptionPane error = new JOptionPane();
            error.showMessageDialog(null, "Could not save to " + JSON_STORE,
                    "ERROR",JOptionPane.ERROR_MESSAGE, icon);
        }

    }
}
