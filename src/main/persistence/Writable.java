package persistence;

import org.json.JSONObject;


// INSPIRED FROM JSON SERIALIZATION DEMO

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
