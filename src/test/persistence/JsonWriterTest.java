package persistence;

import model.MedicalRecord;
import model.MedicalRecordList;
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
    void testWriterEmptyWorkroom() {
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
    void testWriterGeneralWorkroom() {
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
            List<MedicalRecord> records = ml.getMedicalRecordList();
            assertEquals(2, ml.length());
            checkMedicalRecord("kyle", 10, 10, 10, "O", records.get(0));
            checkMedicalRecord("andie", 11, 11, 11, "A", records.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
