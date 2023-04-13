package ui.gui.popupwindows;

import model.Game;
import model.GameManager;
import ui.gui.AddGameTextFields;

import javax.swing.*;


// A pop up window used to take in inputs to make a new game
public class PopUpAddWindow extends JOptionPane {



    private GameManager gm;
    private AddGameTextFields fields;

    private JRadioButton sports;
    private JRadioButton shooting;
    private JRadioButton action;
    private JRadioButton platformer;
    private JRadioButton openWorld;
    private JRadioButton rpg;
    private JRadioButton isOwned;
    private JRadioButton notOwned;
    private ButtonGroup owned;
    private ButtonGroup genres;

    private ImageIcon icon = new ImageIcon("./data/images/errorSign.png");
    private ImageIcon add = new ImageIcon("./data/images/addButton.png");
    private ImageIcon check = new ImageIcon("./data/images/checkmark.png");


// EFFECTS: Creates a Option Pane window for users to create a game
    public PopUpAddWindow(GameManager gm) {
        this.gm = gm;
        ownedButtons();
        genreButtons();
        fields = new AddGameTextFields();
        this.setVisible(true);
        runWindow();

    }

    // MODIFES: gm
    // EFFECTS: shows dialog box to take in user input
    private void runWindow() {
        Game newGame;
        Object[] message = makeMessage();
        int option = showConfirmDialog(null, message, "Create Game",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, add);
        if (option == JOptionPane.OK_OPTION) {
            try {
                newGame = makeGame();
                this.gm.addGame(newGame);
                JOptionPane.showMessageDialog(null, "Game has been added", "ADDED",
                        JOptionPane.INFORMATION_MESSAGE, check);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Not valid input",
                        "ERROR",JOptionPane.ERROR_MESSAGE, icon);
            }
        }
    }

    private Object[] makeMessage() {
        return new Object[]{"Name", fields.getName(),
                "Price($)", fields.getPrice(), "Difficulty", fields.getDifficulty(),
                "Rank", fields.getRank(), "Hours(can be decimal)", fields.getHours(),
                "Genre", action, openWorld, rpg, platformer, shooting, sports, "Is it Owned?", isOwned, notOwned};
    }

    // EFFECTS: makes a new game from the input
    private Game makeGame() {
        return new Game(fields.getName().getText(), Double.parseDouble(fields.getHours().getText()),
                Double.parseDouble(fields.getDifficulty().getText()),
                Integer.parseInt(fields.getRank().getText()),
                Game.Genre.valueOf(genres.getSelection().getActionCommand()),
                Double.parseDouble(fields.getPrice().getText()),
                isOwned.isSelected());
    }

    // MODIFIES: this
    // EFFECTS: makes genre selection buttons and adds them
    private void genreButtons() {
        genres = new ButtonGroup();
        sports = new JRadioButton("Sports Game");
        sports.setActionCommand("SPORT");
        shooting = new JRadioButton("1st/3rd Person Shooter");
        shooting.setActionCommand("SHOOTER");
        action = new JRadioButton("Action/Adventure Game");
        action.setActionCommand("ACTADV");
        platformer = new JRadioButton("Platforming Game");
        platformer.setActionCommand("PLATFORMER");
        openWorld = new JRadioButton("Open-World Game");
        openWorld.setActionCommand("OPENWORLD");
        rpg = new JRadioButton("Role-playing Game");
        rpg.setActionCommand("RPG");
        genres.add(action);
        genres.add(openWorld);
        genres.add(platformer);
        genres.add(rpg);
        genres.add(shooting);
        genres.add(sports);
    }

    // MODIFIES: this
    // EFFECTS: Makes owned radio buttons
    private void ownedButtons() {
        owned = new ButtonGroup();
        isOwned = new JRadioButton("Owned");
        notOwned = new JRadioButton("Not Owned");
        owned.add(isOwned);
        owned.add(notOwned);

    }
}


