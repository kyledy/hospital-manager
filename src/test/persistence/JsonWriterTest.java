package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// This test borrows heavily from the test provided in JSonSerializationDemo.
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            MedicalRecordList ml = new MedicalRecordList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMedicalRecord() {
        try {
            MedicalRecordList ml = new MedicalRecordList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMedicalRecordList.json");
            writer.open();
            writer.writeMedicalRecordList(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMedicalRecordList.json");
            ml = reader.readMedicalRecordList();
            assertEquals(0, ml.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyPatient() {
        try {
            PatientList pl = new PatientList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPatientList.json");
            writer.open();
            writer.writePatientList(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPatientList.json");
            pl = reader.readPatientList();
            assertEquals(0, pl.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyAppointment() {
        try {
            AppointmentList al = new AppointmentList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyAppointmentList.json");
            writer.open();
            writer.writeAppointmentList(al);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyAppointmentList.json");
            al = reader.readAppointmentList();
            assertEquals(0, al.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMedicalRecord() {
        try {
            MedicalRecordList ml = new MedicalRecordList();
            ml.addMedicalRecord(new MedicalRecord("kyle", 10, 10, 10, "O"));
            ml.addMedicalRecord(new MedicalRecord("andie", 11, 11, 11, "A"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMedicalRecordList.json");
            writer.open();
            writer.writeMedicalRecordList(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMedicalRecordList.json");
            ml = reader.readMedicalRecordList();
            List<MedicalRecord> records = ml.getMedicalRecords();
            assertEquals(2, ml.length());
            checkMedicalRecord("kyle", 10, 10, 10, "O", records.get(0));
            checkMedicalRecord("andie", 11, 11, 11, "A", records.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPatient() {
        try {
            PatientList pl = new PatientList();
            pl.addPatient(new Patient("Kyle", 1234));
            pl.addPatient(new Patient("Andie", 2345));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPatientList.json");
            writer.open();
            writer.writePatientList(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPatientList.json");
            pl = reader.readPatientList();
            List<Patient> patients = pl.getPatients();
            assertEquals(2, pl.length());
            checkPatient("Kyle", 1234, patients.get(0));
            checkPatient("Andie", 2345, patients.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralAppointment() {
        try {
            AppointmentList al = new AppointmentList();
            al.addAppointment(new Appointment("Kyle", "9:30 pm"));
            al.addAppointment(new Appointment("Andie", "4:00 am"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAppointmentList.json");
            writer.open();
            writer.writeAppointmentList(al);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAppointmentList.json");
            al = reader.readAppointmentList();
            List<Appointment> appointments = al.getAppointments();
            assertEquals(2, al.length());
            checkAppointment("Kyle", "9:30 pm", appointments.get(0));
            checkAppointment("Andie", "4:00 am", appointments.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
