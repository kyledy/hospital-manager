package ui;

import java.util.Scanner;

// This class represents the main application interface of the program, which is run by Main.
public class MyHospitalManager {

    // When the class is called in main, it displays the main menu to the user.
    // constructor for the MyHospitalManager class
    public MyHospitalManager() {
        mainMenu();
    }

    // EFFECTS: displays the main menu to the user
    public void mainMenu() {
        // This class prompts the user to sign in as either Admin or Patient, to access the corresponding features

        System.out.println("Welcome to MyHospital! How may I assist you today?");
        System.out.println("** FOR ADMIN USE ONLY: Username is admin, password is 1234 ** ");
        System.out.println("\n");

        System.out.println("If you are a Patient, press 1.");
        System.out.println("If you are an Administrator, press 2.");
        System.out.println("If you wish to exit, press 3.");
        System.out.println("\n");

        choosePermissions();
    }

    // EFFECTS: Brings the user to the next stage of the interface, greeting them as a Patient or Administrator
    // depending on what they chose
    public void choosePermissions() {
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {
            case "1":
                greetPatient();
                break;

            case "2":
                greetAdmin();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("Sorry, your choice was invalid. Please try again, or press 3 to exit.");
                choosePermissions();
                break;
        }
    }

    // EFFECTS: greets the user by their inputted name on the system and prompts them to select from a menu of options
    // for Patient
    public void greetPatient() {
        Scanner next = new Scanner(System.in);

        System.out.println("Please enter your name.");
        String myName = next.nextLine();
        System.out.println("\n");
        System.out.println("Why hello, " + myName + "! How may I assist you today?");
        System.out.println("\n");
        showPatientOptions();
    }

    // EFFECTS: generates a simple login system for the user using a system-specific username and password, then
    // prompts the user to a list of options for Administrator if successful
    public void greetAdmin() {

        String username = "admin";
        String password = "1234";
        Scanner next = new Scanner(System.in);

        System.out.println("Please enter your username.");
        String tryUsername = next.nextLine();
        System.out.println("Please enter your password.");
        String tryPassword = next.nextLine();

        // simple login system
        if (tryUsername.equals(username) && tryPassword.equals(password)) {
            System.out.println("Welcome, Administrator.");
            System.out.println("\n");
            showAdminOptions();

        } else {
            System.out.println("Your username or password is incorrect. Please try again.");
        }
    }

    // EFFECTS: shows the Patient a list of their options/features that they can use
    public static void showPatientOptions() {
        System.out.println("To book an appointment, press 1.");
        System.out.println("To submit an inquiry to the help desk, press 2.");
        System.out.println("To access the FAQ page, press 3.");
        System.out.println("If you wish to exit, press 4.");

        getPatientChoice();
    }

    // EFFECTS: takes the users' choice from the previous method call and accesses the corresponding feature
    public static void getPatientChoice() {
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {

            // Accesses the appointment booking feature
            case "1":
                AppointmentBooker.bookAppointment();
                break;

            // Accesses the inquiry submission feature
            case "2":
                UserInquiry.submitInquiry();
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

    // EFFECTS: shows the Administrator a list of their options/features that they can use
    public static void showAdminOptions() {
        System.out.println("To view a list of all inquiries, press 1.");
        System.out.println("To view the list of all currently employed doctors, press 2.");
        System.out.println("To view the list of all currently checked-in patients, press 3.");
        System.out.println("To add/view the medical history of a patient, press 4.");
        System.out.println("To exit, press 5.");

        getAdminChoice();
    }

    // EFFECTS: takes the users' choice from the previous method call and accesses the corresponding feature
    public static void getAdminChoice() {
        Scanner next = new Scanner(System.in);
        String choice = next.nextLine();

        switch (choice) {

            // Displays the list of all inquiries made to the help desk
            case "1":
                UserInquiry.showAllInquiries();
                break;

            // Shows the list of all doctors currently employed at the hospital
            case "2":
                ShowDoctors.showAllDoctors();
                break;

            // Accesses the Check-in page
            case "3":
                CheckIn.showCheckInOptions();
                break;

            // Accesses the MedicalRecord page
            case "4":
                ShowMedicalRecords.showMedicalRecordOptions();
                break;

            // Simple thank-you message for using the program
            case "5":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            // If invalid input is selected, user will be prompted to try again
            default:
                System.out.println("Sorry, that wasn't a valid choice. Please try again.");
                getAdminChoice();
                break;
        }
    }
}

