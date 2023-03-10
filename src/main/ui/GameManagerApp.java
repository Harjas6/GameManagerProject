package ui;

import persistence.JsonReader;
import persistence.JsonWriter;
import model.Game;
import model.GameManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Game Manager app
public class GameManagerApp {

    private static final String JSON_STORE = "./data/gameManager.json";
    private GameManager gameList;
    private Scanner scanner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: Runs app
    public GameManagerApp() throws FileNotFoundException {
        runGameManager();
    }

    // MODIFIES: this:
    // EFFECTS: proccesses user input
    private void runGameManager() {
        boolean running = true;
        String input;
        System.out.println("Welcome to the Game Manager!");
        intialize();
        while (running) {
            displayMainMenu();
            input = scanner.nextLine().toLowerCase();

            if (input.equals("q")) {
                running = false;

            } else {
                executeMainMenuInput(input);
            }
        }
        System.out.println("Do you want to save before quitting? [Y/N]");
        input = scanner.nextLine().toLowerCase();
        lastChanceToSave(input);
        scanner.close();
        System.out.println("\nHave a good day!");

    }

    private void lastChanceToSave(String input) {
        if (input.equals("y")) {
            saveGames();
        }
    }

    // MODIFIES: this:
    // EFFECTS: executes user inputs
    private void executeMainMenuInput(String input) {
        if (input.equals("0")) {
            viewList();
        } else if (input.equals("1")) {
            editList();
        } else if (input.equals("2")) {
            sortList();
        } else if (input.equals("3")) {
            underBudgetGames();
        } else if (input.equals("4")) {
            produceStats();
        } else if (input.equals("5")) {
            saveGames();
        } else if (input.equals("6")) {
            loadGames();
        } else {
            System.out.println("Not a valid input");
        }
    }

