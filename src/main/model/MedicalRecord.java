package model;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicalRecord {
    private static ArrayList<MedicalRecord> patientRecords = new ArrayList<>();
    private String name;
    private int age;
    private int height;
    private int weight;
    private String bloodType;

    // constructor method for MedicalRecord class
    public MedicalRecord(String name, int age, int height, int weight, String bloodType) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
    }

    // MODIFIES: patientRecords
    // EFFECTS: adds a medical record m to the list
    public static void addMedicalRecord(MedicalRecord m) {
        patientRecords.add(m);
    }

    // EFFECTS: returns name of given medical record
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns age of given medical record
    public int getAge() {
        return this.age;
    }

    // EFFECTS: returns height of given medical record (in cm)
    public int getHeight() {
        return this.height;
    }

    // EFFECTS: returns weight of given medical record (in kg)
    public int getWeight() {
        return this.weight;
    }

    // EFFECTS: returns blood type of given medical record
    public String getBloodType() {
        return this.bloodType;
    }

    // EFFECTS: shows options for Medical record manipulation to Admin
    public static void showMedicalRecordOptions() {
        System.out.println("1: Make a new medical record");
        System.out.println("2: Show all medical records");
        System.out.println("3: Return to the Admin homepage");
        System.out.println("4: Exit");
        getChoice();
    }

    // EFFECTS: takes the choice from Admin to access the corresponding feature
    public static void getChoice() {

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        Admin a = new Admin();

        switch (choice) {
            case "1":
                makeMedicalRecord();
                break;
            case "2":
                showAllMedicalRecords();
                break;
            case "3":
                a.showAdminOptions();
                break;
            case "4":
                break;
            case "5":
                System.out.println("Sorry, that wasn't a valid choice.");
                getChoice();
        }
    }

    // MODIFIES: patientRecords
    // EFFECTS: creates a new MedicalRecord object and adds it to m
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

        MedicalRecord m = new MedicalRecord(thisName, thisAge, thisHeight, thisWeight, thisBloodType);
        System.out.println("Successful!");
        addMedicalRecord(m);
        continueUsing();
    }

    // EFFECTS: prints all medical records to console
    public static void showAllMedicalRecords() {
        for (MedicalRecord m : patientRecords) {
            System.out.println("Name: " + m.getName());
            System.out.println("Age: " + m.getAge());
            System.out.println("Height: " + m.getHeight());
            System.out.println("Weight: " + m.getWeight());
            System.out.println("Blood Type: " + m.getBloodType());
            System.out.println("\n");
        }
        continueUsing();
    }

    // EFFECTS: prompts the user if they want to continue / go back to any stage of the program
    public static void continueUsing() {
        System.out.println("\n");
        System.out.println("1: Go back to the Medical record homepage");
        System.out.println("2: Go back to the Admin homepage");
        System.out.println("3: Exit");

        Scanner myScanner = new Scanner(System.in);
        String choice = myScanner.nextLine();

        Admin a = new Admin();

        switch (choice) {
            case "1":
                showMedicalRecordOptions();
                break;
            case "2":
                a.showAdminOptions();
                break;
            case "3":
                break;
            default:
                System.out.println("Sorry, that wasn't a valid choice.");
                continueUsing();
                break;
        }
    }

}


