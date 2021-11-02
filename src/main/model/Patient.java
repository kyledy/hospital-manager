package model;

import org.json.JSONObject;
import persistence.Writable;

// This class represents information on a patient checked in at the hospital.
public class Patient implements Writable {

    // A Patient has a name and ID number.
    private String name;
    private int id;

    // constructor
    // EFFECTS: constructs a patient with given name
    //          default value of id is 0
    public Patient(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    // Setter and Getter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    // converts patient to JSon object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("id", id);
        return json;
    }
}
