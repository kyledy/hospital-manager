package model;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of patients.
public class PatientList {
    private ArrayList<Patient> patients;

    // constructor
    // EFFECTS: constructs an empty list of patients
    public PatientList() {
        patients = new ArrayList<>();
    }

    // get list of patients
    // EFFECTS: returns a list of patients
    public List<Patient> getPatientList() {
        return this.patients;
    }

    // get length of list of patients
    // EFFECTS: returns the length of the list of patients
    public int length() {
        return patients.size();
    }
}
