package model;

import java.util.ArrayList;
import java.util.List;

import static model.Inquiry.*;

// This class represents a list of inquiries.
public class InquiryList {
    private ArrayList<Inquiry> inquiries;

    // constructor
    // EFFECTS: constructs an empty list of inquiries.
    public InquiryList() {
        inquiries = new ArrayList<>();
    }

    // initialize list of inquiries
    // EFFECTS: initializes list of inquiries with dummy variables
    public void initInquiries() {
        inquiries.add(I1);
        inquiries.add(I2);
        inquiries.add(I3);
    }

    // get list of inquiries
    // EFFECTS: returns list of inquiries
    public List<Inquiry> getInquiryList() {
        return this.inquiries;
    }

}
