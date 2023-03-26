package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

// Generates Text Fields for adding a game
public class TextFieldGenerator {

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


    // Creates all text fields with text fields
    public TextFieldGenerator() {
       // setSize(300, 500);
       // setLayout(new GridLayout(7,1));
        initializeFields();
       // setVisible(true);
    }

    // EFFECTS: makes text fields and radio buttons
    private void initializeFields() {
        nameField();
        priceField();
        difficultyField();
        rankField();
       // genreButtons();
        hoursField();
       // ownedButtons();
    }


    // EFFECTS: Makes hours text field
    private void hoursField() {
        DecimalFormat df = new DecimalFormat("###.##");
        hours = new JFormattedTextField(df);
    }

    // EFFECTS: makes ranking text field
    private void rankField() {
        DecimalFormat df = new DecimalFormat("###");
        rank = new JFormattedTextField(df);

    }

    // EFFECTS: makes diffuculty text field
    private void difficultyField() {
        DecimalFormat df = new DecimalFormat("###.#");
        difficulty = new JFormattedTextField(df);
    }

    // EFFECTS: makes price text field
    private void priceField() {
        DecimalFormat df = new DecimalFormat("###.##");
        price = new JFormattedTextField(df);

    }

    // EFFECTS: makes name text field
    private void nameField() {
        name = new JTextField();
    }

    public JTextField getName() {
        return name;
    }

    public JFormattedTextField getPrice() {
        return price;
    }

    public JFormattedTextField getDifficulty() {
        return difficulty;
    }

    public JFormattedTextField getRank() {
        return rank;
    }

    public JRadioButton getIsOwned() {
        return isOwned;
    }

    public JRadioButton getNotOwned() {
        return notOwned;
    }

    public JFormattedTextField getHours() {
        return hours;
    }

    public JRadioButton getSports() {
        return sports;
    }

    public JRadioButton getShooting() {
        return shooting;
    }

    public JRadioButton getAction() {
        return action;
    }

    public JRadioButton getPlatformer() {
        return platformer;
    }

    public JRadioButton getOpenWorld() {
        return openWorld;
    }

    public JRadioButton getRpg() {
        return rpg;
    }
}
