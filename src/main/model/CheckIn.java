package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckIn {
    private static ArrayList<Patient> enrolledPatients = new ArrayList<>();

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
    }

    // MODIFIES: enrolledPatients
    // EFFECTS: removes a Patient from the list of enrolledPatients
    public static void checkOutPatient() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the patient you wish to check out.");
        String nameToRemove = myScanner.nextLine();

        for (Patient enrolledPatient : enrolledPatients) {
            if (nameToRemove.equals(enrolledPatient.getPatientName())) {
                enrolledPatients.remove(enrolledPatient);
            }
            System.out.println("Successful!");
            break;
        }
    }

    // EFFECTS: prints all currently checked-in patients to the console, with their name and ID number
    public static void showAllPatients() {
        for (Patient enrolledPatient : enrolledPatients) {
            System.out.println(enrolledPatient.getPatientName() + " , " + enrolledPatient.getPatientID());
        }
    }

    // EFFECTS: shows check-in options for Admin
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
        Admin a = new Admin();

        switch (choice) {
            case "1":
                checkInPatient();
                continueUsing();
                break;
            case "2":
                checkOutPatient();
                continueUsing();
                break;
            case "3":
                showAllPatients();
                continueUsing();
                break;
            case "4":
                a.showAdminOptions();
                break;
            case "5":
                break;
            default:
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                break;
        }
    }

    // EFFECTS: prompts the user to continue using the program, or not
    public static void continueUsing() {
        Admin a = new Admin();

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
                a.showAdminOptions();

            case "3":
                break;

            case "4":
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                continueUsing();
        }
    }
}
