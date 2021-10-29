package model;

// This class represents information on an appointment that was booked by a Patient.
public class Appointment {
    private String name;
    private String time;

    // An appointment must be booked with a certain time
    public Appointment(String name, String time) {
        this.name = name;
        this.time = time;
    }

    // setter and getter methods
    public void setName(String name) {
        this.name = name;
    }

    // note that values of time are ideally in the form [XXX am/pm]
    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public String getTime() {
        return this.time;
    }
}
