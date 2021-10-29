package persistence;

import org.json.JSONObject;

// This interface references code from the JSonSerialization demo project given by the course.
// This interface represents a part of the program that may be persisted/saved through a JSon file
public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
