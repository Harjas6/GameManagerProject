package ui.gui;

import javax.swing.*;
import java.text.DecimalFormat;

// Class that holds all the  Text Fields for adding a game
public class AddingTextFieldGenerator {

    private JTextField name;
    private JFormattedTextField price;
    private JFormattedTextField difficulty;
    private JFormattedTextField rank;
    private JFormattedTextField hours;


    // EFFECTS: Creates all text fields
    public AddingTextFieldGenerator() {
        initializeFields();
    }

    // EFFECTS: makes text fields
    private void initializeFields() {
        nameField();
        priceField();
        difficultyField();
        rankField();
        hoursField();
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

    public JFormattedTextField getHours() {
        return hours;
    }
}