package model;

import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckIn {
    private static ArrayList<Patient> enrolledPatients = new ArrayList<Patient>();

    public static void checkInPatient(Patient p) {
        enrolledPatients.add(p);
    }

    // TODO: fix this
    public static void checkOutPatient(String name) {
        for (Patient enrolledPatient : enrolledPatients) {
            if (enrolledPatient.getPatientName().equals(name)) {
                enrolledPatients.remove(enrolledPatient);
            }
            break;
        }
    }


    // REQUIRES: enrolledPatients is not empty
    // EFFECTS: returns the Patient at i index in the list
    public Patient getPatient(int i) {
        return enrolledPatients.get(i);
    }

    public static void showAllPatients() {
        for (Patient enrolledPatient : enrolledPatients) {
            System.out.println(enrolledPatient.getPatientName() + " , " + enrolledPatient.getPatientID());
        }
    }

    public static void showCheckInOptions() {
        System.out.println("1: Patient check-in");
        System.out.println("2: Patient check-out");
        System.out.println("3: Show all currently checked-in patients");
        System.out.println("4: Return to Admin Homepage");
        System.out.println("5: Exit");
        getChoice();
    }

    // TODO: after shortening this, run the whole program through checkstyle
    // TODO: shorten this
    public static void getChoice() {
        Admin a = new Admin();

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Please enter the name of the patient you wish to check-in.");
                String tempName = myScanner.nextLine();
                System.out.println("Please enter the ID number of the patient you wish to check-in.");
                int tempID = Integer.parseInt(myScanner.nextLine());
                Patient p = new Patient(tempName, tempID);
                checkInPatient(p);
                System.out.println("Successful!");
                continueUsing();
                break;
            case "2":
                System.out.println("Please enter the name of the patient you wish to check out.");
                String removeName = myScanner.nextLine();
                checkOutPatient(removeName);
                System.out.println("Successful!");
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
            case "6":
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                showCheckInOptions();
                break;
        }
    }

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
