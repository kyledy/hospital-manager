package ui;

import model.Doctor;
import model.DoctorList;

import javax.swing.*;
import java.awt.*;

// This class represents the UI of the show doctors feature of the program.
public class DoctorMenu extends JFrame {

    // initializing empty list of doctors to be manipulated by the program
    protected DoctorList dl = new DoctorList();

    // GUI and table elements
    Container tableContainer = getContentPane();
    JTable doctorTable = new JTable();
    String[] columns = {"Name", "Department"};
    Object[][] object = new Object[10][10];

    // constructor
    // MODIFIES: dl, tableContainer, doctorTable
    // EFFECTS: initializes list of doctors with final variables, and constructs window with table showing all values.
    public DoctorMenu() {
        dl.initDoctors();

        this.setTitle("MyHospitalManager -- Doctors");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 208);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeTable();

        tableContainer.setLayout(null);
        tableContainer.add(doctorTable);
        doctorTable.setBounds(0, 0, 550, 1000);
    }

    // MODIFIES: doctorTable
    // EFFECTS: creates table with data corresponding to values in doctor list
    public void initializeTable() {
        int i = 1;
        if (dl.getDoctors().size() != 0) {
            for (Doctor doctor : dl.getDoctors()) {
                object[0][0] = "Name";
                object[0][1] = "Department";
                object[i][0] = doctor.getDoctorName();
                object[i][1] = doctor.getDepartment();
                i++;
                doctorTable = new JTable(object, columns);
            }
        }
    }
}

