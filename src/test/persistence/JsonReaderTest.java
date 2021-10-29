package persistence;

import model.MedicalRecord;
import model.MedicalRecordList;
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
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMedicalRecordList.json");
        try {
            MedicalRecordList ml = reader.readMedicalRecordList();
            List<MedicalRecord> records = ml.getMedicalRecordList();
            assertEquals(2, ml.length());
            checkMedicalRecord("kyle", 18, 174, 80, "O", records.get(0));
            checkMedicalRecord("andie", 20, 120, 68, "A", records.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
