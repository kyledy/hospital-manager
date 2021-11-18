package model;

// This class represents information on an inquiry that can be filed to the hospital help desk.
public class Inquiry {

    // An Inquiry consists of a subject, the date it was filed, and any other additional remarks.
    private String subject;
    private String date;
    private String remarks;

    // The inquiries that are shown by the program are dummy variables.
    public static final Inquiry I1 = new Inquiry("cannot book appointment", "September 16, 2021",
            "N/a");
    public static final Inquiry I2 = new Inquiry("emergency appointment", "November 19, 2021",
            "Please hurry!");
    public static final Inquiry I3 = new Inquiry("I have a crush on a doctor", "January 4, 2021",
            "I won't say!");

    // constructor
    // EFFECTS: constructs an inquiry with given subject, date, and remarks
    public Inquiry(String subject, String date, String remarks) {
        this.subject = subject;
        this.date = date;
        this.remarks = remarks;
    }

    // Setter and Getter methods
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getDate() {
        return this.date;
    }

    public String getRemarks() {
        return this.remarks;
    }
}
