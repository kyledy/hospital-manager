package persistence;

import model.AppointmentList;
import model.MedicalRecordList;
import model.PatientList;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class references code from the JSonSerialization demo project given by the course.
// This class represents a writer that converts a medical record to a JSON file.
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // MODIFIES: this
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // EFFECTS: writes JSON representation of list of medical records to file
    public void writeMedicalRecordList(MedicalRecordList ml) {
        JSONObject json = ml.toJson();
        saveToFile(json.toString(TAB));
    }

    // EFFECTS: writes JSON representation of list of medical records to file
    public void writePatientList(PatientList pl) {
        JSONObject json = pl.toJson();
        saveToFile(json.toString(TAB));
    }

    // EFFECTS: writes JSON representation of list of medical records to file
    public void writeAppointmentList(AppointmentList al) {
        JSONObject json = al.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}
