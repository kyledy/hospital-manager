package ui;

import model.Patient;
import model.PatientList;

import javax.swing.*;
import java.awt.*;

public class PatientTable extends JFrame {

    // accessing the appointment list from appointment menu
    protected PatientList pl;

    // GUI and table elements
    Container tableContainer = getContentPane();
    JTable patientTable = new JTable();
    String[] columns = {"Name", "ID"};
    Object[][] object = new Object[30][30];

    // constructor
    // MODIFIES: pl, tableContainer, patientTable
    // EFFECTS: initializes patient list with values from patient menu, and constructs a table with values from patient
    // list
    public PatientTable(PatientMenu pm) {
        pl = pm.getPatientList();

        this.setTitle("MyHospitalManager -- Patients");
        this.setVisible(true);
        this.setBounds(1000, 100, 550, 525);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeTable();

        tableContainer.setLayout(null);
        tableContainer.add(patientTable);
        patientTable.setBounds(0, 0, 550, 1000);
    }

    // MODIFIES: patientTable
    // EFFECTS: initializes table with values from patient list
    public void initializeTable() {
        int i = 1;
        if (pl.getPatients().size() != 0) {
            for (Patient patient : pl.getPatients()) {
                object[0][0] = "Name";
                object[0][1] = "ID";
                object[i][0] = patient.getName();
                object[i][1] = patient.getId();
                i++;
                patientTable = new JTable(object, columns);
            }
        } else {
            dispose();
            JOptionPane.showMessageDialog(this, "No patients have been added yet.");
        }
    }
}
