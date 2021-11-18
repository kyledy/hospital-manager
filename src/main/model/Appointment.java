package model;

import org.json.JSONObject;
import persistence.Writable;

// This class represents information on an appointment that was booked by a Patient.
// This class references code from the JSonSerializationDemo project.
public class Appointment implements Writable {
    private String name;
    private String time;

    // An appointment must be booked with the name of a patient, and a certain time
    // constructor
    // EFFECTS: constructs appointment with given name and time
    public Appointment(String name, String time) {
        this.name = name;
        this.time = time;
    }

    // Setter and Getter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public String getTime() {
        return this.time;
    }

    // converts appointment to JSon object
    // EFFECTS: converts given appointment to JSon object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("time", time);
        return json;
    }
}
