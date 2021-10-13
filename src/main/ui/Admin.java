package ui;

import model.CheckIn;
import model.Doctor;
import model.Inquiry;
import model.MedicalRecord;

import java.util.Scanner;

public class Admin {

    // Login credentials are static for user of the program
    public static final String username = "admin";
    public static final String password = "1234";

    // constructor method for Admin class
    public Admin() {
    }

    // EFFECTS: Prompts the user to sign in. If successful, shows a list of all available options for Admin.
    public void login() {
        Scanner next = new Scanner(System.in);
        Admin a = new Admin();

        System.out.println("Please enter your username.");
        String tryUsername = next.nextLine();
        System.out.println("Please enter your password.");
        String tryPassword = next.nextLine();

        if (tryUsername.equals(username) && tryPassword.equals(password)) {
            System.out.println("Welcome, Administrator.");
            System.out.println("\n");
            a.showAdminOptions();

        } else {
            System.out.println("Your username or password is incorrect. Please try again.");
        }
    }

    // EFFECTS: shows all possible options for Admin
    public void showAdminOptions() {
        System.out.println("To view a list of all inquiries, press 1.");
        System.out.println("To view the list of all currently employed doctors, press 2.");
        System.out.println("To view the list of all currently checked-in patients, press 3.");
        System.out.println("To add/view the medical history of a patient, press 4.");
        System.out.println("To exit, press 5.");

        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();
        getAdminChoice(choice);
    }

    // EFFECTS: accesses the corresponding feature based on the choice of the user
    public void getAdminChoice(String choice) {

        switch (choice) {

            case "1":
                Inquiry.showAllInquiries();
                break;

            case "2":
                Doctor.showAllDoctors();
                break;

            case "3":
                CheckIn.showCheckInOptions();
                break;

            case "4":
                MedicalRecord.showMedicalRecordOptions();
                break;

            case "5":
                break;

            default:
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                System.out.println("\n");
                showAdminOptions();
        }
    }

}
