package model;

// This class represents information on a doctor currently employed at the hospital.
public class Doctor {

    // A doctor has a name, and department
    private String doctorName;
    private String department;

    // The values for doctors at this hospital are final
    public static final Doctor D1 = new Doctor("Cain Schmidt", "Cardiology");
    public static final Doctor D2 = new Doctor("Toni O'Brien", "Pediatrics");
    public static final Doctor D3 = new Doctor("Katie Short", "Oncology");
    public static final Doctor D4 = new Doctor("Hayley Archer", "Kinesiology");
    public static final Doctor D5 = new Doctor("Trent Hartley", "Urology");
    public static final Doctor D6 = new Doctor("Owen Hart", "Radiology");
    public static final Doctor D7 = new Doctor("Kaylee Neale", "Neurology");
    public static final Doctor D8 = new Doctor("Ashley Daugherty", "Pharmacy");
    public static final Doctor D9 = new Doctor("Ronan Hawkins", "Pathology");

    // constructor
    // EFFECTS: constructs a doctor with given name and department
    public Doctor(String doctorName, String department) {
        this.doctorName = doctorName;
        this.department = department;
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
