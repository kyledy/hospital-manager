package ui;

import javax.swing.*;
import java.awt.*;

// This class represents the UI of the show doctors feature of the program.
public class DoctorMenu extends JFrame {

    // GUI components for the doctor menu
    Container doctorMenu = getContentPane();

    // constructor
    // EFFECTS: constructs a window containing a table with the doctors' names and departments.
    public DoctorMenu() {
        this.setTitle("MyHospitalManager -- Doctors");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        doctorMenu.setLayout(null);
        setDoctorTable();
    }

    public void setDoctorTable() {
    }
}

