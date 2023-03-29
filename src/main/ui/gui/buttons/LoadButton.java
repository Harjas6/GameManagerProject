package ui.gui.buttons;

import model.GameManager;
import persistence.JsonReader;
import ui.gui.MainPanel;

import javax.swing.*;

//  Class representing a button that loads game
public class LoadButton extends Button {

    private static final String JSON_STORE = "./data/gameManager.json";
    private static final ImageIcon LOAD = new ImageIcon("./data/images/load.png");
    private JsonReader jsonReader;


    // EFFECTS: Creates a button using the superclasses constructor and sets Icon to LOAD
    public LoadButton(GameManager gm, MainPanel mainPanel) {
        super("", gm, mainPanel);
        this.jsonReader = new JsonReader(JSON_STORE);
        setIcon(LOAD);
    }

    // MODIFIES: gm, mainpanel
    // EFFECTS: executes load buttons and displays it
    @Override
    protected void performButtonAction() {
        loadGames();
        reprintGames();
    }

    // MODIFIES: gm
    // EFFECTS: Loads games from json file
    private void loadGames() {
        try {
            ImageIcon check = new ImageIcon("./data/images/checkmark.png");
            GameManager temp;
            temp = jsonReader.read();
            this.gm.clearList();
            this.gm.addAll(temp);
            JOptionPane.showMessageDialog(null, "Games have been loaded",
                    "LOAD", JOptionPane.INFORMATION_MESSAGE, check);
        } catch (Exception e) {
            ImageIcon icon = new ImageIcon("./data/images/errorSign.png");
            JOptionPane.showMessageDialog(null, "Could not load/find file " + JSON_STORE,
                    "ERROR", JOptionPane.ERROR_MESSAGE, icon);
        }
    }
}
