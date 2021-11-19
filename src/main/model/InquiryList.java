package model;

import java.util.ArrayList;
import java.util.List;

import static model.Inquiry.*;

// This class represents a list of inquiries.
// This code references the AlarmSystem code given by the course.
public class InquiryList {
    private ArrayList<Inquiry> inquiries;

    // constructor
    // EFFECTS: constructs an empty list of inquiries.
    public InquiryList() {
        inquiries = new ArrayList<>();
    }

    // initialize list of inquiries
    // EFFECTS: initializes list of inquiries with dummy variables, and logs the event
    public void initInquiries() {
        addInquiry(I1);
        addInquiry(I2);
        addInquiry(I3);
        EventLog.getInstance().logEvent(new Event("List of inquiries has been initialized."));
    }

    // get list of inquiries
    // EFFECTS: returns list of inquiries
    public List<Inquiry> getInquiries() {
        return this.inquiries;
    }

    // add inquiry to list of inquiries
    // EFFECTS: adds inquiry to list of inquiries, and logs the event
    public void addInquiry(Inquiry i) {
        inquiries.add(i);
        EventLog.getInstance().logEvent(new Event("Inquiry has been added to list of inquiries."));
    }

}
