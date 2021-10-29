package model;

// This class represents information on a patient checked in at the hospital.
public class Patient {

    // A Patient has a name and ID number.
    private String name;
    private int id;

    // constructor
    // EFFECTS: constructs a patient with given name
    //          default value of id is 0
    public Patient(String name) {
        this.name = name;
        this.id = 0;
    }

    // setter and getter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

}
