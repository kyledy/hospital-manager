package ui;

import model.MedicalRecord;
import model.MedicalRecordList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// This class represents the UI of the medical records feature of the program.
// This code references the JSONSerialization demo project given by the course.
public class MedicalRecordMenu extends JFrame implements ActionListener {

    // persistence elements
    private static final String MEDICAL_RECORD_STORE = "./data/medicalrecords.json";
    private JsonWriter medicalRecordWriter;
    private JsonReader medicalRecordReader;

    // initializing a list of medical records to be manipulated by the program.
    protected MedicalRecordList ml = new MedicalRecordList();

    // GUI components for the medical records menu
    Container medicalRecordMenu = getContentPane();
    JButton makeMedicalRecordButton = new JButton("Make new medical record");
    JButton showMedicalRecordsButton = new JButton("Show all medical records");

    // These two components set the background color
    JPanel backgroundPanel = new JPanel();
    Color customColor = new Color(177, 156, 217);

    // constructor
    // EFFECTS: constructs a window containing GUI elements for the medical record creator
    public MedicalRecordMenu() {
        this.setTitle("MyHospitalManager -- Medical Records");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeReaderAndWriter();
        medicalRecordMenu.setLayout(null);
        setPositionAndSize();
        addComponents();
        addActionEvents();
    }

    // EFFECTS: initializes medical record readers and writers
    public void initializeReaderAndWriter() {
        medicalRecordWriter = new JsonWriter(MEDICAL_RECORD_STORE);
        medicalRecordReader = new JsonReader(MEDICAL_RECORD_STORE);
    }

    // getter method for the medical record list of the class. used by the MedicalRecordTable class.
    public MedicalRecordList getMedicalRecordList() {
        return ml;
    }

    // MODIFIES: makeMedicalRecordButton, showMedicalRecordsButton, background Panel
    // EFFECTS: sets the coordinates and dimensions of the buttons on the screen, and background panel
    public void setPositionAndSize() {
        makeMedicalRecordButton.setBounds(115, 150, 300, 150);
        showMedicalRecordsButton.setBounds(115, 350, 300, 150);
        backgroundPanel.setBounds(0, 0, 650, 750);
    }

    // MODIFIES: medicalRecordMenu, backgroundPanel
    // EFFECTS: adds selected GUI components to container, and sets color of background panel
    public void addComponents() {
        medicalRecordMenu.add(makeMedicalRecordButton);
        medicalRecordMenu.add(showMedicalRecordsButton);
        medicalRecordMenu.add(backgroundPanel);
        backgroundPanel.setBackground(customColor);
    }

    // MODIFIES: makeMedicalRecordButton, showMedicalRecordsButton
    // EFFECTS: adds action listening behavior to selected GUI components
    public void addActionEvents() {
        makeMedicalRecordButton.addActionListener(this);
        showMedicalRecordsButton.addActionListener(this);
    }

    // EFFECTS: saves list of medicalRecords to JSon
    public void saveMedicalRecordsToJson() {
        try {
            medicalRecordWriter.open();
            medicalRecordWriter.writeMedicalRecordList(ml);
            medicalRecordWriter.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File not found!");
        }
    }

    // EFFECTS: parses list of medical records from JSon
    public void loadMedicalRecordsFromJson() {
        try {
            ml = medicalRecordReader.readMedicalRecordList();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File not found!");
        }
    }

    // EFFECTS: specifies action listening behavior for specific GUI components
    @Override
    public void actionPerformed(ActionEvent e) {

        // MODIFIES: ml
        // EFFECTS: prompts the user to enter input to make a new medical record, then creates the corresponding
        // medical record and adds it to the list of medical records
        if (e.getSource() == makeMedicalRecordButton) {
            String inputMedicalRecordName = JOptionPane.showInputDialog("Name: ");
            int inputMedicalRecordAge = Integer.parseInt(JOptionPane.showInputDialog("Age: "));
            int inputMedicalRecordHeight = Integer.parseInt(JOptionPane.showInputDialog("Height: "));
            int inputMedicalRecordWeight = Integer.parseInt(JOptionPane.showInputDialog("Weight: "));
            String inputMedicalRecordBloodType = JOptionPane.showInputDialog("Blood Type: ");

            MedicalRecord medicalRecord = new MedicalRecord(inputMedicalRecordName, inputMedicalRecordAge,
                    inputMedicalRecordHeight, inputMedicalRecordWeight, inputMedicalRecordBloodType);

            ml.addMedicalRecord(medicalRecord);
            JOptionPane.showMessageDialog(this, "Successful");
        }

        // EFFECTS: shows all medical records contained in the program
        if (e.getSource() == showMedicalRecordsButton) {
            new MedicalRecordTable(this);
        }
    }
}
