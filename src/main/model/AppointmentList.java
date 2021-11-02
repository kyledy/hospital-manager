package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of Appointments.
public class AppointmentList implements Writable {
    private ArrayList<Appointment> appointments;

    // constructor
    // EFFECTS: constructs an empty list of appointments
    public AppointmentList() {
        appointments = new ArrayList<>();
    }

    // get list of appointments
    // EFFECTS: returns list of appointments
    public List<Appointment> getAppointmentList() {
        return this.appointments;
    }

    // add appointment to list of appointments
    // EFFECTS: adds appointment to list of appointments
    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    // get length of list
    // EFFECTS: returns length of list of appointments
    public int length() {
        return appointments.size();
    }

    // parses the list and converts each appointment to Json
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("appointments", appointmentsToJson());
        return json;
    }

    // EFFECTS: returns medical records in this medical record list as a JSON array
    private JSONArray appointmentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Appointment a : appointments) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }
}
