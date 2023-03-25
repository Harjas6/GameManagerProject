package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.Format;

// JPanel that take in user inout for creating a game
public class AddGameInfoPanel extends JPanel {

    private JTextField name;
    private JFormattedTextField price;
    private JFormattedTextField difficulty;
    private JFormattedTextField rank;
    private JRadioButton isOwned;
    private JRadioButton notOwned;
    private JFormattedTextField hours;
    private JRadioButton sports;
    private JRadioButton shooting;
    private JRadioButton action;
    private JRadioButton platformer;
    private JRadioButton openWorld;
    private JRadioButton rpg;


    // Creates panel with text fields
    public AddGameInfoPanel() {
        setSize(300, 500);
        setLayout(new GridLayout(7,1));
        initializeFields();
        setVisible(true);
    }

    // EFFECTS: makes text fields and radio buttons
    private void initializeFields() {
        nameField();
        priceField();
        difficultyField();
        rankField();
        genreButtons();
        hoursField();
        ownedButtons();
    }

    // EFFECTS: Makes owned radio buttons
    private void ownedButtons() {
        ButtonGroup owned = new ButtonGroup();
        isOwned = new JRadioButton("Owned");
        notOwned = new JRadioButton("Not Owned");
        owned.add(isOwned);
        owned.add(notOwned);
        JPanel panel = new JPanel(new GridLayout());
        panel.add(isOwned);
        panel.add(notOwned);
        this.add(panel);


    }

    // EFFECTS: Makes hours text field
    private void hoursField() {
        DecimalFormat df = new DecimalFormat("###.##");
        hours = new JFormattedTextField(df);
        add(hours);
    }

    // EFFECTS: makes genre selection buttons
    private void genreButtons() {
        ButtonGroup owned = new ButtonGroup();
        sports = new JRadioButton("Sports Game");
        shooting = new JRadioButton("1st/3rd Person Shooter");
        action = new JRadioButton("Action/Adventure Game");
        platformer = new JRadioButton("Platforming Game");
        openWorld = new JRadioButton("Open-World Game");
        rpg = new JRadioButton("Role-playing Game");
        owned.add(action);
        owned.add(openWorld);
        owned.add(platformer);
        owned.add(rpg);
        owned.add(shooting);
        owned.add(sports);
        JPanel panel = new JPanel(new GridLayout());
        panel.add(action);
        panel.add(openWorld);
        panel.add(platformer);
        panel.add(rpg);
        panel.add(shooting);
        panel.add(sports);

        this.add(panel);
    }

    // EFFECTS: makes ranking text field
    private void rankField() {
        DecimalFormat df = new DecimalFormat("###");
        rank = new JFormattedTextField(df);
        add(rank);

    }

    // EFFECTS: makes diffuculty text field
    private void difficultyField() {
        DecimalFormat df = new DecimalFormat("###.#");
        difficulty = new JFormattedTextField(df);
        add(difficulty);
    }

    // EFFECTS: makes price text field
    private void priceField() {
        DecimalFormat df = new DecimalFormat("###.##");
        price = new JFormattedTextField(df);
        add(price);

    }

    // EFFECTS: makes name text field
    private void nameField() {
        name = new JTextField();
        add(name);
    }
}
