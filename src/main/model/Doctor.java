package model;

import java.util.ArrayList;

public class Doctor {
    String doctorName;
    String department;
    private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    // The variables for doctors at this hospital are static
    private static final Doctor d1 = new Doctor("Cain Schmidt", "Cardiology");
    private static final Doctor d2 = new Doctor("Toni O'Brien", "Pediatrics");
    private static final Doctor d3 = new Doctor("Katie Short", "Oncology");
    private static final Doctor d4 = new Doctor("Hayley Archer", "Kinesiology");
    private static final Doctor d5 = new Doctor("Trent Hartley", "Urology");
    private static final Doctor d6 = new Doctor("Rumaysa Meza", "Radiology");
    private static final Doctor d7 = new Doctor("Kaylee Neale", "Neurology");
    private static final Doctor d8 = new Doctor("Ashley Daugherty", "Pharmacy");
    private static final Doctor d9 = new Doctor("Ronan Hawkins", "Pathology");
    private static final Doctor d10 = new Doctor("Bernice Benson", "General Surgery");

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

    // MODIFIES: this
    // EFFECTS: sets the value of doctorName
    public void setDoctorName() {
        this.doctorName = doctorName;
    }

    // MODIFIES: this
    // EFFECTS: sets the value of department
    public void setDepartment() {
        this.department = department;
    }

    // EFFECTS: returns the doctorName of this
    public String getDoctorName() {
        return this.doctorName;
    }

    // EFFECTS: returns the department of this
    public String getDepartment() {
        return this.department;
    }

    // TODO: implement the continueUsing() method in this class
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
        doctors.add(d10);

        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getDoctorName() + ", " + d.getDepartment());
        }
    }

}


