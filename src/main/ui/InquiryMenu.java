package ui;

import model.Inquiry;
import model.InquiryList;

import javax.swing.*;
import java.awt.*;

// This class represents the UI of the show inquiries feature of the program.
public class InquiryMenu extends JFrame {

    // GUI components for the inquiry menu
    Container inquiryMenu = getContentPane();

    // constructor
    // EFFECTS: constructs a window with a table containing dummy inquiries.
    public InquiryMenu() {
        this.setTitle("MyHospitalManager -- Inquiries");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        inquiryMenu.setLayout(null);
        setInquiryTable();
    }

    public void setInquiryTable() {
    }
}
