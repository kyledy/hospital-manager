package ui;

import model.Appointment;
import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

// This class represents the UI portion of the Appointment booking feature.
public class AppointmentBooker extends Appointment {

    // A list of doctors
    static ArrayList<Doctor> doctors;

    // constructor for the class from super
    public AppointmentBooker(String doctorName, String department) {
        super(doctorName, department);
    }

    // EFFECTS: prompts the user to enter their booking details for an appointment, and generates a receipt for them
    public static void bookAppointment() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the patient you wish to book.");
        String tempName = myScanner.nextLine();

        System.out.println("Which doctor would you like to book at appointment with?");

        // shows the list of doctors that the patient can choose
        showDoctorChoices();

        System.out.println("\n");
        String choice = myScanner.nextLine();

        System.out.println("What time would you like your appointment to be? [xxx am/pm]");
        String time = myScanner.nextLine();

        // this code generates the receipt
        System.out.println("You're all set, " + tempName + "!");
        // this section of code calls the helper function getDoctorNameFromChoice, which returns the corresponding
        // name of the doctor from its position in the list
        System.out.println("You have an appointment with " + "Dr. " + getDoctorNameFromChoice(choice) + " at " + time);
        System.out.println("Please print/screenshot this for reference when you go to your appointment.");

        continueUsingAppointment();
    }

    // MODIFIES: doctors
    // EFFECTS: when called, prints out the list of doctors employed at the hospital, with a corresponding number
    //          next to their name
    public static void showDoctorChoices() {

        // Initializing an empty list of doctors to avoid duplicating code
        doctors = new ArrayList<>();

        // d1 through d9 are static variables, which are the doctors currently employed at the hospital
        addDoctor(doctors, d1);
        addDoctor(doctors, d2);
        addDoctor(doctors, d3);
        addDoctor(doctors, d4);
        addDoctor(doctors, d5);
        addDoctor(doctors, d6);
        addDoctor(doctors, d7);
        addDoctor(doctors, d8);
        addDoctor(doctors, d9);

        // this fills an array "doctors" with the names from the static doctor variables found in the Doctor class
        int i = 0;
        for (Doctor d : doctors) {
            i += 1;
            System.out.println(i + ": " + "Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }
        // This function behaves similarly to showAllDoctors() in ShowDoctors in the UI, with the exception that this
        // function shows numbers beside each doctor's name in the order they were printed.
    }


    // EFFECTS: asks the user if they want to continue using the program, and accesses the corresponding features

    // This is the first of many "continue()" methods implemented in this program. The main functionality is that
    // it prompts the user saying if they want to continue, and takes the user back to a certain function if they
    // input the corresponding choice.
    public static void continueUsingAppointment() {
        System.out.println("\n");
        System.out.println("1: Book another appointment");
        System.out.println("2: Go back to the Patient homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                bookAppointment();
                break;

            case "2":
                MyHospitalManager.showPatientOptions();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsingAppointment();
                break;
        }
    }

}
