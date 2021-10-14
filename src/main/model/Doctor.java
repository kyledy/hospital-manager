package model;

import java.util.ArrayList;

// This class represents information on Doctors that are currently employed at the hospital, which is used by the
// AppointmentBooker and ShowDoctors classes.
public class Doctor {
    // A doctor is defined as having a name, and department
    String doctorName;
    String department;

    // The values for doctors at this hospital are final
    public static final Doctor d1 = new Doctor("Cain Schmidt", "Cardiology");
    public static final Doctor d2 = new Doctor("Toni O'Brien", "Pediatrics");
    public static final Doctor d3 = new Doctor("Katie Short", "Oncology");
    public static final Doctor d4 = new Doctor("Hayley Archer", "Kinesiology");
    public static final Doctor d5 = new Doctor("Trent Hartley", "Urology");
    public static final Doctor d6 = new Doctor("Owen Hart", "Radiology");
    public static final Doctor d7 = new Doctor("Kaylee Neale", "Neurology");
    public static final Doctor d8 = new Doctor("Ashley Daugherty", "Pharmacy");
    public static final Doctor d9 = new Doctor("Ronan Hawkins", "Pathology");

    // constructor for the doctor class
    public Doctor(String doctorName, String department) {
        this.doctorName = doctorName;
        this.department = department;
    }

    // MODIFIES: doctors
    // EFFECTS: Takes a list of doctors as a parameter, and places doctor d into the list
    public static void addDoctor(ArrayList<Doctor> doctors, Doctor d) {
        doctors.add(d);
    }

    // setter and getter methods
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public String getDepartment() {
        return this.department;
    }

}


