package model;

// Game is representative of a real-life game, with fields representing individuals
// facets of/about the game.
public class Game {

    public enum Genre {
        SPORT(0) {
            @Override
            public String toString() {
                return "Sports Game";
            }
        },
        SHOOTER(2) {
            @Override
            public String toString() {
                return "1st/3rd Person Shooter";
            }
        },
        RPG(2) {
            @Override
            public String toString() {
                return "Role-playing Game";
            }
        },
        PLATFORMER(3) {
            @Override
            public String toString() {
                return "Platforming Game";
            }
        },
        ACTADV(4) {
            @Override
            public String toString() {
                return "Action/Adventure Game";
            }
        },
        OPENWORLD(5) {
            @Override
            public String toString() {
                return "Open-World Game";
            }
        };

        private final int num;

        Genre(int i) {
            this.num = i;
        }

        public static Genre getGenre(int i) {
            for (Genre genre : Genre.values()) {
                if (i == genre.num) {
                    return genre;
                }
            }
            throw new IllegalArgumentException("Please use one of the specified numbers");
        }

    }


    private String name;
    private double hoursPlayed;
    private double difficulty;
    private int ranking;
    private Genre genre;
    private double price;
    private boolean owned;

    // MODIFIES: this
    // EFFECTS: creates game with given inputs
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
    public void setName(String name) {
        this.name = name;
    }

    public double getHoursPlayed() {
        return hoursPlayed;
    }

    // REQUIRES: hoursPlayed to be > 0
    // MODIFIES: this
    // EFFECTS: Changes games hours played
    public void setHoursPlayed(double hoursPlayed) {
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
    // EFFECTS: Chnages games ranking
    public void editRanking(int ranking) {
        this.ranking = ranking;
    }

    public Genre getGenre() {
        return genre;
    }


    // MODIFIES: this
    // EFFECTS: Chnages games genre
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    // REQUIRES : price >= 0
    // MODIFIES: this
    // EFFECTS: Chnages games price
    public void editPrice(double price) {
        this.price = price;
    }

    public boolean isOwned() {
        return owned;
    }

    // MODIFIES: this
    // EFFECTS: Chnages games owned value
    public void changeOwned() {
        if (this.owned) {
            this.owned = false;
        } else {
            this.owned = true;
        }
    }
}
