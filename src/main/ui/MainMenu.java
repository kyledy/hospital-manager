package ui;

import model.Event;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// This class represents the home page of the program.
// This code references the JSONSerialization demo project given by the course.
// An older state of this application referenced the AccountNotRobust project, but this has since been omitted for
// Phase 3
public class MainMenu extends JFrame implements ActionListener {

    // initializing the event log of the program
    private EventLog el;
    private static final String TAB = " ";

    // Declaration of menu variables
    protected PatientMenu patientMenu;
    protected MedicalRecordMenu medicalRecordMenu;
    protected AppointmentMenu appointmentMenu;
    protected DoctorMenu doctorMenu;
    protected InquiryMenu inquiryMenu;

    // initializing lists to data to be used by the application
    protected AppointmentList al = new AppointmentList();
    protected MedicalRecordList ml = new MedicalRecordList();
    protected PatientList pl = new PatientList();

    // persistence elements
    private static final String APPOINTMENT_STORE = "./data/appointments.json";
    private static final String MEDICAL_RECORD_STORE = "./data/medicalrecords.json";
    private static final String PATIENT_LIST_STORE = "./data/patients.json";

    // JSon readers and writers
    private JsonWriter appointmentWriter;
    private JsonReader appointmentReader;

    private JsonWriter medicalRecordWriter;
    private JsonReader medicalRecordReader;

    private JsonWriter patientListWriter;
    private JsonReader patientListReader;

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

        // Instructs the program to print the event log to console when the window closes.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printLog();
                System.exit(0);
            }
        });

        mainMenu.setLayout(null);
        createMenuBar();
        createMenus();
        setPositionAndSize();
        addComponents();
        addActionEvents();
        initializeReaderAndWriter();
    }

    // MODIFIES: el
    // EFFECTS: prints the event log to the console, then clears it.
    public void printLog() {
        el = EventLog.getInstance();
        for (Event e : el) {
            System.out.println(e.getDate() + ":" + TAB + e.getDescription());
        }
        el.clear();
        System.out.println("Event log has been cleared.");
    }

    // EFFECTS: initializes the JSon readers and writers
    public void initializeReaderAndWriter() {
        appointmentWriter = new JsonWriter(APPOINTMENT_STORE);
        appointmentReader = new JsonReader(APPOINTMENT_STORE);

        medicalRecordWriter = new JsonWriter(MEDICAL_RECORD_STORE);
        medicalRecordReader = new JsonReader(MEDICAL_RECORD_STORE);

        patientListWriter = new JsonWriter(PATIENT_LIST_STORE);
        patientListReader = new JsonReader(PATIENT_LIST_STORE);
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
        menuHelp.add(aboutButton);
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
    }

    // EFFECTS: saves current state of program as a JSonObject
    public void saveStateToJson() {
        try {
            appointmentWriter.open();
            appointmentWriter.writeAppointmentList(al);
            appointmentWriter.close();

            medicalRecordWriter.open();
            medicalRecordWriter.writeMedicalRecordList(ml);
            medicalRecordWriter.close();

            patientListWriter.open();
            patientListWriter.writePatientList(pl);
            patientListWriter.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found!");
        }
    }

    // EFFECTS: parses lists of data from JSon
    public void loadStateToJson() {
        try {
            al = appointmentReader.readAppointmentList();
            ml = medicalRecordReader.readMedicalRecordList();
            pl = patientListReader.readPatientList();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File not found!");
        }
    }

    // action listeners for main menu GUI
    // EFFECTS: adds action listening behavior for GUI components
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException {

        // Brings the user to the patient menu if patientButton is pressed
        if (e.getSource() == patientButton) {
            patientMenu = new PatientMenu(this);
        }

        // Brings the user to the doctor menu if doctorButton is pressed
        if (e.getSource() == doctorButton) {
            doctorMenu = new DoctorMenu();
        }

        // Brings the user to the inquiry menu if inquiryButton is pressed
        if (e.getSource() == inquiryButton) {
            inquiryMenu = new InquiryMenu();
        }

        // Brings the user to the medical record menu if medicalRecordButton is pressed
        if (e.getSource() == medicalRecordButton) {
            medicalRecordMenu = new MedicalRecordMenu(this);
        }

        // Brings the user to the appointment menu if appointmentButton is pressed
        if (e.getSource() == appointmentButton) {
            appointmentMenu = new AppointmentMenu(this);
        }

        // Allows the user to save the current state of their application to file
        if (e.getSource() == saveStateButton) {
            try {
                saveStateToJson();
                JOptionPane.showMessageDialog(this, "Successfully saved data to file.");
            } catch (NullPointerException ne) {
                ne.printStackTrace();
                JOptionPane.showMessageDialog(this, "The lists have not been initialized!");
            }
        }

        // Allows the user to load a previous state of their application from file
        if (e.getSource() == loadStateButton) {
            loadStateToJson();
            JOptionPane.showMessageDialog(this, "Successfully loaded data from file.");
        }

        // Brings the user to the appointment menu if aboutButton is pressed
        if (e.getSource() == aboutButton) {
            JOptionPane.showMessageDialog(this, "Welcome to MyHospitalManager! In this "
                    + "application you will find many useful features. Please feel free to navigate them below.");
        }
    }
}
