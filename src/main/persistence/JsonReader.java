package persistence;

import model.Appointment;
import model.MedicalRecord;
import model.Patient;
import model.AppointmentList;
import model.MedicalRecordList;
import model.PatientList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads medical record list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public MedicalRecordList readMedicalRecordList() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMedicalRecordList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses medical record list from JSON object and returns it
    private MedicalRecordList parseMedicalRecordList(JSONObject jsonObject) {
        MedicalRecordList ml = new MedicalRecordList();
        addMedicalRecords(ml, jsonObject);
        return ml;
    }

    // MODIFIES: ml
    // EFFECTS: parses medical records from JSON object and adds them to medical record list
    private void addMedicalRecords(MedicalRecordList ml, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("medical records");
        for (Object json : jsonArray) {
            JSONObject nextMedicalRecord = (JSONObject) json;
            addMedicalRecord(ml, nextMedicalRecord);
        }
    }

    // MODIFIES: ml
    // EFFECTS: parses medical record from JSON object and adds it to workroom
    private void addMedicalRecord(MedicalRecordList ml, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        int height = jsonObject.getInt("height");
        int weight = jsonObject.getInt("weight");
        String bloodType = jsonObject.getString("blood type");

        MedicalRecord m = new MedicalRecord(name, age, height, weight, bloodType);
        ml.addMedicalRecord(m);
    }
}
