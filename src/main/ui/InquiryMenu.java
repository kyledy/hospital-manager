package ui;

import model.Inquiry;
import model.InquiryList;

import javax.swing.*;
import java.awt.*;

// This class represents the UI of the show inquiries feature of the program.
public class InquiryMenu extends JFrame {

    // initializing empty list of inquiries for use by the program
    protected InquiryList il = new InquiryList();

    // GUI and table elements
    Container tableContainer = getContentPane();
    JTable inquiryTable = new JTable();
    String[] columns = {"Subject", "Date", "Remarks"};
    Object[][] object = new Object[4][4];

    // constructor
    // MODIFIES: il, tableContainer, inquiryTable
    // EFFECTS: initializes inquiry list with dummy inquiries, constructs a window containing the table where the
    // values are held
    public InquiryMenu() {
        il.initInquiries();

        this.setTitle("MyHospitalManager -- Inquiries");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 110);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeTable();

        tableContainer.setLayout(null);
        tableContainer.add(inquiryTable);
        inquiryTable.setBounds(0,0, 550, 1000);
    }

    // MODIFIES: inquiryTable
    // EFFECTS: initializes a table with values parsed in from inquiry list
    public void initializeTable() {
        int i = 1;
        if (il.getInquiries().size() != 0) {
            for (Inquiry inquiry : il.getInquiries()) {
                object[0][0] = "Subject";
                object[0][1] = "Date";
                object[0][2] = "Remarks";
                object[i][0] = inquiry.getSubject();
                object[i][1] = inquiry.getDate();
                object[i][2] = inquiry.getRemarks();
                i++;
                inquiryTable = new JTable(object, columns);
            }
        }
    }
}
