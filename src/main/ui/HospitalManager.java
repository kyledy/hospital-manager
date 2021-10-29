package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Hospital Manager application
// This code references the AccountNotRobust and JSONSerialization demo projects given by the course.
public class HospitalManager {
    private static final String JSON_STORE = "./data/medicalrecords.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // system-wide username and password
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "1234";

    private Scanner input;

    // lists that need to be initialized
    private PatientList pl;
    private MedicalRecordList ml;
    private InquiryList il;
    private DoctorList dl;
    private AppointmentList al;

    // run the application
    // EFFECTS: runs the hospital management application, if username and password match those given by the system
    public HospitalManager() throws FileNotFoundException {

        // initializes JSON writer and JSON reader
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

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
        al = new AppointmentList();
        il.initInquiries();
        dl.initDoctors();
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
        System.out.println("\t6 -> book an appointment");
        System.out.println("\t7 -> remove an appointment");
        System.out.println("\t8 -> show all appointments");
        System.out.println("\t9 -> show all doctors");
        System.out.println("\t10 -> show all inquiries");
        // This saves all currently checked-in patients, medical records, and appointments to file
        System.out.println("\t11 -> save medical records to file");
        // This loads all previously checked-in patients, medical records, and appointments to file
        System.out.println("\t12 -> load medical records from file");
        System.out.println("\tq -> quit");
    }

    // Checkstyle was suppressed here because there was no better way of implementing all features of the program
    // process options
    // MODIFIES: this
    // EFFECTS: processes user command
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void processCommand(String command) {
        if (command.equals("1")) {
            // check in a patient
            checkInPatient();
        } else if (command.equals("2")) {
            // check out a patient
            checkOutPatient();
        } else if (command.equals("3")) {
            // show all patients
            showAllPatients();
        } else if (command.equals("4")) {
            // make a new medical record
            makeMedicalRecord();
        } else if (command.equals("5")) {
            // show all medical records
            showMedicalRecords();
        } else if (command.equals("6")) {
            // book an appointment for a patient
            bookAppointment();
        } else if (command.equals("7")) {
            // remove an appointment from the list of booked appointments
            removeAppointment();
        } else if (command.equals("8")) {
            // show all booked appointments
            showAllAppointments();
        } else if (command.equals("9")) {
            // show all doctors
            showDoctors();
        } else if (command.equals("10")) {
            // show all inquiries
            showInquiries();
        } else if (command.equals("11")) {
            // save medical records to file
            saveMedicalRecords();
        } else if (command.equals("12")) {
            // load medical records from file
            loadMedicalRecords();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // check in a patient
    // MODIFIES: this, patients
    // EFFECTS: creates a Patient p with user input, then adds it to list of patients
    private void checkInPatient() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the patient you wish to check in.");
        String tempName = myScanner.nextLine();

        System.out.println("Please enter the ID number of the patient you wish to check in.");
        int tempId = Integer.parseInt(myScanner.nextLine());

        // initializes the patient
        Patient p = new Patient(tempName);
        p.setId(tempId);

        // adds patient to list of patients
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
    // MODIFIES: this, medicalRecords
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

        // adds medical record to list of medical records
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

    // book an appointment
    // MODIFIES: this, appointments
    // EFFECTS: creates new appointment a from user input and adds it to list of appointments
    private void bookAppointment() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the patient you wish to book.");
        String tempName = myScanner.nextLine();

        System.out.println("Please enter the time you wish to have your appointment. [XXX am/pm]");
        String tempTime = myScanner.nextLine();

        // constructs new Appointment from user input
        Appointment a = new Appointment(tempName, tempTime);

        // adds appointment to list of booked appointments
        al.getAppointmentList().add(a);
        System.out.println("Successful!");
    }

    // show all appointments
    // EFFECTS: prints all appointments to console
    private void showAllAppointments() {
        for (Appointment a : al.getAppointmentList()) {
            System.out.println(a.getName());
            System.out.println(a.getTime());
        }
    }

    // remove an appointment
    // REQUIRES: appointments must have no duplicate names
    // MODIFIES: appointments
    // EFFECTS: removes appointment with given name from appointment
    private void removeAppointment() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the name of the appointment you wish to remove.");
        String toFind = myScanner.nextLine();

        for (Appointment a : al.getAppointmentList()) {
            if (a.getName().equals(toFind)) {
                al.getAppointmentList().remove(a);
                System.out.println("Successful!");
                break;
            }
        }
    }

    // show doctors
    // EFFECTS: prints all doctors to the console
    private void showDoctors() {
        for (Doctor d : dl.getDoctorList()) {
            System.out.println("Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }
    }

    // show inquiries
    // EFFECTS: prints all inquiries to the console
    private void showInquiries() {
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

    // EFFECTS: saves the current state of program to file
    private void saveMedicalRecords() {
        try {
            jsonWriter.open();
            jsonWriter.writeMedicalRecordList(ml);
            jsonWriter.close();
            System.out.println("Saved medical records to " + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads previous state of program from file
    private void loadMedicalRecords() {
        try {
            ml = jsonReader.readMedicalRecordList();
            System.out.println("Loaded medical records from " + JSON_STORE);

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

