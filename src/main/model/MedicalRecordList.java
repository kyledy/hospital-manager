package model;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of medical records.
public class MedicalRecordList {
    private ArrayList<MedicalRecord> medicalRecords;

    // constructor
    // EFFECTS: constructs an empty list of medical records.
    public MedicalRecordList() {
        medicalRecords = new ArrayList<>();
    }

    // get list of medical records
    // EFFECTS: returns a list of medical records
    public List<MedicalRecord> getMedicalRecordList() {
        return this.medicalRecords;
    }

}
