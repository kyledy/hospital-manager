package ui;

import model.MedicalRecord;
import model.MedicalRecordList;

import javax.swing.*;
import java.awt.*;

// This class represents the GUI representation in table form of medical records stored by the program.
public class MedicalRecordTable extends JFrame {

    // accessing the medical record list from medical record menu
    protected MedicalRecordList ml;

    // GUI and table elements
    Container tableContainer = getContentPane();
    JTable medicalRecordTable = new JTable();
    String[] columns = {"Name", "Age", "Height", "Weight", "Blood Type"};
    Object[][] object = new Object[30][30];

    // constructor
    // EFFECTS: initializes medical record list from medical record menu, constructs a window with table using the
    // corresponding data values
    public MedicalRecordTable(MedicalRecordMenu mm) {
        ml = mm.getMedicalRecordList();

        this.setTitle("MyHospitalManager -- Medical Records");
        this.setVisible(true);
        this.setBounds(1000, 100, 750, 525);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        initializeTable();

        tableContainer.setLayout(null);
        tableContainer.add(medicalRecordTable);
        medicalRecordTable.setBounds(0, 0, 750, 1000);
    }

    // MODIFIES: medicalRecordTable
    // EFFECTS: initializes a table with values from medical record list
    public void initializeTable() {
        int i = 1;
        if (ml.getMedicalRecords().size() != 0) {
            for (MedicalRecord medicalRecord : ml.getMedicalRecords()) {
                object[0][0] = "Name";
                object[0][1] = "Age";
                object[0][2] = "Height";
                object[0][3] = "Weight";
                object[0][4] = "Blood Type";
                object[i][0] = medicalRecord.getName();
                object[i][1] = medicalRecord.getAge();
                object[i][2] = medicalRecord.getHeight();
                object[i][3] = medicalRecord.getWeight();
                object[i][4] = medicalRecord.getBloodType();
                i++;
                medicalRecordTable = new JTable(object, columns);
            }
        } else {
            dispose();
            JOptionPane.showMessageDialog(this, "No medical records have been added yet.");
        }
    }
}

