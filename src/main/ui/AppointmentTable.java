package ui;

import model.Appointment;
import model.AppointmentList;

import javax.swing.*;
import java.awt.*;

// This class represents the GUI representation in table form of appointments stored by the program.
public class AppointmentTable extends JFrame {

    // accessing the appointment list from appointment menu
    protected AppointmentList al;

    // GUI and table elements
    Container tableContainer = getContentPane();
    JTable appointmentTable = new JTable();
    String[] columns = {"Name", "Time"};
    Object[][] object = new Object[30][30];

    // constructor
    // MODIFIES: al, tableContainer, appointmentTable
    // EFFECTS: initializes appointment list from appointment menu, creates window with table showing all appointments
    public AppointmentTable(AppointmentMenu am) {
        al = am.getAppointmentList();

        this.setTitle("MyHospitalManager -- Appointments");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 525);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeTable();

        tableContainer.setLayout(null);
        tableContainer.add(appointmentTable);
        appointmentTable.setBounds(0, 0, 550, 1000);
    }

    // MODIFIES: appointmentTable
    // EFFECTS: initializes table of appointments with values from appointment menu. If no appointments have been
    // added, error message will show.
    public void initializeTable() {
        int i = 1;
        if (al.getAppointments().size() != 0) {
            for (Appointment appointment : al.getAppointments()) {
                object[0][0] = "Name";
                object[0][1] = "Time";
                object[i][0] = appointment.getName();
                object[i][1] = appointment.getTime();
                i++;
                appointmentTable = new JTable(object, columns);
            }
        } else {
            dispose();
            JOptionPane.showMessageDialog(this, "No appointments have been added yet.");
        }
    }
}
