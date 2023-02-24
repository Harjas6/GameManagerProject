package ui;

import model.GameList;

import java.util.Scanner;

public class GameManagerApp {

    private GameList gameList;
    private Scanner scanner;

    public GameManagerApp() {
        runGameManager();
    }

    private void runGameManager() {
        boolean running = true;
        String input = "nothing yet";
        System.out.println("Welcome to the Game Manager!");
        intialize();
        while (running) {
            displayMenu();
        }


    }

    private void displayMenu() {
        System.out.println("Press a number to proceed.");
        System.out.println("[0] View current games in list.\n[1] Edit games in list\n[2] Sort list"
                + "\n[3] Games under budget\n[4] Find statistics\n[Q] Quit");
    }

    private void intialize() {
        gameList = new GameList();
    }
}
