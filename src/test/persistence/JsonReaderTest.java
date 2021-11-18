package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// This test borrows heavily from the test provided in JSonSerializationDemo.
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            MedicalRecordList ml = reader.readMedicalRecordList();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMedicalRecordList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMedicalRecordList.json");
        try {
            MedicalRecordList ml = reader.readMedicalRecordList();
            assertEquals(0, ml.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyPatientList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPatientList.json");
        try {
            PatientList pl = reader.readPatientList();
            assertEquals(0, pl.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyAppointmentList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyAppointmentList.json");
        try {
            AppointmentList al = reader.readAppointmentList();
            assertEquals(0, al.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMedicalRecord() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMedicalRecordList.json");
        try {
            MedicalRecordList ml = reader.readMedicalRecordList();
            List<MedicalRecord> records = ml.getMedicalRecords();
            assertEquals(2, ml.length());
            checkMedicalRecord("kyle", 18, 174, 80, "O", records.get(0));
            checkMedicalRecord("andie", 20, 120, 68, "A", records.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPatient() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPatientList.json");
        try {
            PatientList pl = reader.readPatientList();
            List<Patient> patients = pl.getPatients();
            assertEquals(2, pl.length());
            checkPatient("andie", 1234, patients.get(0));
            checkPatient("kyle", 2345, patients.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralAppointment() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralAppointmentList.json");
        try {
            AppointmentList al = reader.readAppointmentList();
            List<Appointment> appointments = al.getAppointments();
            assertEquals(2, al.length());
            checkAppointment("Greg", "9:30 am", appointments.get(0));
            checkAppointment("Sandy", "10:20 pm", appointments.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
