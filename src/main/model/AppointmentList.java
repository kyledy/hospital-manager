package model;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of Appointments.
public class AppointmentList {
    private ArrayList<Appointment> appointments;

    // constructor
    // EFFECTS: constructs an empty list of appointments
    public AppointmentList() {
        appointments = new ArrayList<>();
    }

    // get list of appointments
    // EFFECTS: returns list of appointments
    public List<Appointment> getAppointmentList() {
        return this.appointments;
    }
}
