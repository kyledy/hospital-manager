package model;

import java.util.ArrayList;

// This class represents an Inquiry, which can be filed by the Patient to the help desk or viewed by an Administrator.
// This class contains the internal framework for the UserInquiry class. The UserInquiry class is the only class in this
// suite that has implementations for both the patient-side and the admin-side.
public class Inquiry {

    // An Inquiry consists of a subject, the date it was filed, and any other additional remarks.
    String subject;
    String date;
    String remarks;

    // constructor for the Inquiry class
    public Inquiry(String subject, String date, String remarks) {
        this.subject = subject;
        this.date = date;
        this.remarks = remarks;
    }

    // MODIFIES: inquiries
    // EFFECTS: Takes a list of inquiries as a parameter and places inquiry i in the list
    public static void addInquiry(ArrayList<Inquiry> inquiries, Inquiry i) {
        inquiries.add(i);
    }

    // setter and getter methods
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
