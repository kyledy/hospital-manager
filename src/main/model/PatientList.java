package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of patients.
// This class references code from the JSonSerializationDemo project.
public class PatientList implements Writable {
    private ArrayList<Patient> patients;

    // constructor
    // EFFECTS: constructs an empty list of patients
    public PatientList() {
        patients = new ArrayList<>();
    }

    // get list of patients
    // EFFECTS: returns a list of patients
    public List<Patient> getPatients() {
        return this.patients;
    }

    // add patient to list of patients
    // EFFECTS: adds patient p to list of patients
    public void addPatient(Patient p) {
        patients.add(p);
    }

    // get length of list
    // EFFECTS: returns length of list of patients
    public int length() {
        return patients.size();
    }

    // parses the list and converts each patient to Json
    // EFFECTS: for each patient in the list, converts it to JSonObject and returns i t
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("patients", patientsToJson());
        return json;
    }

    // EFFECTS: returns medical records in this medical record list as a JSON array
    private JSONArray patientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Patient p : patients) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
