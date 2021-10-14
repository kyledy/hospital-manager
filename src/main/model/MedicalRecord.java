package model;

import java.util.ArrayList;

// This class represents a Medical Record that can be created by an Admin.
// This class contains the internal framework for the ShowMedicalRecords class.
public class MedicalRecord {

    // A medical record contains information on the patient's name, age, height, weight, and bloodType
    private String name;
    private int age;
    private int height; // in cm
    private int weight; // in kg
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
    // EFFECTS: takes a list of MedicalRecord as a parameter and places MedicalRecord m into that list
    public static void addMedicalRecord(ArrayList<MedicalRecord> patientRecords, MedicalRecord m) {
        patientRecords.add(m);
    }

    // setter and getter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getBloodType() {
        return this.bloodType;
    }

}


