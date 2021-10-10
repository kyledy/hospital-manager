package model.Patient;

import java.util.Scanner;

public class Patient {
    private String patientName;
    private int patientID;

    // constructor method for Patient class
    public Patient() {
        patientName = "";
        patientID = 0;
    }

    // MODIFIES: patientName
    // EFFECTS: sets the value of patientName
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // MODIFIES: patientID
    // EFFECTS: sets the value of patientID
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    // EFFECTS: returns selected patient's name
    public String getPatientName() {
        return this.patientName;
    }

    // EFFECTS: returns selected patient's ID number
    public int getPatientID() {
        return this.patientID;
    }

    // EFFECTS: shows all options available to Patient
    public void showPatientOptions() {
        System.out.println("To book an appointment, press 1.");
        System.out.println("To submit an inquiry to the help desk, press 2.");
        System.out.println("To access the FAQ page, press 3.");

        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();
        getPatientChoice(choice);
    }

    // EFFECTS: accesses the corresponding feature based on the choice of the user
    public void getPatientChoice(String choice) {
        System.out.println(choice);
    }

}
