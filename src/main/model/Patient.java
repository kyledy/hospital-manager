package model;

// This class represents information on a Patient in the hospital.
// This class is used in the implementation of the CheckIn class.
public class Patient {

    // A patient consists of their name, and their ID number, with which their name must be unique (among all other
    // Patients)
    private String patientName;
    private int patientID;

    // constructor method for Patient class
    public Patient(String patientName, int patientID) {
        this.patientName = patientName;
        this.patientID = patientID;
    }

    // setter and getter methods
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public int getPatientID() {
        return this.patientID;
    }

}
