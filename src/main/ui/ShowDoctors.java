package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

// This class represents the UI interface of the Doctor class, with the function to display all doctors currently
// employed at the hospital.
public class ShowDoctors extends Doctor {

    // A constructor matching the Doctor superclass
    public ShowDoctors(String doctorName, String department) {
        super(doctorName, department);
    }

    // EFFECTS: Prints the names of all currently employed Doctors to the console
    public static void showAllDoctors() {

        // A list of doctors that is initialized when the method is called to avoid duplicating code in different
        // instances
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Doctor variables are fixed,
        addDoctor(doctors, d1);
        addDoctor(doctors, d2);
        addDoctor(doctors, d3);
        addDoctor(doctors, d4);
        addDoctor(doctors, d5);
        addDoctor(doctors, d6);
        addDoctor(doctors, d7);
        addDoctor(doctors, d8);
        addDoctor(doctors, d9);

        System.out.println("\n");

        // Prints out doctor name, with prefix and department
        // Ex. "Dr. John Doe, Cardiology"
        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }

        continueUsingDoctor();
    }

    // EFFECTS: prompts the user to continue using the program
    public static void continueUsingDoctor() {
        System.out.println("\n");

        System.out.println("1: Return to the Admin homepage");
        System.out.println("2: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                MyHospitalManager.showAdminOptions();
                break;

            case "2":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            case "3":
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsingDoctor();
                break;
        }
    }
}
