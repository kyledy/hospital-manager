package model;

import java.util.Scanner;

public class BookAppointment extends Doctor {

    // constructor from Doctor superclass
    public BookAppointment(String doctorName, String department) {
        super(doctorName, department);
    }

    // EFFECTS: prompts the user to select a doctor and appointment time, and then returns a receipt
    public static void bookAppointment() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please re-enter your name.");
        String tempName = myScanner.nextLine();

        System.out.println("Which doctor would you like to book at appointment with?");
        showAllDoctors();
        System.out.println("\n");
        String choice = myScanner.nextLine();
        System.out.println("What time would you like your appointment to be? [xxx am/pm]");
        String time = myScanner.nextLine();

        System.out.println("You're all set, " + tempName + "!");
        System.out.println("You have an appointment with " + "Dr. " + getDoctorNameFromChoice(choice) + " at " + time);
        System.out.println("Please print/screenshot this for reference when you go to your appointment.");

        continueUsingAppointment();
    }

    // EFFECTS: prints out the list of doctors employed at the hospital, with a corresponding number next to their name
    public static void showAllDoctors() {
        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        doctors.add(d4);
        doctors.add(d5);
        doctors.add(d6);
        doctors.add(d7);
        doctors.add(d8);
        doctors.add(d9);

        int i = 0;
        for (Doctor d : doctors) {
            i += 1;
            System.out.println(i + ": " + "Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }
    }

    // EFFECTS: returns the name of a given doctor based on the user's choice
    public static String getDoctorNameFromChoice(String choice) {
        switch (choice) {
            case "1":
                return "Dr. Cain Schmidt";
            case "2":
                return "Dr. Toni O' Brien";
            case "3":
                return "Katie Short";
            case "4":
                return "Hayley Archer";
            case "5":
                return "Trent Hartley";
            case "6":
                return "Rumaysa Meza";
            case "7":
                return "Kaylee Neale";
            case "8":
                return "Ashley Daugherty";
            case "9":
                return "Ronan Hawkins";
            default:
                return "Imaginary";
        }
    }

    // EFFECTS: prompts the user to continue using the program
    public static void continueUsingAppointment() {
        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        System.out.println("\n");
        System.out.println("1: Book another appointment");
        System.out.println("2: Go back to the Patient homepage");
        System.out.println("3: Exit");

        Patient p = new Patient("", 0);

        switch (choice) {
            case "1":
                bookAppointment();
                break;
            case "2":
                p.showPatientOptions();
                break;
            case "3":
                break;
            default:
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsing();
        }
    }
}
