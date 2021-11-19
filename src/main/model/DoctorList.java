package model;

import java.util.ArrayList;
import java.util.List;

import static model.Doctor.*;

// This class represents information on a list of doctors.
// This code references the AlarmSystem code given by the course.
public class DoctorList {
    private ArrayList<Doctor> doctors;

    // constructor
    // EFFECTS: constructs empty list of doctors
    public DoctorList() {
        doctors = new ArrayList<>();
    }

    // initialize list of doctors
    // MODIFIES: doctors
    // EFFECTS: initializes list of doctors with all doctors currently employed at the hospital, and logs the event
    public void initDoctors() {
        addDoctor(D1);
        addDoctor(D2);
        addDoctor(D3);
        addDoctor(D4);
        addDoctor(D5);
        addDoctor(D6);
        addDoctor(D7);
        addDoctor(D8);
        addDoctor(D9);
        EventLog.getInstance().logEvent(new Event("List of doctors has been initialized with final "
                + "variables."));
    }

    // get list of doctors
    // EFFECTS: returns list of doctors
    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    // add doctor to list of doctors
    // EFFECTS: adds doctor to list of doctors, and logs the event
    public void addDoctor(Doctor d) {
        doctors.add(d);
        EventLog.getInstance().logEvent(new Event("Doctor has been added to list of doctors."));
    }
}
