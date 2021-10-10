package model.Doctor;

public class Doctor {
    private String doctorName;
    private String department;

    public Doctor(String name, String department) {
        Doctor d = new Doctor(name, department);
    }

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
