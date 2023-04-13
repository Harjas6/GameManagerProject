package ui.console;

import java.io.FileNotFoundException;

public class MainConsole {
    public static void main(String[] args) {
        try {
            new ConsoleGameManagerApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}