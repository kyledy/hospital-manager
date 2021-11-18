package ui;

import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// This class represents the home page of the program.
// This code references the JSONSerialization demo project given by the course.
// An older state of this application referenced the AccountNotRobust project, but this has since been omitted for
// Phase 3
public class MainMenu extends JFrame implements ActionListener {

    // JSON storage files
    private static final String MEDICAL_RECORD_STORE = "./data/medicalrecords.json";
    private static final String PATIENT_LIST_STORE = "./data/patients.json";
    private static final String APPOINTMENT_STORE = "./data/appointments.json";

    // Declaration of menu variables so that persistence methods can access variables of that class
    protected PatientMenu patientMenu;
    protected MedicalRecordMenu medicalRecordMenu;
    protected AppointmentMenu appointmentMenu;

    // JSON readers and writers
    private JsonWriter medicalRecordWriter;
    private JsonReader medicalRecordReader;

    private JsonWriter patientListWriter;
    private JsonReader patientListReader;

    private JsonWriter appointmentWriter;
    private JsonReader appointmentReader;

    // GUI components for the main menu
    Container mainMenu = getContentPane();
    JButton patientButton = new JButton("Patients");
    JButton doctorButton = new JButton("Doctors");
    JButton inquiryButton = new JButton("Inquiries");
    JButton medicalRecordButton = new JButton("Medical Records");
    JButton appointmentButton = new JButton("Appointments");

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(167, 222, 250);

    public MainMenu() throws FileNotFoundException {
        this.setTitle("MyHospitalManager -- Main Menu");
        this.setVisible(true);
        this.setBounds(50, 50, 900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        mainMenu.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();
        initializeReaderAndWriter();
    }

    public void initializeReaderAndWriter() {
        // initializes JSON writers and JSON readers
        medicalRecordWriter = new JsonWriter(MEDICAL_RECORD_STORE);
        medicalRecordReader = new JsonReader(MEDICAL_RECORD_STORE);

        patientListWriter = new JsonWriter(PATIENT_LIST_STORE);
        patientListReader = new JsonReader(PATIENT_LIST_STORE);

        appointmentWriter = new JsonWriter(APPOINTMENT_STORE);
        appointmentReader = new JsonReader(APPOINTMENT_STORE);
    }

    // MODIFIES: patientButton, doctorButton, inquiryButton, medicalRecordButton, appointmentButton,
    //           backgroundPanel
    // EFFECTS: sets the position and size of the GUI elements on the content pane
    public void setPositionAndSize() {
        patientButton.setBounds(50, 200, 225, 150);
        doctorButton.setBounds(330, 200, 225, 150);
        inquiryButton.setBounds(610, 200, 225, 150);
        medicalRecordButton.setBounds(175,400, 225, 150);
        appointmentButton.setBounds(475,400,225,150);
        backgroundPanel.setBounds(0, 0, 1000,900);
    }

    // MODIFIES: container
    // EFFECTS: adds GUI components to container, and sets colour of background panel
    public void addComponents() {
        backgroundPanel.setBackground(customColor);
        mainMenu.add(patientButton);
        mainMenu.add(doctorButton);
        mainMenu.add(inquiryButton);
        mainMenu.add(medicalRecordButton);
        mainMenu.add(appointmentButton);
        mainMenu.add(backgroundPanel);
    }

    // MODIFIES: patientButton, doctorButton, inquiryButton, medicalRecordButton, appointmentButton
    // EFFECTS: adds action listener to selected GUI components
    public void addActionEvents() {
        patientButton.addActionListener(this);
        doctorButton.addActionListener(this);
        inquiryButton.addActionListener(this);
        medicalRecordButton.addActionListener(this);
        appointmentButton.addActionListener(this);
    }

    // action listeners for main menu GUI
    // EFFECTS: adds action listening behavior for GUI components
    @Override
    public void actionPerformed(ActionEvent e) {

        // Brings the user to the patient menu if patientButton is pressed
        if (e.getSource() == patientButton) {
            patientMenu = new PatientMenu();
        }

        // Brings the user to the doctor menu if doctorButton is pressed
        if (e.getSource() == doctorButton) {
            new DoctorMenu();
        }

        // Brings the user to the inquiry menu if inquiryButton is pressed
        if (e.getSource() == inquiryButton) {
            new InquiryMenu();
        }

        // Brings the user to the medical record menu if medicalRecordButton is pressed
        if (e.getSource() == medicalRecordButton) {
            medicalRecordMenu = new MedicalRecordMenu();
        }

        // Brings the user to the appointment menu if appointmentButton is pressed
        if (e.getSource() == appointmentButton) {
            appointmentMenu = new AppointmentMenu();
        }
    }

    /*
    // EFFECTS: saves the current state of program to file
    protected void saveState() {

        try {
            medicalRecordWriter.open();
            medicalRecordWriter.writeMedicalRecordList(ml);
            medicalRecordWriter.close();
            System.out.println("Saved medical records to " + MEDICAL_RECORD_STORE);

            patientListWriter.open();
            patientListWriter.writePatientList(pl);
            patientListWriter.close();
            System.out.println("Saved list of patients to " + PATIENT_LIST_STORE);

            appointmentWriter.open();
            appointmentWriter.writeAppointmentList(al);
            appointmentWriter.close();
            System.out.println("Saved list of appointments to " + APPOINTMENT_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads previous state of program from file
    protected void loadState() {
        try {
            ml = medicalRecordReader.readMedicalRecordList();
            System.out.println("Loaded medical records from " + MEDICAL_RECORD_STORE);

            pl = patientListReader.readPatientList();
            System.out.println("Loaded patient list from " + PATIENT_LIST_STORE);

            al = appointmentReader.readAppointmentList();
            System.out.println("Loaded appointment list from " + APPOINTMENT_STORE);

        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    */

}
