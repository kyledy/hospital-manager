package ui;

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

    // Declaration of menu variables so that persistence methods can access variables of that class
    protected PatientMenu patientMenu;
    protected MedicalRecordMenu medicalRecordMenu;
    protected AppointmentMenu appointmentMenu;

    // GUI components for the main menu
    Container mainMenu = getContentPane();
    JButton patientButton = new JButton("Patients");
    JButton doctorButton = new JButton("Doctors");
    JButton inquiryButton = new JButton("Inquiries");
    JButton medicalRecordButton = new JButton("Medical Records");
    JButton appointmentButton = new JButton("Appointments");
    JMenuBar menuBar;
    JMenu menuFile;
    JMenu menuHelp;
    JMenuItem saveStateButton;
    JMenuItem loadStateButton;
    JMenuItem aboutButton;
    JMenuItem readMeButton;

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(167, 222, 250);

    // constructor
    // EFFECTS: displays the main menu of the program, and an important README message
    public MainMenu() throws FileNotFoundException {
        this.setTitle("MyHospitalManager -- Main Menu");
        this.setVisible(true);
        this.setBounds(50, 50, 900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        mainMenu.setLayout(null);
        createMenuBar();
        createMenus();
        setPositionAndSize();
        addComponents();
        addActionEvents();

        JOptionPane.showMessageDialog(this, "README: To save and load your data without"
                + " causing an error, please click the Patient, Medical Records, and Appointment Menus at least once."
                + " To view this message again, click Help > README.");
    }

    // MODIFIES: patientButton, doctorButton, inquiryButton, medicalRecordButton, appointmentButton,
    //           backgroundPanel
    // EFFECTS: sets the position and size of the GUI elements on the content pane
    public void setPositionAndSize() {
        patientButton.setBounds(50, 200, 225, 150);
        doctorButton.setBounds(330, 200, 225, 150);
        inquiryButton.setBounds(610, 200, 225, 150);
        medicalRecordButton.setBounds(175, 400, 225, 150);
        appointmentButton.setBounds(475, 400, 225, 150);
        backgroundPanel.setBounds(0, 0, 1000, 900);
    }

    // MODIFIES: mainMenu, menuBar
    // EFFECTS: constructs menu bar with menu items on top of the screen
    public void createMenuBar() {
        menuBar = new JMenuBar();
        mainMenu.add(menuBar);

        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        menuBar.setBounds(0, 0, 900, 30);
        menuBar.setVisible(true);
    }

    // MODIFIES: saveStateButton, loadStateButton, menuFile, aboutButton, menuHelp
    // EFFECTS: initializes menu items on menu bar
    public void createMenus() {
        saveStateButton = new JMenuItem("Save state from file...");
        loadStateButton = new JMenuItem("Load state from file...");
        menuFile.add(saveStateButton);
        menuFile.add(loadStateButton);

        aboutButton = new JMenuItem("About");
        readMeButton = new JMenuItem("README");
        menuHelp.add(aboutButton);
        menuHelp.add(readMeButton);
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
        saveStateButton.addActionListener(this);
        loadStateButton.addActionListener(this);
        aboutButton.addActionListener(this);
        readMeButton.addActionListener(this);
    }

    // action listeners for main menu GUI
    // EFFECTS: adds action listening behavior for GUI components
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
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

        // Allows the user to save the current state of their application to file
        if (e.getSource() == saveStateButton) {
            appointmentMenu.saveAppointmentsToJson();
            medicalRecordMenu.saveMedicalRecordsToJson();
            patientMenu.savePatientsToJson();
            JOptionPane.showMessageDialog(this, "Successfully saved data to file.");
        }

        // Allows the user to load a previous state of their application from file
        if (e.getSource() == loadStateButton) {
            appointmentMenu.loadAppointmentsFromJson();
            medicalRecordMenu.loadMedicalRecordsFromJson();
            patientMenu.loadPatientsFromJson();
            JOptionPane.showMessageDialog(this, "Successfully loaded data from file.");
        }

        // Brings the user to the appointment menu if aboutButton is pressed
        if (e.getSource() == aboutButton) {
            JOptionPane.showMessageDialog(this, "Welcome to MyHospitalManager! In this "
                    + "application you will find many useful features. Please feel free to navigate them below.");
        }

        // Allows the user to view the README message again
        if (e.getSource() == readMeButton) {
            JOptionPane.showMessageDialog(this, "README: To save and load your data without"
                    + " causing an error, please click the Patient, Medical Records, and Appointment Menus at "
                    + "least once.");
        }
    }
}
