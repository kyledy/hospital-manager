package model;

import model.FrequentlyAskedQuestions;

import java.util.Scanner;

import static jdk.jfr.internal.tool.Main.main;

public class Patient {
    private String patientName;
    private int patientID;

    // constructor method for Patient class
    public Patient(String patientName, int patientID) {
        this.patientName = patientName;
        this.patientID = patientID;
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
        System.out.println("If you wish to exit, press 4.");
        getPatientChoice();
    }

    // EFFECTS: accesses the corresponding feature based on the choice of the user
    public void getPatientChoice() {

        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {

            case "1":
                System.out.println("This feature has not been finished yet.");
                break;

            case "2":
                Inquiry.submitInquiry();
                break;

            case "3":
                FrequentlyAskedQuestions.showFAQ();
                break;

            case "4":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("That wasn't a valid choice. Please try again.");
                System.out.println("\n");
                getPatientChoice();
                break;
        }
    }

}
