package ui;

import model.Patient;
import model.PatientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class represents the UI of the patient check-in feature of the program.
public class PatientMenu extends JFrame implements ActionListener {

    protected PatientList pl;

    // GUI components for the patient menu
    Container patientMenu = getContentPane();
    JButton checkInButton = new JButton("Check in Patient");
    JButton checkOutButton = new JButton("Check Out Patient");
    JButton showPatientsButton = new JButton("Show all Patients");

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(251, 204, 209);

    // constructor
    // EFFECTS: constructs a window containing the GUI elements for the patient check-in
    public PatientMenu(MainMenu mm) {

        // accessing list of patients declared from main menu
        pl = mm.pl;

        this.setTitle("MyHospitalManager -- Patients");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        patientMenu.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();
    }

    // getter method for the appointment list of the class. used by the AppointmentTable class.
    public PatientList getPatientList() {
        return pl;
    }

    // MODIFIES: checkInButton, checkOutButton, showPatientsButton, backgroundPanel
    // EFFECTS: sets the coordinates and dimensions of the buttons on the screen, and background panel
    public void setPositionAndSize() {
        checkInButton.setBounds(115, 50, 300, 150);
        checkOutButton.setBounds(115, 250, 300, 150);
        showPatientsButton.setBounds(115, 450, 300, 150);
        backgroundPanel.setBounds(0, 0, 650, 750);
    }

    // MODIFIES: patientMenu, backgroundPanel
    // EFFECTS: adds components to container, and sets color of backgroundPanel
    public void addComponents() {
        patientMenu.add(checkInButton);
        patientMenu.add(checkOutButton);
        patientMenu.add(showPatientsButton);
        patientMenu.add(backgroundPanel);
        backgroundPanel.setBackground(customColor);
    }

    // MODIFIES: checkInButton, checkOutButton, showPatientsButton
    // EFFECTS: adds action listening behavior to selected GUI components
    public void addActionEvents() {
        checkInButton.addActionListener(this);
        checkOutButton.addActionListener(this);
        showPatientsButton.addActionListener(this);
    }

    // EFFECTS: specifies action listening behavior for selected GUI components
    @Override
    public void actionPerformed(ActionEvent e) {

        // MODIFIES: pl
        // EFFECTS: prompts the user to input data for a patient, then constructs the corresponding patient and adds it
        // to list of patients.
        if (e.getSource() == checkInButton) {
            String inputPatientName = JOptionPane.showInputDialog("Patient Name: ");
            int inputPatientID = Integer.parseInt(JOptionPane.showInputDialog("Patient ID: "));

            Patient patient = new Patient(inputPatientName, inputPatientID);
            pl.addPatient(patient);

            JOptionPane.showMessageDialog(this, "Successful");
        }

        // REQUIRES: there are no duplicate names in list
        // MODIFIES: pl
        // EFFECTS: prompts the user to enter the name of the patient they would like to check out. If the name matches
        // the name of a patient in the list, the patient is removed from the list. Otherwise, does nothing
        if (e.getSource() == checkOutButton) {
            String patientToRemove = JOptionPane.showInputDialog("Please enter the name of the patient you"
                    + " would like to check out.");

            pl.removePatient(patientToRemove);
            JOptionPane.showMessageDialog(this, "Successful");
        }

        // EFFECTS: shows all patients currently stored in the program
        if (e.getSource() == showPatientsButton) {
            new PatientTable(this);
        }
    }
}
