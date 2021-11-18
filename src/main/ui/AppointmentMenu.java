package ui;

import model.Appointment;
import model.AppointmentList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class represents the UI of the appointment booking feature of the program.
public class AppointmentMenu extends JFrame implements ActionListener {

    // initializing an empty list of appointments to be manipulated by the program
    protected AppointmentList al = new AppointmentList();

    // GUI components for the appointments menu
    Container appointmentMenu = getContentPane();
    JButton makeAppointmentButton = new JButton("Book an appointment");
    JButton removeAppointmentButton = new JButton("Remove an appointment");
    JButton showAppointmentsButton = new JButton("Show all appointments");

    // constructor
    // EFFECTS: constructs a window containing the GUI elements for the appointment booker
    public AppointmentMenu() {

        this.setTitle("MyHospitalManager -- Appointments");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        appointmentMenu.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();
    }

    // MODIFIES: makeAppointmentButton, removeAppointmentButton, showAppointmentButton
    // EFFECTS: sets the coordinates and dimensions of the buttons on the screen
    public void setPositionAndSize() {
        makeAppointmentButton.setBounds(115, 50, 300, 150);
        removeAppointmentButton.setBounds(115, 250, 300, 150);
        showAppointmentsButton.setBounds(115, 450, 300, 150);
    }

    // MODIFIES: appointmentMenu
    // EFFECTS: adds GUI components to container
    public void addComponents() {
        appointmentMenu.add(makeAppointmentButton);
        appointmentMenu.add(removeAppointmentButton);
        appointmentMenu.add(showAppointmentsButton);
    }

    // MODIFIES: makeAppointmentButton, removeAppointmentButton, showAppointmentButton
    // EFFECTS: adds action listening behavior to selected GUI components
    public void addActionEvents() {
        makeAppointmentButton.addActionListener(this);
        removeAppointmentButton.addActionListener(this);
        showAppointmentsButton.addActionListener(this);
    }

    // EFFECTS: specifies action behavior for each listed action event
    @Override
    public void actionPerformed(ActionEvent e) {

        // make an appointment
        // MODIFIES: al
        // EFFECTS: prompts the user to input the patient's name and booked time, then constructs an appointment with
        // the given name and time, and adds it to the list of appointments.
        if (e.getSource() == makeAppointmentButton) {
            String inputAppointmentName = JOptionPane.showInputDialog("Patient Name: ");
            String inputAppointmentTime = JOptionPane.showInputDialog("Booked Time: ");

            Appointment appointment = new Appointment(inputAppointmentName, inputAppointmentTime);
            al.addAppointment(appointment);
            JOptionPane.showMessageDialog(this, "Successful");
        }

        // remove an appointment
        // MODIFIES: al
        // EFFECTS: prompts the user to input the name of the patient whose appointment they would like removed. If
        // name matches name of one found in the list, the appointment is removed; otherwise does nothing
        if (e.getSource() == removeAppointmentButton) {
            String appointmentToRemove = JOptionPane.showInputDialog("Please enter the name of the patient whose"
                    + "appointment you would like to remove.");

            for (Appointment appointment : al.getAppointments()) {
                if (appointment.getName().equals(appointmentToRemove)) {
                    al.getAppointments().remove(appointment);
                    JOptionPane.showMessageDialog(this, "Successful");
                    break;
                }
            }
        }

        // show all appointments
        // EFFECTS: displays all appointments stored in the program
        if (e.getSource() == showAppointmentsButton) {
            // nothing for now
        }
    }
}
