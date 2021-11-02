package model;

import java.util.ArrayList;
import java.util.List;

import static model.Doctor.*;

// This class represents information on a list of doctors.
public class DoctorList {
    private ArrayList<Doctor> doctors;

    // constructor
    // EFFECTS: constructs empty list of doctors
    public DoctorList() {
        doctors = new ArrayList<>();
    }

    // initialize list of doctors
    // MODIFIES: doctors
    // EFFECTS: initializes list of doctors with all doctors currently employed at the hospital
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
    }

    // get list of doctors
    // EFFECTS: returns list of doctors
    public List<Doctor> getDoctorList() {
        return this.doctors;
    }

    // add doctor to list of doctors
    // EFFECTS: adds doctor to list of doctors
    public void addDoctor(Doctor d) {
        doctors.add(d);
    }
}
