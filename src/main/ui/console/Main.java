package ui.console;

import ui.console.GameManagerApp;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new GameManagerApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}