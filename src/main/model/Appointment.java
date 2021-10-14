package model;

// This class represents an Appointment with a selected Doctor, of which they are chosen by the Patient.
// Contains the internal framework for the AppointmentBooker class in UI.
// extends Doctor because certain functions of AppointmentBooker are dependent on data found in Doctor
public class Appointment extends Doctor {

    // constructor from super
    public Appointment(String doctorName, String department) {
        super(doctorName, department);
    }

    // EFFECTS: returns the name of a given doctor based on the user's choice
    public static String getDoctorNameFromChoice(String choice) {
        // This function is a helper method for showDoctorChoices() so that the appropriate number is assigned to the
        // appropriate doctor's name
        switch (choice) {

            case "1":
                return d1.getDoctorName();

            case "2":
                return d2.getDoctorName();

            case "3":
                return d3.getDoctorName();

            case "4":
                return d4.getDoctorName();

            case "5":
                return d5.getDoctorName();

            case "6":
                return d6.getDoctorName();

            case "7":
                return d7.getDoctorName();

            case "8":
                return d8.getDoctorName();

            case "9":
                return d9.getDoctorName();

            default:
                // If the user picks anything else, I included a little joke at the end.
                return "Seuss";
        }
    }
}
