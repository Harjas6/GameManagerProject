package model;

// Game is representative of a real-life game, with fields representing individuals
// facets of/about the game. Name represents the title of the Game,
// hoursPlayed representing the amount of hours the user has played - must be >= 0
// difficulty represents the users perceived difficulty of the game between [0,10]
// ranking represents where the user would rank the game according to personal prefernce
// this must be > 0, can have identical ranking to convey a tie
// genre represents what genre the game belongs in from predetermined constants
// price represent current price of game >= 0
// owned is true if user owns game false otherwise

public class Game {

    private String name;
    private double hoursPlayed;
    private double difficulty;
    private int ranking;
    private Genre genre;
    private double price;
    private boolean owned;

    // MODIFIES: this
    // EFFECTS: creates game with each parameter being assignemed to its matching field.
    public Game(String name, double hoursPlayed, int difficulty, int ranking,
                Genre genre, double price, boolean owned) {
        this.name = name;
        this.hoursPlayed = hoursPlayed;
        this.difficulty = difficulty;
        this.ranking = ranking;
        this.genre = genre;
        this.price = price;
        this.owned = owned;
    }

    // REQUIRES: hoursPlayed + i is >= 0
    // MODIFIES: this
    // EFFECTS: Changes the number of hours owned by i
    public boolean changeHoursPlayed(double i) {
        if ((this.hoursPlayed += i) >= 0) {
            return true;
        }
        this.hoursPlayed -= i;
        return false;
    }

    // REQUIRES: price + i >= 0
    // MODIFIES: this
    // EFFECTS: Changes the price by i as long as the change does
    // not allow price to fall below zero
    public boolean changePrice(double i) {
        if ((this.price += i) >= 0) {
            return true;
        }
        this.price -= i;
        return false;
    }

    public String getName() {
        return name;
    }

    // REQUIRES: name to be at least one character
    // MODIFIES: this
    // EFFECTS: changes name of game
    public void editName(String name) {
        this.name = name;
    }

    public double getHoursPlayed() {
        return hoursPlayed;
    }

    // REQUIRES: hoursPlayed to be > 0
    // MODIFIES: this
    // EFFECTS: Changes games hours played
    public void editHoursPlayed(double hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public double getDifficulty() {
        return difficulty;
    }

    // REQUIRES: difficulty is between a number [0,10]
    // MODIFIES: this
    // EFFECTS: Changes difficulty level
    public void editDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getRanking() {
        return ranking;
    }

    // REQUIRES: ranking > 0
    // MODIFIES: this
    // EFFECTS: Changes games ranking to ranking
    public void editRanking(int ranking) {
        this.ranking = ranking;
    }

    public Genre getGenre() {
        return genre;
    }

    // MODIFIES: this
    // EFFECTS: Changes games genre to genre
    public void editGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    // REQUIRES: price >= 0
    // MODIFIES: this
    // EFFECTS: Changes games price to price
    public void editPrice(double price) {
        this.price = price;
    }

    public boolean isOwned() {
        return owned;
    }

    // MODIFIES: this
    // EFFECTS: FLips current owned value t0 the opposite
    public void changeOwned() {
        this.owned = !this.owned;
    }

    public enum Genre {
        SPORT {
            @Override
            public String toString() {
                return "Sports Game";
            }
        },
        SHOOTER {
            @Override
            public String toString() {
                return "1st/3rd Person Shooter";
            }
        },
        RPG {
            @Override
            public String toString() {
                return "Role-playing Game";
            }
        },
        PLATFORMER {
            @Override
            public String toString() {
                return "Platforming Game";
            }
        },
        ACTADV {
            @Override
            public String toString() {
                return "Action/Adventure Game";
            }
        },
        OPENWORLD {
            @Override
            public String toString() {
                return "Open-World Game";
            }
        }
    }
}
