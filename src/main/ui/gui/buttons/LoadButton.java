package ui.gui.buttons;

import model.Game;
import model.GameManager;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//  Class representing a button that loads game
public class LoadButton extends Button {

    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/gameManager.json";


    // EFFECTS: Creates a button using the superclasses constructor
    public LoadButton(GameManager gm) {
        super("LOAD", gm);
        this.jsonReader = new JsonReader(JSON_STORE);
    }

    // MODIFIES: gm
    // EFFECTS: executes load buttons
    @Override
    protected void performButtonAction() {
        System.out.println("LOAD");
        loadGames();
    }

    // MODIFIES: gm
    // EFFECTS: Loads games from json file
    private void loadGames() {
        try {
            GameManager temp;
            temp = jsonReader.read();
            this.gm.addAll(temp);
            System.out.println("Loaded games from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
