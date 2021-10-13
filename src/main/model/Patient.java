package model;

import java.util.Scanner;

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

            // Accesses the appointment booking feature
            case "1":
                BookAppointment.bookAppointment();
                break;

            // Accesses the inquiry submission feature
            case "2":
                Inquiry.submitInquiry();
                break;

            // Accesses the FAQ page
            case "3":
                FrequentlyAskedQuestions.showFAQ();
                break;

            // Prints a simple thank-you message when user exits the program
            case "4":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            // If any other input is selected, the user will be taken back to the option page
            default:
                System.out.println("That wasn't a valid choice. Please try again.");
                System.out.println("\n");
                getPatientChoice();
                break;
        }
    }

}
