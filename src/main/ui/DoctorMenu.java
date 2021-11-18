package ui;

import model.DoctorList;

import javax.swing.*;
import java.awt.*;

// This class represents the UI of the show doctors feature of the program.
public class DoctorMenu extends JFrame {

    // initializing empty list of doctors to be manipulated by the program
    DoctorList dl = new DoctorList();

    // GUI components for the doctor menu
    Container doctorMenu = getContentPane();

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(218, 247, 166);

    // constructor
    // EFFECTS: constructs a window containing a table with the doctors' names and departments.
    public DoctorMenu() {
        this.setTitle("MyHospitalManager -- Doctors");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        doctorMenu.setLayout(null);
        doctorMenu.add(backgroundPanel);
        backgroundPanel.setBackground(customColor);
        backgroundPanel.setBounds(0,0,650,750);
    }
}

