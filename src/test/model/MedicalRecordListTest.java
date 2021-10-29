package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalRecordListTest {
    private MedicalRecordList ml;

    @BeforeEach
    void runBefore() {
        ml = new MedicalRecordList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, ml.getMedicalRecordList().size());
    }
}
