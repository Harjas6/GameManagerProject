package ui.gui.buttons;

import model.GameManager;
import persistence.JsonReader;
import persistence.JsonWriter;

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
            System.out.println("Saved games to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }
}
