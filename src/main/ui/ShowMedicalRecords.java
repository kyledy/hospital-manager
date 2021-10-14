package ui;

import model.MedicalRecord;

import java.util.ArrayList;
import java.util.Scanner;

// This class represents the UI portion of the MedicalRecord class. It lets the user make a new MedicalRecord, and
// show all MedicalRecords contained in the system.
public class ShowMedicalRecords extends MedicalRecord {

    // A list of medical records held by the hospital
    private static final ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    // constructor matching MedicalRecord superclass
    public ShowMedicalRecords(String name, int age, int height, int weight, String bloodType) {
        super(name, age, height, weight, bloodType);
    }

    // EFFECTS: shows all options for Administrator for the medical record manipulation feature
    public static void showMedicalRecordOptions() {
        System.out.println("1: Make a new medical record");
        System.out.println("2: Show all medical records");
        System.out.println("3: Return to the Admin homepage");
        System.out.println("4: Exit");
        getChoice();
    }

    // EFFECTS: takes the input from the previous method call and accesses the corresponding feature
    public static void getChoice() {

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                makeMedicalRecord();
                break;

            case "2":
                showAllMedicalRecords();
                break;

            case "3":
                MyHospitalManager.showAdminOptions();
                break;

            case "4":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            case "5":
                System.out.println("Sorry, that wasn't a valid choice.");
                getChoice();
                break;
        }
    }

    // MODIFIES: m, medicalRecords
    // EFFECTS: creates a new MedicalRecord m based on user input and adds it to the list of MedicalRecords
    public static void makeMedicalRecord() {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the patient's name");
        String thisName = myScanner.nextLine();

        System.out.println("Please enter the patient's age");
        int thisAge = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's height");
        int thisHeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's weight");
        int thisWeight = Integer.parseInt(myScanner.nextLine());

        System.out.println("Please enter the patient's blood type");
        String thisBloodType = myScanner.nextLine();

        // constructs a new MedicalRecord object using values obtained from user input
        MedicalRecord m = new MedicalRecord(thisName, thisAge, thisHeight, thisWeight, thisBloodType);

        System.out.println("Successful!");

        // adds it to the list of all known MedicalRecords
        addMedicalRecord(medicalRecords, m);

        // prompts the user if they want to continue
        continueUsingMedicalRecord();
    }

    // EFFECTS: prints all medicalRecords from the system to console
    public static void showAllMedicalRecords() {
        for (MedicalRecord m : medicalRecords) {
            System.out.println("Name: " + m.getName());
            System.out.println("Age: " + m.getAge());
            System.out.println("Height: " + m.getHeight());
            System.out.println("Weight: " + m.getWeight());
            System.out.println("Blood Type: " + m.getBloodType());
            System.out.println("\n");
        }
        continueUsingMedicalRecord();
    }

    // EFFECTS: prompts the user if they want to continue using the program or some other part
    public static void continueUsingMedicalRecord() {
        System.out.println("\n");
        System.out.println("1: Go back to the Medical record homepage");
        System.out.println("2: Go back to the Admin homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        switch (choice) {

            case "1":
                showMedicalRecordOptions();
                break;

            case "2":
                MyHospitalManager.showAdminOptions();
                break;

            case "3":
                System.out.println("Thank you for using MyHospitalManager!");
                break;

            default:
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsingMedicalRecord();
                break;
        }
    }


}
