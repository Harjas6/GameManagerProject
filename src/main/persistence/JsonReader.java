package persistence;


import model.Game;
import model.Game.Genre;
import model.GameManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// INSPIRED/MODELLED FROM JSON SERIALIZATION DEMO

// Represents a reader that reads GameManager from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads GameManager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GameManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGameManager(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses GameManager from JSON object and returns it
    private GameManager parseGameManager(JSONObject jsonObject) {
        GameManager gm = new GameManager();
        addGames(gm, jsonObject);
        return gm;
    }

    // MODIFIES: gm
    // EFFECTS: parses games from JSON object and adds them to GameManager
    private void addGames(GameManager gm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("games");
        for (Object json : jsonArray) {
            JSONObject nextGame = (JSONObject) json;
            addGame(gm, nextGame);
        }
    }

    // MODIFIES: gm
    // EFFECTS: parses Game from JSON object and adds it to GameManager
    private void addGame(GameManager gm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double hoursPlayed = jsonObject.getDouble("hours");
        double difficulty = jsonObject.getDouble("difficulty");
        int ranking = jsonObject.getInt("ranking");
        Genre genre = Genre.valueOf(jsonObject.getString("genre"));
        double price = jsonObject.getDouble("price");
        boolean owned = jsonObject.getBoolean("owned");
        Game game = new Game(name, hoursPlayed, difficulty, ranking, genre, price, owned);
        gm.addGame(game);
    }
}