    //INSPIRED FROM JSON SERIALIZATION DEMO
    // EFFECTS: saves the gameList to file
    private void saveGames() {
        try {
            jsonWriter.open();
            jsonWriter.write(gameList);
            jsonWriter.close();
            System.out.println("Saved games to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // INSPIRED FROM JSON SERIALIZATION DEMO
    // MODIFIES: this
    // EFFECTS: loads gameList from file
    private void loadGames() {
        try {
            gameList = jsonReader.read();
            System.out.println("Loaded games from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: processes user input
    private void produceStats() {
        boolean running = true;
        String input;
        while (running) {
            displayStatsMenu();
            input = scanner.nextLine().toLowerCase();
            if (input.equals("b")) {
                running = false;
            } else {
                executeStatsInput(input);
            }
        }
    }

    // EFFECTS: produces stats based off input
    private void executeStatsInput(String input) {
        if (input.equals("0")) {
            System.out.println(averagePrice());
        } else if (input.equals("1")) {
            System.out.println(averageDifficulty());
        } else if (input.equals("2")) {
            System.out.println(averageHoursPlayed());
        } else {
            System.out.println("Not a valid input");
        }
    }

    // EFFECTS: calculates average price based off input
    private double averagePrice() {
        String input;
        boolean running = true;
        double result = 0;
        System.out.println("Average price of only unowned games? (Y/N)");
        input = scanner.nextLine().toLowerCase();
        while (running) {
            if (input.equals("y")) {
                result = gameList.averageUnownedPrice();
                running = false;
            } else if (input.equals("n")) {
                result = gameList.averagePriceAll();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: calculates average difficulty
    private double averageDifficulty() {
        return gameList.averageDifficulty();
    }

    // EFFECTS: calculates average hours played
    private double averageHoursPlayed() {
        return gameList.averageHours();
    }

    // EFFECTS: displays menu options for stats
    private void displayStatsMenu() {
        System.out.println("Press a number to proceed");
        System.out.println("[0] Average price of unowned games\n[1] "
                + "Average difficulty of games\n[2] Average hours played of games\n[B] Go back");
    }

    // EFFECTS: prodcues unowned games under user defined budget
    private void underBudgetGames() {
        String temp;
        double input;
        System.out.println("What is your budget for buying new games in $?");
        temp = scanner.nextLine();
        input = Double.parseDouble(temp);
        System.out.println(gameList.canBuy(input));
    }

    // MODIFIES: this:
    // EFFECTS: proccesses input to sort list
    private void sortList() {
        String input;
        boolean running = true;
        while (running) {
            displaySortMenu();
            input = scanner.nextLine().toLowerCase();
            if (input.equals("b")) {
                running = false;
            } else {
                executeSortInput(input);
            }
        }
    }

    // MODIFIES: this:
    // EFFECTS: sorts list based off input
    private void executeSortInput(String input) {
        if ("0".equals(input)) {
            sortByName();
        } else if ("1".equals(input)) {
            sortByRank();
        } else if ("2".equals(input)) {
            sortByHoursPlayed();
        } else if ("3".equals(input)) {
            sortByGenre();
        } else if ("4".equals(input)) {
            sortByOwned();
        } else if ("5".equals(input)) {
            sortByDifiiculty();
        } else if ("6".equals(input)) {
            sortByPrice();
        } else {
            System.out.println("Not a valid input");
        }
    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by price
    private void sortByPrice() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort highest price first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByName();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByNameReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();
    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by difficulty
    private void sortByDifiiculty() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort highest difficulty first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByDifficulty();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByDifficultyReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();

    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by if it is owned
    private void sortByOwned() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort owned games first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByOwned();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByOwnedReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();
    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by genre
    private void sortByGenre() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort by genres with the alphabetically first genre"
                    + " in the first position or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByGenre();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByGenreReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();

    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by hours played
    private void sortByHoursPlayed() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort by least hours played first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByHoursPlayed();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByHoursPlayedReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();

    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by ranking
    private void sortByRank() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort highest ranked game first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByRanking();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByRankingReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();
    }

    // MODIFIES: this:
    // EFFECTS: prints out sorted list by name
    private void sortByName() {
        String input;
        boolean running = true;
        while (running) {
            System.out.println("Sort by alphabetically lowest title first or last? (F/L)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("f")) {
                gameList.sortByName();
                running = false;
            } else if (input.equals("l")) {
                gameList.sortByNameReverse();
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        viewList();
    }

    // EFFECTS: prints menu for sorting features
    private void displaySortMenu() {
        System.out.println("Press a number to proceed.");
        System.out.println("[0] Sort by name.\n[1] Sort by rank\n[2] Sort by hours played"
                + "\n[3] Sort by genre\n[4] Sort by owned\n"
                + "[5] Sort by difficulty\n[6] Sort by price\n[B] Go back");
    }


    // MODIFIES: this:
    // EFFECTS: processes inout for editing list features
    private void editList() {
        boolean running = true;
        String input;
        while (running) {
            displayEditMenu();
            input = scanner.nextLine().toLowerCase();
            if (input.equals("b")) {
                running = false;
            } else {
                executeEditListInput(input);
            }
        }
    }

    // MODIFIES: this:
    // EFFECTS: processes user input for editing list features
    private void executeEditListInput(String input) {
        if (input.equals("0")) {
            addGame();
        } else if (input.equals("1")) {
            editGame();
        } else if (input.equals("2")) {
            removeGame();
        } else if (input.equals("3")) {
            clearList();
        } else {
            System.out.println("Not a valid input");
        }
    }

    private void clearList() {
        gameList.clearList();
        System.out.println("List cleared");
    }

    // REQUIRES: user input is an integer whose value is within the list index values
    // MODIFIES: this:
    // EFFECTS: removes game
    private void removeGame() {
        int input;
        String temp;
        viewList();
        System.out.println("What game# would you like to remove? If none press [B]");
        temp = scanner.nextLine();
        if (temp.equals("b")) {
            System.out.println("Canceling removal");
        } else {
            input = Integer.parseInt(temp) - 1;
            gameList.removeGame(input);
            System.out.println("Game removed");
            viewList();
        }
    }

    // MODIFIES: this
    // EFFECTS: edits a games fields
    private void editGame() {
        int input;
        String temp;
        String hoursOrField;
        Game game;
        double changeHoursPlayed;
        System.out.println("What game# would you like to edit?");
        viewList();
        temp = scanner.nextLine();
        input = Integer.parseInt(temp);
        game = gameList.getGame(input);
        System.out.println("[0] Add/subtract to running total of hours played\n[1] Change fields?");
        hoursOrField = scanner.nextLine().toLowerCase();
        if (hoursOrField.equals("0")) {
            System.out.println("Positive number to add, negative to subtract");
            temp = scanner.nextLine();
            changeHoursPlayed = Double.parseDouble(temp);
            game.changeHoursPlayed(changeHoursPlayed);
            System.out.println("Hours have been changed");
        } else if (hoursOrField.equals("1")) {
            editField(game);
        }
    }

    // MODIFIES: this:
    // EFFECTS: edits fields user selects
    private void editField(Game game) {
        boolean name;
        boolean hoursPlayed;
        boolean difficulty;
        boolean ranking;
        boolean genre;
        boolean price;
        boolean owned;
        System.out.println("What fields would you like to edit?");
        name = changeName();
        hoursPlayed = changeHoursPlayed();
        difficulty = changeDifficulty();
        ranking = changeRanking();
        genre = changeGenre();
        price = changePrice();
        owned = changeOwned();
        changeFields(name, hoursPlayed, difficulty, ranking, genre, price, owned, game);
    }

    // MODIFIES: this:
    // EFFECTS: changes fields user selects
    private void changeFields(boolean name, boolean hoursPlayed, boolean difficulty,
                              boolean ranking, boolean genre, boolean price, boolean owned, Game game) {
        if (name) {
            game.editName(userSelectName());
        }
        if (hoursPlayed) {
            game.editHoursPlayed(userSelectHoursPlayed());
        }
        if (difficulty) {
            game.editDifficulty(userSelectDifficulty());
        }
        if (ranking) {
            game.editRanking(userSelectRanking());
        }
        if (genre) {
            game.editGenre(userSelectGenre());
        }
        if (price) {
            game.editPrice(userSelectPrice());
        }
        if (owned) {
            game.changeOwned();
        }
        System.out.println("Fields have been changed");
    }

    // EFFECTS: gets games name off input and returns it
    private String userSelectName() {
        System.out.println("What is the name of the game?");
        return scanner.nextLine();
    }

    // EFFECTS: gets hours plaued  off input and returns it
    private double userSelectHoursPlayed() {
        double hoursPlayed;
        String temp;
        System.out.println("How many hours have you played?");
        temp = scanner.nextLine();
        hoursPlayed = Double.parseDouble(temp);
        return hoursPlayed;
    }

    // EFFECTS: gets difficulty name off input and returns it
    private double userSelectDifficulty() {
        double difficulty;
        String temp;
        System.out.println("How many difficult is this game on a scale of 0-10 (inclusive)?");
        temp = scanner.nextLine();
        difficulty = Double.parseDouble(temp);
        return difficulty;

    }

    // EFFECTS: gets ranking name off input and returns it
    private int userSelectRanking() {
        int ranking;
        String temp;
        System.out.println("What ranking would you give this game (1 being the best game ever)? "
                + "Please use integers only.");
        temp = scanner.nextLine();
        ranking = Integer.parseInt(temp);
        return ranking;
    }

    // EFFECTS: gets price off input and returns it
    private double userSelectPrice() {
        double price;
        String temp;
        System.out.println("What is the price of this game in $");
        temp = scanner.nextLine();
        price = Double.parseDouble(temp);
        return price;
    }

    // EFFECTS: gets if game is owned or not off input and returns it
    private boolean changeOwned() {
        String input;
        boolean running = true;
        boolean result = true;
        while (running) {
            System.out.println("Would you like to change the owned field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: asks user if price should be changed and returns it
    private boolean changePrice() {
        String input;
        boolean running = true;
        boolean result = true;

        while (running) {
            System.out.println("Would you like to change the price field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: asks user if genre should be changed and returns it
    private boolean changeGenre() {
        String input;
        boolean running = true;
        boolean result = true;

        while (running) {
            System.out.println("Would you like to change the genre field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: asks user if ranking should be changed and returns it
    private boolean changeRanking() {
        String input;
        boolean running = true;
        boolean result = true;

        while (running) {
            System.out.println("Would you like to change the ranking field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: asks user if difficulty should be changed and returns it
    private boolean changeDifficulty() {
        String input;
        boolean running = true;
        boolean result = true;

        while (running) {
            System.out.println("Would you like to change the difficulty field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // EFFECTS: asks user if hours played should be changed and returns it
    private boolean changeHoursPlayed() {
        String input;
        boolean running = true;
        boolean result = true;

        while (running) {
            System.out.println("Would you like to change the hours played field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }


    // EFFECTS: asks user if name should be changed and returns it
    private boolean changeName() {
        String input;
        boolean running = true;
        boolean result = true;
        while (running) {
            System.out.println("Would you like to change the name field? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                running = false;
            } else if (input.equals("n")) {
                result = false;
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return result;
    }

    // MODIFIES: this:
    // EFFECTS: adds game to list
    private void addGame() {
        gameList.addGame(makeGame());
    }

    // Makes game based off user input and returns it
    private Game makeGame() {
        String name;
        double hoursPlayed;
        double difficulty;
        int ranking;
        Game.Genre genre;
        double price;
        boolean owned;

        name = userSelectName();
        hoursPlayed = userSelectHoursPlayed();
        difficulty = userSelectDifficulty();
        ranking = userSelectRanking();
        price = userSelectPrice();
        genre = userSelectGenre();
        owned = userSelectOwned();
        System.out.println("Game is added");
        return (new Game(name, hoursPlayed, difficulty, ranking, genre, price, owned));
    }

    // EFFECTS: user picks if game is owned and returns it
    private boolean userSelectOwned() {
        String input;
        boolean owned = false;
        boolean running = true;
        while (running) {
            System.out.println("Is game owned? (Y/N)");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                owned = true;
                running = false;
            } else if (input.equals("n")) {
                running = false;
            } else {
                System.out.println("Not a valid input");
            }
        }
        return owned;
    }

    // REQUIRES: user input to be an integer
    // EFFECTS: user picks game genre and returns it
    private Game.Genre userSelectGenre() {
        Game.Genre genre = null;
        boolean running = true;
        int input;
        String temp;
        while (running) {
            displaySelectGenreMenu();
            temp = scanner.nextLine();
            input = Integer.parseInt(temp);
            if (input > 5 || input < 0) {
                System.out.println("Not a valid input");
            } else {
                genre = proccessGenreSelect(input);
                running = false;
            }
        }
        return genre;
    }

    // EFFECTS: displays select genre menu
    private void displaySelectGenreMenu() {
        System.out.println("Press a number to select a genre for the game.\n");
        System.out.println("[0] Sports Game\n[1] 1st/3rd Person Shooter\n[2] Role-playing Game"
                + "\n[3] Platforming Game\n[4] Action/Adventure Game\n[5] Open-World Game");
    }

    //  picks a genre based off inout and returns it
    private Game.Genre proccessGenreSelect(int input) {
        Game.Genre genre = Game.Genre.SPORT;
        if (input == 0) {
            genre = Game.Genre.SPORT;
        } else if (input == 1) {
            genre = Game.Genre.SHOOTER;
        } else if (input == 2) {
            genre = Game.Genre.RPG;
        } else if (input == 3) {
            genre = Game.Genre.PLATFORMER;
        } else if (input == 4) {
            genre = Game.Genre.ACTADV;
        } else if (input == 5) {
            genre = Game.Genre.OPENWORLD;
        }
        return genre;
    }

    // EFFECTS: displays edit menu
    private void displayEditMenu() {
        System.out.println("Press a number to proceed.");
        System.out.println("[0] Add a game\n[1] Edit a games fields\n[2] Remove a game\n"
                + "[3] Clear list\n[B] Go Back");
    }

    // EFFECTS: prints out current list
    private void viewList() {
        System.out.println(gameList.produceGames());
    }

    // EFFECTS: displays main menu
    private void displayMainMenu() {
        System.out.println("\nPress a number to proceed.");
        System.out.println("[0] View current games in list.\n[1] Edit games in list\n[2] Sort list"
                + "\n[3] Games under budget\n[4] Find statistics\n[5] Save current games in list\n"
                + "[6] Load games from previous file\n[Q] Quit");
    }

    // MODIFIES: this
    // EFFECTS: creates a gamelist and scanner
    private void intialize() {
        gameList = new GameManager();
        scanner = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }
}

