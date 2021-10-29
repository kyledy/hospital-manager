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
        doctors.add(D1);
        doctors.add(D2);
        doctors.add(D3);
        doctors.add(D4);
        doctors.add(D5);
        doctors.add(D6);
        doctors.add(D7);
        doctors.add(D8);
        doctors.add(D9);
    }

    // get list of doctors
    // EFFECTS: returns list of doctors
    public List<Doctor> getDoctorList() {
        return this.doctors;
    }

}
