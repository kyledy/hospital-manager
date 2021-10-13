package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor {
    String doctorName;
    String department;
    static ArrayList<Doctor> doctors = new ArrayList<>();

    // The variables for doctors at this hospital are static
    static final Doctor d1 = new Doctor("Cain Schmidt", "Cardiology");
    static final Doctor d2 = new Doctor("Toni O'Brien", "Pediatrics");
    static final Doctor d3 = new Doctor("Katie Short", "Oncology");
    static final Doctor d4 = new Doctor("Hayley Archer", "Kinesiology");
    static final Doctor d5 = new Doctor("Trent Hartley", "Urology");
    static final Doctor d6 = new Doctor("Rumaysa Meza", "Radiology");
    static final Doctor d7 = new Doctor("Kaylee Neale", "Neurology");
    static final Doctor d8 = new Doctor("Ashley Daugherty", "Pharmacy");
    static final Doctor d9 = new Doctor("Ronan Hawkins", "Pathology");

    // constructor for the doctor class
    public Doctor(String doctorName, String department) {
        this.doctorName = doctorName;
        this.department = department;
    }

    // MODIFIES: doctors
    // EFFECTS: adds Doctor to list doctors
    public static void addDoctor(Doctor d) {
        doctors.add(d);
    }

    // EFFECTS: returns the doctorName of this
    public String getDoctorName() {
        return this.doctorName;
    }

    // EFFECTS: returns the department of this
    public String getDepartment() {
        return this.department;
    }

    // EFFECTS: prints the names of all doctors in the list
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

        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }

        continueUsing();
    }

    // EFFECTS: prompts the user to continue using the program
    public static void continueUsing() {
        System.out.println("\n");

        System.out.println("1: Return to the Admin homepage");
        System.out.println("2: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        Admin a = new Admin();

        switch (choice) {
            case "1":
                a.showAdminOptions();
                break;
            case "2":
                break;
            case "3":
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsing();
        }
    }
}


