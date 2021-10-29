package model;

// This class represents information on a medical record that can be filed by hospital staff.
public class MedicalRecord {

    // contains information on the patient's name, age, height, weight, and bloodType
    private String name;
    private int age;
    private int height; // in cm
    private int weight; // in kg
    private String bloodType;

    // constructor
    // EFFECTS: constructs a medical record with given name, age, height, weight, and blood type
    public MedicalRecord(String name, int age, int height, int weight, String bloodType) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
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
