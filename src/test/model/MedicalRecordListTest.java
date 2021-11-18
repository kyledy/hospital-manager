package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalRecordListTest {
    private MedicalRecordList ml;
    private MedicalRecord m;

    @BeforeEach
    void runBefore() {
        ml = new MedicalRecordList();
        m = new MedicalRecord("", 0, 0, 0, "");
    }

    @Test
    void testConstructor() {
        assertEquals(0, ml.getMedicalRecords().size());
    }

    @Test
    void testAddMedicalRecord() {
        ml.addMedicalRecord(m);
        assertEquals(1, ml.getMedicalRecords().size());
    }

    @Test
    void testLength() {
        ml.addMedicalRecord(m);
        assertEquals(1, ml.length());
    }
}
