package ui;

import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

// This class represents information on currently enrolled Patients. It contains information both on the list of
// currently enrolled Patients, but also the functions necessary to check in and out said Patients.
public class CheckIn {

    // A list of enrolled Patients
    private static final ArrayList<Patient> enrolledPatients = new ArrayList<>();

    // EFFECTS: shows all options for the Administrator for the checking in of patients.
    public static void showCheckInOptions() {
        System.out.println("1: Patient check-in");
        System.out.println("2: Patient check-out");
        System.out.println("3: Show all currently checked-in patients");
        System.out.println("4: Return to Admin Homepage");
        System.out.println("5: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();
        getChoice(choice);
    }

    // EFFECTS: takes Admin's choice and uses it to access the corresponding feature
    public static void getChoice(String choice) {

        switch (choice) {
            case "1":
                checkInPatient();
                break;

            case "2":
                checkOutPatient();
                break;

            case "3":
                showAllPatients();
                break;

            case "4":
                MyHospitalManager.showAdminOptions();
                break;

            case "5":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                break;
        }
    }

    // MODIFIES: enrolledPatients
    // EFFECTS: adds a patient to the list of enrolledPatients
    public static void checkInPatient() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the patient you wish to check-in.");
        String tempName = myScanner.nextLine();

        System.out.println("Please enter the ID number of the patient you wish to check-in.");
        int tempID = Integer.parseInt(myScanner.nextLine());

        Patient checkInPatient = new Patient(tempName, tempID);

        enrolledPatients.add(checkInPatient);
        System.out.println("Successful!");

        continueUsingCheckIn();
    }

    // REQUIRES: there are no duplicate names in enrolledPatients
    // MODIFIES: enrolledPatients
    // EFFECTS: removes a Patient from the list of enrolledPatients
    public static void checkOutPatient() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the patient you wish to check out.");
        String nameToRemove = myScanner.nextLine();

        // searches through the list of enrolledPatients to find the patient that matches the "name to remove",
        // then removes it if the name is found
        for (Patient enrolledPatient : enrolledPatients) {
            if (nameToRemove.equals(enrolledPatient.getPatientName())) {
                enrolledPatients.remove(enrolledPatient);
                System.out.println("Successful!");
            } else {
                continue;
            }
            break;
        }

        continueUsingCheckIn();
    }

    // EFFECTS: prints all currently checked-in patients to the console, with their name and ID number. If there are
    // no currently enrolled patients, the console will print that there are none.
    public static void showAllPatients() {
        if (enrolledPatients.size() == 0) {
            System.out.println("There are no currently enrolled patients.");
        } else {
            for (Patient enrolledPatient : enrolledPatients) {
                System.out.println(enrolledPatient.getPatientName() + " , " + enrolledPatient.getPatientID());
            }
        }
        continueUsingCheckIn();
    }

    // EFFECTS: prompts the user to continue using the program, or not
    public static void continueUsingCheckIn() {

        System.out.println("\n");
        System.out.println("1: Return to the Check-in Page");
        System.out.println("2: Return to the Admin Homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                showCheckInOptions();
                break;

            case "2":
                MyHospitalManager.showAdminOptions();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            case "4":
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                continueUsingCheckIn();
                break;
        }
    }
}
