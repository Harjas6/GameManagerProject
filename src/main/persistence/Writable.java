package persistence;

import org.json.JSONObject;


// INSPIRED/MODELLED FROM JSON SERIALIZATION DEMO

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
