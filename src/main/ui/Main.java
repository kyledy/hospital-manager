package ui;

import model.Admin.Admin;
import model.Patient.Patient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to MyHospital! How may I assist you today?");
        System.out.println("\n");

        System.out.println("If you are a Patient, press 1.");
        System.out.println("If you are an Administrator, press 2.");
        System.out.println("If you wish to exit, press 3.");
        getChoice();
    }

    // MODIFIES: p.name
    // EFFECTS:
    // If "1" is selected, new Patient p is initialized and name is set to user's choice. A set of all available
    // options for Patient are then shown to the user.

    // If "2" is selected, new Admin a is initialized and prompts the user to log in using a declared username and
    // password. If login is successful, then all available options for Admin are shown to user.

    // If "3" is selected, the program ends.

    // If "4" is selected, an error message is displayed and the user is prompted to try again.
    public static void getChoice() {
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {
            case "1":
                Patient p = new Patient();

                System.out.println("Please enter your name.");
                String loginName = next.nextLine();
                p.setPatientName(loginName);
                System.out.println("Welcome, " + p.getPatientName() + ". How may I assist you today?");
                System.out.println("\n");
                p.showPatientOptions();
                break;

            case "2":
                Admin a = new Admin();
                a.login();
                break;

            case "3":
                break;

            default:
                System.out.println("Sorry, your choice was invalid. Please try again, or press 3 to exit.");
                getChoice();
        }

    }


}
