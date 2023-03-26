package ui.gui;

import model.Game;
import model.Game.Genre.*;

import javax.swing.*;

import java.awt.*;



// A pop up window used to take in inputs to make a new game
public class PopUpAddWindow extends JOptionPane {

    private Object[] objects;
    private TextFieldGenerator fields;
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
    // private JPanel genreButtonPanel;
   // private JPanel ownedPanel;

    public PopUpAddWindow() {
        super("Create Game");
        setSize(300,300);
        //JPanel panel = new JPanel();
        // JPanel titles = titlePanel();
        // panel.setLayout(new BorderLayout());
        // panel.add(titles, BorderLayout.WEST);
        // panel.add(new AddGameInfoPanel());
        ownedButtons();
        genreButtons();
        fields = new TextFieldGenerator();
        objects = new Object[]{"Name", fields.getName(),
                "Price", fields.getPrice(), "Difficulty", fields.getDifficulty(),
                "Rank", fields.getRank(), "Hours", fields.getHours(),
                "Genre", action, openWorld, rpg, platformer, shooting, sports, "Owned", isOwned, notOwned};
        runWindow();
        this.setVisible(true);
    }

    private void runWindow() {
        int option = showConfirmDialog(null, objects, "Create Game", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Game g = new Game(fields.getName().getText(), Double.parseDouble(fields.getHours().getText()),
                     Double.parseDouble(fields.getDifficulty().getText()),Integer.parseInt(fields.getRank().getText()),
                     Game.Genre.valueOf(genres.getSelection().getActionCommand()),Double.parseDouble(fields.getPrice().getText()),
                    isOwned.isSelected());
            System.out.println(g);
        }


    }

    // EFFECTS: makes genre selection buttons
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
//        genreButtonPanel = new JPanel(new GridLayout());
//        genreButtonPanel.add(action);
//        genreButtonPanel.add(openWorld);
//        genreButtonPanel.add(platformer);
//        genreButtonPanel.add(rpg);
//        genreButtonPanel.add(shooting);
//        genreButtonPanel.add(sports);
//        genreButtonPanel.setVisible(true);

    }

    // EFFECTS: Makes owned radio buttons
    private void ownedButtons() {
        owned = new ButtonGroup();
        isOwned = new JRadioButton("Owned");
        notOwned = new JRadioButton("Not Owned");
        owned.add(isOwned);
        owned.add(notOwned);
//        ownedPanel = new JPanel(new GridLayout());
//        ownedPanel.add(isOwned);
//        ownedPanel.add(notOwned);
    }
}


