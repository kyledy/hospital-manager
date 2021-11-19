package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// This class represents a list of medical records.
// This class references code from the JSonSerializationDemo project.
// This code references the AlarmSystem code given by the course.
public class MedicalRecordList implements Writable {
    private ArrayList<MedicalRecord> medicalRecords;

    // constructor
    // EFFECTS: constructs an empty list of medical records.
    public MedicalRecordList() {
        medicalRecords = new ArrayList<>();
    }

    // get list of medical records
    // EFFECTS: returns list of medical records
    public List<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }

    // add medical record to list of medical records
    // EFFECTS: adds medical record m to list of medical records, and logs the event
    public void addMedicalRecord(MedicalRecord m) {
        medicalRecords.add(m);
        EventLog.getInstance().logEvent(new Event("Medical record has been added to list of medical "
                + "records."));
    }

    // get length of list
    // EFFECTS: returns length of list of medical records
    public int length() {
        return medicalRecords.size();
    }

    // parses the list and converts each medical record to Json
    // EFFECTS: for each medical record in the list, converts it to JSonObject and returns it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("medical records", medicalRecordsToJson());
        return json;
    }

    // EFFECTS: returns medical records in this medical record list as a JSON array
    private JSONArray medicalRecordsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (MedicalRecord m : medicalRecords) {
            jsonArray.put(m.toJson());
        }

        return jsonArray;
    }
}
