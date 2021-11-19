package model.exceptions;

// This class represents an exception that can be thrown by the AppointmentList of the PatientList class.
public class EmptyListException extends Exception {

    // constructor
    // The exception is thrown when you try to remove an element from an empty list.
    // EFFECTS: constructs an exception with given message
    public EmptyListException(String msg) {
        super(msg);
    }

}
