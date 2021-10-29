package ui;

import model.*;

import java.util.Scanner;

// Hospital Manager application
// This code references the AccountNotRobust project given by the course.
public class HospitalManager {

    // system-wide username and password
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "1234";

    private Scanner input;

    // lists that need to be initialized
    private PatientList pl;
    private MedicalRecordList ml;
    private InquiryList il;
    private DoctorList dl;

    // run the application
    // EFFECTS: runs the hospital management application, if username and password match those given by the system
    public HospitalManager() {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to MyHospitalManager! How may I assist you today?");
        System.out.println("** username: admin **");
        System.out.println("** password: 1234 **");
        System.out.println("\n");

        System.out.println("Please enter your username below.");
        String tryUsername = myScanner.nextLine();

        System.out.println("Please enter your password below.");
        String tryPassword = myScanner.nextLine();

        // login verification
        if (tryUsername.equals(ADMIN_USERNAME) && tryPassword.equals(ADMIN_PASSWORD)) {
            System.out.println("Welcome, Administrator.");
            runHospitalManager();

        } else {
            System.out.println("Your username or password is incorrect. Please try again.");
        }
    }

    // command-line interface
    // MODIFIES: this
    // EFFECTS: processes user input
    public void runHospitalManager() {
        boolean keepGoing = true;
        String command;

        // initialize objects used by the program
        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        // thank you message :)
        System.out.println("\nThank you for using MyHospitalManager!");
    }

    // initialization of variables
    // MODIFIES: this
    // EFFECTS: initializes list of patients and medical records, along with scanner
    public void init() {
        pl = new PatientList();
        ml = new MedicalRecordList();
        il = new InquiryList();
        dl = new DoctorList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // show options
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n");
        System.out.println("\nSelect from:");
        System.out.println("\t1 -> check in patient");
        System.out.println("\t2 -> check out patient");
        System.out.println("\t3 -> show all patients");
        System.out.println("\t4 -> make new medical record");
        System.out.println("\t5 -> show all medical records");
        System.out.println("\t6 -> show all doctors");
        System.out.println("\t7 -> show all inquiries");
        System.out.println("\tq -> quit");
    }

    // process options
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            checkInPatient();
        } else if (command.equals("2")) {
            checkOutPatient();
        } else if (command.equals("3")) {
            showAllPatients();
        } else if (command.equals("4")) {
            makeMedicalRecord();
        } else if (command.equals("5")) {
            showMedicalRecords();
        } else if (command.equals("6")) {
            showDoctors();
        } else if (command.equals("7")) {
            showInquiries();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // check in a patient
    // MODIFIES: p, patients
    // EFFECTS: creates a Patient p with user input, then adds it to list of patients
    private void checkInPatient() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the patient you wish to check in.");
        String tempName = myScanner.nextLine();

        System.out.println("Please enter the ID number of the patient you wish to check in.");
        int tempId = Integer.parseInt(myScanner.nextLine());

        Patient p = new Patient(tempName);
        p.setId(tempId);

        pl.getPatientList().add(p);
        System.out.println("Successful!");
    }

    // check out a patient
    // REQUIRES: patients must have no duplicate names
    // MODIFIES: patients
    // EFFECTS: removes patient with given name from patients
    private void checkOutPatient() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the patient you wish to check out.");
        String toFind = myScanner.nextLine();

        for (Patient p : pl.getPatientList()) {
            if (p.getName().equals(toFind)) {
                pl.getPatientList().remove(p);
                System.out.println("Successful!");
                break;
            }
        }
    }

    // show all patients
    // EFFECTS: prints all patients currently checked in to the console
    private void showAllPatients() {
        for (Patient p : pl.getPatientList()) {
            System.out.println(p.getName() + " , " + p.getId() + "\n");
        }
    }

    // make new medical record
    // MODIFIES: m, medicalRecords
    // creates new medical record m from user input and adds it to list of medical records
    private void makeMedicalRecord() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the patient's name.");
        String tempName = myScanner.nextLine();

        System.out.println("Please enter the patient's age.");
        int tempAge = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's height.");
        int tempHeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's weight.");
        int tempWeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's blood type.");
        String tempBloodType = myScanner.nextLine();

        // constructs a new MedicalRecord object using values obtained from user input
        MedicalRecord m = new MedicalRecord(tempName, tempAge, tempHeight, tempWeight, tempBloodType);

        ml.getMedicalRecordList().add(m);
        System.out.println("Successful!");
    }

    // show medical records
    // EFFECTS: prints all medical records to console
    private void showMedicalRecords() {
        for (MedicalRecord m : ml.getMedicalRecordList()) {
            System.out.println("Name: " + m.getName());
            System.out.println("Age: " + m.getAge());
            System.out.println("Height: " + m.getHeight());
            System.out.println("Weight: " + m.getWeight());
            System.out.println("Blood Type: " + m.getBloodType());
            System.out.println("\n");
        }
    }

    // show doctors
    // EFFECTS: prints all doctors to the console
    private void showDoctors() {
        dl.initDoctors();

        for (Doctor d : dl.getDoctorList()) {
            System.out.println("Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }
    }

    // show inquiries
    // EFFECTS: prints all inquiries to the console
    private void showInquiries() {
        il.initInquiries();

        // Variable j starts indexing at 1, and keeps count of which entry was entered first
        int j = 0;

        for (Inquiry i : il.getInquiryList()) {
            // Variable j starts indexing at 1, and keeps count of which entry was entered first
            j += 1;
            System.out.println(j);
            System.out.println("Subject: " + i.getSubject());
            System.out.println("Date: " + i.getDate());
            System.out.println("Additional Remarks: ");
            System.out.println(i.getRemarks());
            System.out.println("\n");
        }
    }
}

